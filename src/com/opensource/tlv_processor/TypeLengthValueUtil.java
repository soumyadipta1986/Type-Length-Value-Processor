package com.opensource.tlv_processor;

public class TypeLengthValueUtil {
	
	private static int getLengthOfType() {
		return TypeLengthValueFormat.TYPE.length();
	}
	
	private static int getLengthOfLength() {
		return TypeLengthValueFormat.LENGTH.length();
	}
	
	private static int getLengthOfSeparator() {
		return TypeLengthValueFormat.SEPARATOR.length();
	}	
	
	public static int getCurrentInstructionLength(String tlvInstructionSet) {
		return getLengthOfType() + getLengthOfSeparator() + 
				getLengthOfLength() + getLengthOfSeparator() + getLength(tlvInstructionSet);
	}
	
	public static String getType(String tlvInstruction) {
		return tlvInstruction.substring(0, getLengthOfType());
	}
	
	public static int getLength(String tlvInstruction) {
		int beginIndexOfLength = getLengthOfType() + getLengthOfSeparator();
		int endIndexOfLength = beginIndexOfLength + getLengthOfLength();
		return Integer.parseInt(tlvInstruction.substring(beginIndexOfLength, endIndexOfLength));
	}
	
	public static String getValue(String tlvInstruction) {
		int lengthOfValue = getLength(tlvInstruction);
		int beginIndexOfValue = getLengthOfType() + getLengthOfSeparator() + getLengthOfLength() + getLengthOfSeparator();
		int endIndexOfValue = beginIndexOfValue + lengthOfValue;
		return tlvInstruction.substring(beginIndexOfValue, endIndexOfValue);
	}	
	
}
