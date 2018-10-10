package com.opensource.tlv;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * Enum constant that defines the format of a Type Length Value instruction.
 * An example of a TLV String instruction is "UPPRCS-0005-abcde".Here Type is
 * represented by first 6 characters, Length by next 4 characters separated by
 * the Separator "-".
 */
public enum TypeLengthValueFormat {
	
	TYPE (6),
	LENGTH (4),
	SEPARATOR (Separator.TLV_SEPARATOR.value().length());
	
	private int length;
	
	private TypeLengthValueFormat(int length) {
		this.length = length;
	}
	
	public int length() {
		return length;
	}
	
}
