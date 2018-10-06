package com.opensource.tlv_processor;

public enum TypeLengthValueFormat {
	
	TYPE (6),
	LENGTH (4),
	SEPARATOR (Separator.TLV_SEPARATOR.value().length());
	
	private int length;
	
	private TypeLengthValueFormat(int length) {
		this.length = length;
	}
	
	public int length() {
		return length;
	}
	
}
