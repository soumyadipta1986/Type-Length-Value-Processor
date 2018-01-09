package tlv_processor;

public class UpperCase implements ProcessingType {
	
	private final Type type = Type.UPPERCASE;
	
	@Override
	public Type getType() {
		return type;
	}
	
	@Override
	public String process(String value) {
		return type.value() + Separator.TLV_SEPARATOR.value() + value.toUpperCase();
	}

}
