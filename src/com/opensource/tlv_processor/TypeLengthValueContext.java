package com.opensource.tlv_processor;

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
