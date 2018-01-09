package tlv_processor;

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
	
}
