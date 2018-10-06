package com.opensource.tlv_processor;

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
