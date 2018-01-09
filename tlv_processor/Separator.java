package tlv_processor;

public enum Separator {
	
	TLV_SEPARATOR ("-");
	
	private String tlvSeparator;
	
	private Separator(String tlvSeparator) {
		this.tlvSeparator = tlvSeparator;
	}
	
	public String value() {
		return tlvSeparator;
	}
	
}
