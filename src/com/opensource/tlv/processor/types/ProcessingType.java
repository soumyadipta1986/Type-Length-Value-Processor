package com.opensource.tlv.processor.types;
/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * Interface to define necessary methods that must be
 * overridden by any ProcessingType implementation.
 *
 */
public interface ProcessingType {
		
	/**
	 * Returns Type associated with the ProcessingType
	 * @return Type of the ProcessingType
	 */
	Type getType();
	
	/**
	 * Processes the input value and returns the same.
	 * @param value Value that must be processed 
	 * @return processed Value
	 */
	String process(String value);

}
