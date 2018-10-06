/**
 * This package provides necessary classes and interfaces of TypeLengthValue (TLV) processor. 
 * TLV processor has been implemented using Strategy Design Pattern.
 * 
 * Type.java is an Enum of possible types i.e. UPPRCS and REPLCE that can be handled by the processor.
 * TypeLengthValue.java is an immutable class to store Type, Length and Value of a TLV instruction. 
 * ProcessingType.java is an interface.
 * UpperCase.java and Replace.java are the implementations of ProcessingType. Both are immutable class. 
 * TypeLengthValueContext.java is a context class that stores a TLV reference and an appropriate ProcessingType.
 * Separator.java is an Enum that defines the separator used in a TLV instruction to separate Type, Length and Value.
 * TypeLengthValueFormat.java is an Enum that defines the format of a TLV instruction.
 * TypeLengthValueUtil.java is a static utility class that contains helper methods to parse a TLV instruction.
 * Processor.java is the outer most class that will be invoked by a client code. It has the capability to call 
 * appropriate ProcessingType for a TLV instruction.
 *  
 * ProcessorTest.java takes TLV instructions from StdIn/File and invokes Processor to execute the same.
 * 
 * Assumption:
 * All data in ASCII
 * No malformed TLV
 * ProcessorTest class initiates only one instance of Processor. Then it takes TLV instructions from wither StdIn or File
 * and invokes process() method of Processor. Execution of ProcessorTest stops when it receives "end" or "END" from StdIn/File.
 * 
 * @author Soumyadipta Sarkar
 */
package com.opensource.tlv_processor;