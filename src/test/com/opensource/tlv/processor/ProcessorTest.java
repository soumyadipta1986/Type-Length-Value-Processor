package test.com.opensource.tlv.processor;

import java.util.Scanner;

import com.opensource.tlv.processor.Processor;
/**
 * Copyright (c) 2018. Open source Project.
 * 
 * @author Soumyadipta Sarkar
 * 
 * ProcessorTest initiates only one instance of Processor. Then it takes TLV instructions 
 * from either StdIn or File and invokes processor.process() method. Execution of ProcessorTest 
 * stops when it receives "end" or "END" from StdIn/File.
 * 
 * Assumption:
 * All data in ASCII
 * No malformed TLV
 */
public class ProcessorTest {

	public static void main(String[] args) {
		Processor processor = new Processor();
		Scanner scanner = new Scanner(System.in);
		String tlvInstructionSet = "";
		while(!(tlvInstructionSet = scanner.next()).equalsIgnoreCase("END")) {
			processor.process(tlvInstructionSet, System.out);
		}
		scanner.close();
	}

}
