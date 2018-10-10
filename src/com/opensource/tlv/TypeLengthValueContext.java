package com.opensource.tlv;

import com.opensource.tlv.processor.types.ProcessingType;

/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * TypeLengthValueContext is used to associate a TypeLengthValue 
 * object with its corresponding ProcessingType implementation.
 * Context class decouples a TLV instruction from its ProcessingType implementation.
 */
public class TypeLengthValueContext {
	
	private final TypeLengthValue tlv;
	private final ProcessingType processingType;
	
	public TypeLengthValueContext(TypeLengthValue tlv, ProcessingType processingType) {
		if (tlv.getType() != processingType.getType()) {
			throw new IllegalArgumentException("Incorrect Processing Type");
		}
		this.tlv = tlv;
		this.processingType = processingType;
	}
	
	public String process() {
		return processingType.process(tlv.getValue());
	}
}
