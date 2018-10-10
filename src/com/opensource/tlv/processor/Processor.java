package com.opensource.tlv.processor;

import java.util.Map;
import java.util.HashMap;
import java.io.IOException;
import java.io.OutputStream;

import com.opensource.tlv.TypeLengthValue;
import com.opensource.tlv.TypeLengthValueContext;
import com.opensource.tlv.TypeLengthValueUtil;
import com.opensource.tlv.processor.types.ProcessingType;
import com.opensource.tlv.processor.types.Replace;
import com.opensource.tlv.processor.types.UpperCase;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * This is the outer most class that will be invoked by a client code. It has the capability to
 * invoke appropriate ProcessingType for a Type Length Value instruction.
 *  
 * Assumption:
 * All data in ASCII
 * No malformed TLV
 * 
 * Client code is supposed to initiate only one instance of Processor. Then client code can take 
 * TLV instructions from either StdIn or File and invoke process() method of Processor.
 */
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
