package com.opensource.tlv;

import com.opensource.tlv.processor.types.Type;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * TypeLengthValue is an immutable class that represents a TLV instruction.
 *
 */
public class TypeLengthValue {
	
	private final Type type;
	private final int length;
	private final String value;
	
	public TypeLengthValue(Type type, int length, String value) {
		this.type = type;
		this.length = length;
		this.value = value;
	}

	public Type getType() {
		return type;
	}

	public int getLength() {
		return length;
	}

	public String getValue() {
		return value;
	}
	
	@Override
	public String toString() {
		return "[Type: " + type + ", Length: " + length + ", Value: " + value + "]";
	}
	
}
