package tlv_processor;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.OutputStream;

public class Processor {
	
	private final Map<String, ProcessingType> processingTypes;
	
	public Processor() {
		ProcessingType upperCase = new UpperCase();
		ProcessingType replace = new Replace();
		processingTypes = new HashMap<String, ProcessingType>(2, 1.0f);
		processingTypes.put(upperCase.getType().value(), upperCase);
		processingTypes.put(replace.getType().value(), replace);
	}
	
	public void process(String tlvInstructionSet, OutputStream out) {
		
		if (tlvInstructionSet == null) {
			throw new IllegalArgumentException("TypeLengthValue instuction cannot be null");
		}
		if (tlvInstructionSet.equals("")) {
			throw new IllegalArgumentException("TypeLengthValue instuction cannot be empty");
		}
		if (out == null) {
			throw new IllegalArgumentException("Output Stream cannot be null");
		}
		
		String lineSeparator = System.getProperty("line.separator");
		
		while (!tlvInstructionSet.equals("")) {
			int currentInstructionBeginIndex = 0;
			int nextInstructionBeginIndex = TypeLengthValueUtil.getCurrentInstructionLength(tlvInstructionSet);
			String tlvInstruction = tlvInstructionSet.substring(currentInstructionBeginIndex, nextInstructionBeginIndex);
			String type = TypeLengthValueUtil.getType(tlvInstruction);
			int length = TypeLengthValueUtil.getLength(tlvInstruction);
			String value = TypeLengthValueUtil.getValue(tlvInstruction);
			String tlvOutput = "";
			if (processingTypes.containsKey(type)) {
				ProcessingType processingType = processingTypes.get(type);
				TypeLengthValue tlv = new TypeLengthValue(processingType.getType(), length, value);
				TypeLengthValueContext tlvContext = new TypeLengthValueContext(tlv, processingType);
				tlvOutput = tlvContext.process() + lineSeparator;
			} else {
				tlvOutput = "Type not valid" + lineSeparator; 
			}
			try {
				out.write(tlvOutput.getBytes());
				out.flush();
			} catch (IOException ex) {
				ex.printStackTrace();
			}		
			tlvInstructionSet = tlvInstructionSet.substring(nextInstructionBeginIndex);
		}
		
	}
	
}
