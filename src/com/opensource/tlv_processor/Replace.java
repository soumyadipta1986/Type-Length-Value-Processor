package com.opensource.tlv_processor;

public class Replace implements ProcessingType {
	
	private final Type type = Type.REPLACE;
	
	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public String process(String value) {
		return type.value() + Separator.TLV_SEPARATOR.value() + "THIS STRING";
	}

}
