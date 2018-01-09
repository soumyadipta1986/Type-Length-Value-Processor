package tlv_processor;

import java.util.Scanner;

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
