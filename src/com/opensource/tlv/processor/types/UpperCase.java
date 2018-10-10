package com.opensource.tlv.processor.types;

import com.opensource.tlv.Separator;
/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * This implementation is associated with Type.UPPERCASE and it
 * converts the Value of a TLV instruction to upper case.
 */
public class UpperCase implements ProcessingType {
	
	private final Type type = Type.UPPERCASE;
	
	/*
	 * Returns Type.UPPERCASE
	 * @see com.opensource.tlv.processor.types.ProcessingType#getType()
	 */
	@Override
	public Type getType() {
		return type;
	}
	
	/*
	 * Converts the input value to upper case and returns the same.
	 * @see com.opensource.tlv.processor.types.ProcessingType#process(java.lang.String)
	 */
	@Override
	public String process(String value) {
		return type.value() + Separator.TLV_SEPARATOR.value() + value.toUpperCase();
	}

}
