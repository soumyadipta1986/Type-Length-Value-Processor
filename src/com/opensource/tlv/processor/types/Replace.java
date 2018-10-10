package com.opensource.tlv.processor.types;

import com.opensource.tlv.Separator;
/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * This implementation is associated with Type.REPLACE and it
 * replaces the Value of a TLV instruction by a constant text "THIS STRING".
 */
public class Replace implements ProcessingType {
	
	private final Type type = Type.REPLACE;
	
	/*
	 * Returns Type.REPLACE
	 * @see com.opensource.tlv.processor.types.ProcessingType#getType()
	 */
	@Override
	public Type getType() {
		return type;
	}
	
	/*
	 * Replaces the input value with a constant text "THIS STRING".
	 * @see com.opensource.tlv.processor.types.ProcessingType#process(java.lang.String)
	 */
	@Override
	public String process(String value) {
		return type.value() + Separator.TLV_SEPARATOR.value() + "THIS STRING";
	}

}
