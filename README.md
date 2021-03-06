TypeLengthValue (TLV) Processor:

Process TLVs with the following format 
	Format: TYPE(6)-LENGTH(4)-VALUE
	Type - fixed 6 chars length. Defines the type of processing required.
	Length - fixed 4 chars (represented as text) length of the value.
	Value - the actual data to be processed of length 'Length' above.
	
Processing Requirements
	For Type UPPRCS: convert the value to upper case, if already in upper case, do nothing.
	For Type REPLCE: replace the value with fixed string "THIS STRING".
	For any other type indicate an error “Type not valid” and continue processing.
	Output should be printed as the TLVs are processed.
	Input is specified on StdIn and output is expected on StdOut.
	Assume all data is in ASCII.
	Assume all data will always follow the format specified, i.e. no malformed TLVs.
	
Coding Requirements:
	Create a jar file name "tlvprocessor.jar" with all the dependencies used in the project.
	Design for extensibility, which will help to easily add 
		o New input-output types like network streams 
		o New processors like LOWRCS

Sample Test Cases: 
This is one of test case suite that can be used for evaluation.

The test is run as follow: 
java -jar tlvprocessor.jar < input 

Note: The input is still from STDIN.

Input: 
UPPRCS-0005-abcde 
REPLCE-0003-123 
UPPRCS-0008-AbcdefghREPLCE-0003-123REPLCE-0001-Z 
TAG001-0012-abcdefgh1234 
UPPRCS-0004-1234

Output: 
UPPRCS-ABCDE 
REPLCE-THIS STRING 
UPPRCS-ABCDEFGH 
REPLCE-THIS STRING 
REPLCE-THIS STRING 
Type not valid 
UPPRCS-1234


Refer package-info.java for package details.


Type Length Value Processor has been implemented using Strategy Design Pattern. 
