package com.opensource.tlv_processor;

public interface ProcessingType {
		
	Type getType();
	
	String process(String value);

}
