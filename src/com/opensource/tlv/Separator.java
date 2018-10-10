package com.opensource.tlv;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * Separator enum constant separates Type, Length and Value in a TLV String instruction.
 * An example of a TLV String instruction is "UPPRCS-0005-abcde" where Type is "UPPRCS",
 * Length is 5, Value is "abcde" and "-" is the separator.
 */
public enum Separator {
	
	TLV_SEPARATOR ("-");
	
	private String value;
	
	private Separator(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
}
