package lesson02Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_data_types.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Primitive_Datentypen
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_003.htm
 */

/**
 * (*1*)
 * Data types are divided into two groups:
 * Primitive data types - include byte, short, int, long, float, double, boolean and char
 * Reference types - such as String, Arrays and Classes (later chapters)
 */
public class DataTypes
{
	/**
	 * Introduction to primitive data types.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		/* Assigning a DATA TYPE to a variable name is called DECLARATION
		 * The name of the variable should be written in camel case and starts
		 * with a lower case letter e.g., firstName, playerCount, camelCaseName.
		 * Some more rules:
		 * 	- names can contain letters, digits, underscores, and dollar signs
		 *	- names must begin with a letter
		 *	- names should start with a lowercase letter and it cannot contain whitespace
		 *	- names are case sensitive ("myVar" and "myvar" are different variables)
		 *	- reserved words (like Java keywords, such as int or boolean) cannot be used as names
		 * 
		 * After assigning a data type to a variable you are defining the values margin 
		 * and the operators you can use together with this variable.
		 * 
		 * If you get an error message like 'cannot be resolved to a variable'
		 * this means that you have to assign a DATA TYPE to this variable first.
		 */
		byte height;
		//Since we declared the variable 'height' being of DATA TYPE byte we can store
		//numbers in this variable. This step is called INITIALIZATION.
		height = 10;
		//Now, we can work with the variable and apply mathematical operations.
		System.out.println("Even or odd: " + height % 2); //check, whether height is even (result 0) or odd (result 1)
		
		/*
		 * The DATA TYPE byte has the smallest value range.
		 * The highest number you can store in a byte is 127 and the lowest -128.
		 * A byte consists of 8 bits with the first bit being responsible for the sign:
		 *  0    0000000
		 *  ^		^
		 * sign	  values
		 * 
		 * 00100101
		 * 	 ^  ^ ^
		 *   32+4+1 => 37
		 * 10010000
		 * ^  ^
		 * -  16	=> -128 + 16 = -112 
		 */
		
		/*
		 * In order to assign higher numbers to variables 
		 * you have to switch to a different DATA TYPE.
		 * Alternatives are (ordered according to value ranges):
		 * short 	(16 bits)
		 * int		(32 bits)
		 * long		(64 bits)
		 */
		short s = 32767; 				System.out.println("short: " + s);
		int i = 2147483647; 			System.out.println("int: " + i);
		//try to remove the L.
		long l = 9223372036854775807L; 	System.out.println("long: " + l); 
		/*					        ^ 
		 * The L is important to tell the compiler to interpret this number as a long.
		 * The default is an integer and, therefore, would result in an error (out of range). 
		 */
		
		/*
		 * byte, short, int, long are DATA TYPES to store integer values.
		 * In case you want to store floating point numbers, you have to
		 * switch to float or double as DATA TYPE.
		 */
		float comma = 1.222333444F; 	System.out.println("float: " + comma); //Caution
		double comma2 = 1.222333444; 	System.out.println("double: " + comma2);
		/*
		 * The difference between float and double is the precision. 
		 * double is more precise and the default (like int for integer values).
		 * If you want to store a floating point number as float, you have to
		 * indicate this by using an 'F' e.g., 1.222333444F. 
		 * As you can see on the console (after running the code) the output for the float
		 * is chopped and rounded (in comparison to the double).
		 * 
		 * The value range of a double is so big because it separates the values in
		 * the exponent (11 bits) and mantissa (52 bits).
		 * 0   00000000000   0000000000000000000000000000000000000000000000000000
		 * ^		^								^
		 * sign	exponent						mantissa		
		 * 
		 * A sign bit of zero indicates a positive number and a sign bit of one indicates 
		 * a negative number. 
		 * The mantissa is always interpreted as a positive base-two number. 
		 * It is not a twos-complement number. If the sign bit is one, the floating-point value 
		 * is negative, but the mantissa is still interpreted as a positive number that must be 
		 * multiplied by -1.
		 * 
		 * More details about floating point numbers can be found here:
		 * https://www.javaworld.com/article/2077257/floating-point-arithmetic.html
		 * 
		 */
		
		/*
		 * A boolean DATA TYPE is declared with the boolean keyword 
		 * and can only take the values true or false.
		 * Boolean values are mostly used for conditional testing.
		 */
		boolean isOpen = true; System.out.println("boolean: " + isOpen);
		
		/*
		 * The char data type is used to store a single character. 
		 * The character must be surrounded by single quotes, like 'A' or 'c'.
		 * Alternatively, you can use decimal values or unicode encodings.
		 */
		char character= 'A';	System.out.println("character: " + character);
		char decimal = 955;  System.out.println("decimal value: " + decimal);
		char unicode ='\u03BB'; System.out.println("unicode: " + unicode);
		/*
		 * It is important to note that only a single symbol is stored in a char.
		 * For multiple symbols you have to switch to String as data type.
		 * However, Strings are NO primitive DATA TYPES and, therefore, not
		 * covered in this session. We will have an entire lecture about Strings
		 * at the end of the semester.
		 */
		String multiSymbols = "abc"; System.out.println("multiple symbols: " + multiSymbols);
	}
	//->switch to DataTypesCasting.java (*2*)
}
