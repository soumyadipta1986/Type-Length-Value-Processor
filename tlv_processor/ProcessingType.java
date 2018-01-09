package tlv_processor;

public interface ProcessingType {
		
	Type getType();
	
	String process(String value);

}
