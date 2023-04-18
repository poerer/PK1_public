package lesson02;

public class DataTypes {

	public static void main(String[] args)
	{
		System.out.println("--Data Types--");
			basics(); //understand basic initializations
			//valueAssignment(); //nested value assignment
			//logicalCircuit(); //understand logical operators
	}
	/**
	 * Initialization of basic data types
	 */
	public static void basics()
	{
		byte smallest 	= 127; 					//System.out.println("byte: " + smallest);
		short smaller   = 6000; 				//System.out.println("short: " + smaller);
		int medium 		= 640000000; 			//System.out.println("int: " + medium);
		long aLot 		= 40000000000000000L; 	//System.out.println("long: " + aLot); //you need the 'L'
		
		float precise 		= 1.222333444F; 	//System.out.println("float:  " + precise); //Caution
		double morePrecise  = 1.222333444;  	//System.out.println("double: " + morePrecise);
		
		boolean isOpen = true; 		//System.out.println("boolean: " + isOpen);
		
		char character = '\u03BB'; 	//System.out.println("char: " + character);
				
		//Example: no error message but wrong result
		
		byte bad = (byte) (100+80);
			//System.out.println("bad: " + bad);
			//System.out.println("Binary: " + Integer.toBinaryString(180));
		
		
		//Example: casting int to char
		
		char one = '\u03BB';
			//System.out.println("Symbol: " + one);
		
		
		//Example: encoding
		
		short key = 25;
		
		char encodedP = (char) ('P' + key); //P in decimal
		char encodedK = (char) ('K' + key); //K in decimal
		char encoded1 = (char) ('1' + key); //1 in decimal
			//System.out.println("Symbol encoded: " + encodedP + encodedK + encoded1);
		
		char decodedP = (char) (encodedP - key);
		char decodedK = (char) (encodedK - key);
		char decoded1 = (char) (encoded1 - key);
			//System.out.println("Symbol decoded: " + decodedP + decodedK + decoded1);
		
	}	
	/**
	 * A nested value assignment.
	 */
	public static void valueAssignment()
	{
		int a, b; 
		int c = 1;
		int d = 5;
		int e = 8;

		 a = (b = c + d) + e;
				
		// b = c + d;
		// a = b + e;

		System.out.println("a: " + a);
	}
	
	/**
	 * Show how logical operators work
	 */
	public static void logicalCircuit()
	{
		boolean bulb;
		boolean switchA = true;
		boolean switchB = false;
		boolean switchC = false;
		
		bulb = switchA && switchB && switchC;
		//bulb = switchA || switchB || switchC;
		//bulb = switchA && switchB || switchC;
		//bulb = switchA || switchB && switchC;
		//bulb = (switchA || switchB) && switchC;
		
		System.out.println("Bulb glows: " + bulb);
	}
}
