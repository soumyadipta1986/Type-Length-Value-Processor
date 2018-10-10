package com.opensource.tlv;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * Utility class contains methods that are 
 * used to parse a Type Length Value instruction.
 */
public class TypeLengthValueUtil {
	
	/**
	 * Returns length of Type of a Type-Length-Value instruction.
	 * @return length of Type
	 */
	private static int getLengthOfType() {
		return TypeLengthValueFormat.TYPE.length();
	}
	
	/**
	 * Returns length of Length of a Type-Length-Value instruction.
	 * @return length of Length
	 */
	private static int getLengthOfLength() {
		return TypeLengthValueFormat.LENGTH.length();
	}
	
	/**
	 * Returns length of the Separator used in Type-Length-Value instruction. 
	 * @return length of Separator
	 */
	private static int getLengthOfSeparator() {
		return TypeLengthValueFormat.SEPARATOR.length();
	}	
	
	/**
	 * Returns Type of a Type-Length-Value instruction.
	 * @param tlvInstruction Type-Length-Value instruction
	 * @return Type of a Type-Length-Value instruction
	 */
	public static String getType(String tlvInstruction) {
		return tlvInstruction.substring(0, getLengthOfType());
	}
	
	/**
	 * Returns length of Value String of a Type-Length-Value instruction
	 * @param tlvInstruction Type-Length-Value instruction
	 * @return length of Value String of a Type-Length-Value instruction 
	 */
	public static int getLength(String tlvInstruction) {
		int beginIndexOfLength = getLengthOfType() + getLengthOfSeparator();
		int endIndexOfLength = beginIndexOfLength + getLengthOfLength();
		return Integer.parseInt(tlvInstruction.substring(beginIndexOfLength, endIndexOfLength));
	}
	
	/**
	 * Returns Value of a Type-Length-Value instruction
	 * @param tlvInstruction Type-Length-Value instruction
	 * @return Value of a Type-Length-Value instruction
	 */
	public static String getValue(String tlvInstruction) {
		int lengthOfValue = getLength(tlvInstruction);
		int beginIndexOfValue = getLengthOfType() + getLengthOfSeparator() + getLengthOfLength() + getLengthOfSeparator();
		int endIndexOfValue = beginIndexOfValue + lengthOfValue;
		return tlvInstruction.substring(beginIndexOfValue, endIndexOfValue);
	}
	
	/**
	 * Returns the first Type-Length-Value instruction present in the instruction set.
	 * @param tlvInstructionSet a set of Type-Length-Value instructions
	 * @return Type-Length-Value instruction
	 */
	public static int getCurrentInstructionLength(String tlvInstructionSet) {
		return getLengthOfType() + getLengthOfSeparator() + 
				getLengthOfLength() + getLengthOfSeparator() + getLength(tlvInstructionSet);
	}	
	
}
