package lesson02Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_type_casting.asp
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_005.htm
 */

/**
 * (*2*)
 * There are two different kinds of castings
 * Implicit casting: is done automatically without information loss
 * Explicit casting: you have to tell the compiler to do the type cast.
 * Possible loss of information.
 * 
 * @author fuchs
 *
 */
public class DataTypesCasting
{
	public static void main(String[] args)
	{
		/*
		 * Type casting is when you assign a value of one primitive data type to another type.
		 * However, there is no way to cast something to boolean.
		 * 
		 * byte -> short -> int -> long -> float -> double
		 * 		   			^
		 * 					|
		 * 		   char ----- 
		 * 
		 * implicit casting (widening casting) is done automatically.
		 * Converting a smaller type to a larger type size
		 */
		byte small = 127;
		int big = small;				System.out.println("Implicit casting: " + big);
		
		/*
		 * Explicit casting (narrowing casting) is done manually.
		 * Converting a larger type to a smaller size type
		 */
		short bigger = 127;
		byte smaller = (byte) bigger;	System.out.println("Explicit casting: " + smaller);
		/*
		 *  Since the value 127 perfectly fits in a byte, there is no information loss.
		 *  However, if we increase the value to e.g., 180 the result is not correct anymore.
		 */
		byte bad = (byte) 180;			System.out.println("bad: " + bad);
		/*
		 * When we check the bits, we can investigate what happens. 
		 */
		System.out.println("Binary: " + Integer.toBinaryString(180));
		/*
		 * The first bit of the byte is used to encode the value:
		 * 10110100
		 * 128 + 32 + 16 + 4 = 180
		 *  ^
		 * (sign)
		 * However, the first bit is responsible for the sign. 
		 * As a result we get the value -76
		 * -128 + 32 + 16 + 4 = -76
		 */
		
		//other examples
		byte value = 120;
		char symbol = (char) value;				System.out.println("Symbol: " + symbol);
		     symbol = (char) (symbol + 100);	System.out.println("Symbol: " + symbol);
		     symbol = 'x' + 100;				System.out.println("Symbol: " + symbol);
		/*
		 * As you can see in this example, in line 65 and 66 an explicit cast is necessary.
		 * However, in line 67 the cast is not necessary.
		 * The difference is the use of a variable on the right hand side.
		 * The compiler does not know what will happen with the variable. It could be that
		 * the value stored in the variable is really high, therefore, there is the chance 
		 * of an overflow.
		 * The value range of a char is 0 - 65535 because the first bit is NO sign.
		 */
		 char last = 65535;						System.out.println("Last: " + last);
		 char first = 0;						System.out.println("First: " + first);
	}
	//->switch to Operators.java (*3*)
}
