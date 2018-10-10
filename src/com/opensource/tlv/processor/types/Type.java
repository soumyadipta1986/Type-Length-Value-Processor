package com.opensource.tlv.processor.types;
/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * Enum constant that defines valid Processing Types.
 */
public enum Type {
	
	UPPERCASE ("UPPRCS"),
	REPLACE ("REPLCE");
	
	private String value;
	
	private Type(String value) {
		this.value = value;
	}
	
	public String value() {
		return value;
	}
	
}
