package lesson02Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_operators.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Operatoren
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_005.htm
 */

/**
 * (*3*)
 * The declaration of a variable determines the value range and the OPERATORS
 * you can use together with this variable.
 * There are different kinds of OPERATORS:
 * - Arithmetic operators
 * - Assignment operators
 * - Comparison operators
 * - Logical operators
 * - Bitwise operators
 */
public class Operators
{
	public static void main(String[] args)
	{
		//Arithmetic operators are used to perform common mathematical operations
		// +	Adds together two values x + y
		int add = 5 + 6;			System.out.println("Add: " + add);
		
		// -	Subtracts one value from another x - y
		short subtract = 10 - 100;	System.out.println("Subtract: " + subtract);
		
		// *	Multiplies two values	x * y
		byte multiply = 3 * 10;		System.out.println("Multiply: " + multiply);
		
		// /	Divides one value from another	x / y
		int divide = 10 / 4;		System.out.println("Divide: " + divide);
		/* As you can see, the result is an integer and, therefore, not able to
 		   display floating point numbers. Everything after the comma is simply cut.
 		 */
		double div = 10 / 4;		System.out.println("Divide: " + div);
		/* Just storing the result in a double does not solve the problem.
		 * The statement on the right is evaluated as an integer (without decimal place).
		 * Therefore, everything after the comma is cut. The result is then stored in 
		 * a double, which results in something .0.
		 * To keep the decimal places, you have to change one of the data types on the right
		 * to a double. As a result the entire calculation will be performed on floating point
		 * numbers. Then you can store the result in a variable of type float or double.  
		 */
		double divCorrect = 10.0 / 4; System.out.println("Divide correct: " + divCorrect);
		
		// %	Modulus, returns the division remainder	x % y
		int mod = 10 % 4;			System.out.println("Modulo: " + mod);
		
		// ++	Increment, increases the value of a variable by 1	++x
		// --	Decrement, decreases the value of a variable by 1	--x
		/* There are two different kinds of increments and decrements, namely post and pre.
		 * Pre increment and decrement are performed BEFORE the statement gets evaluated.
		 * Post increment and decrement are performed AFTER the statement got evaluated.
		 */
		int a = 1;
		System.out.println("Difference between Pre and Post increment/decrement"); //this is a statement
		System.out.println("Increment: " + ++a); //Pre increment, the variable is incremented and then printed to the console
		System.out.println("Increment: " + a++); //Post increment, the variable is printed to the console and then incremented
		/*
		 * To make things easier, ALWAYS increment a variable in its own statement. 
		 * Same thing is true for the decrement operator.
		 */
		a--;
		--a;
		System.out.println("Decrement: " + a);
		
		//Priorities are based on mathematics
		int result = 5 + 10 * (2 + 1);				System.out.println("Result: " + result);
		
		System.out.println();
		// Assignment operators are used to assign values to variables.
		int assign = 10;
		// it is possible to combine arithmetic operators with the assignment operator.
		assign += 10; // same as x = x + 10;
		assign -= 10; // same as x = x - 10;
		System.out.println("Assignment: " + assign);
		/*
		 * If you get an error message like 'the local variable may not have been initialized'
		 * you forgot to assign a value to this variable.
		 */
		
		System.out.println();
		//Comparison operators are used to compare two values
		//The result is a boolean (true or false)
		// ==	equal to	x == y
		boolean equal = 5 == 6; 		System.out.println("Equal: " + equal);
		/*
		 * You have to be careful with floating point numbers.
		 * In the binary system floating point numbers are often rounded.
		 * That is why you should NOT compare floats and/or doubles using the operator ==
		 * Example:
		 */
		boolean problem = 2.0 == (2.05 - 0.05); System.out.println("Problem: " + problem);
		/* 
		 * Obviously, this statement should evaluate to true, however, it returns false.
		 * To solve this issue, you can either introduce a threshold (see tutorial or assignment), or
		 * you can use BigDecimal (which is a reference type we have not covered in the lecture, yet).
		 * In BigDecimal class, you can specify the rounding mode and exact precision which you want to use. 
		 * Using the exact precision limit, rounding errors are mostly solved.
		 * You can use it’s compareTo() method to compare to BigDecimal numbers.
		 */
		
		// !=	not equal	x != y
		boolean notEqual = 'a' != 'b';	System.out.println("Not equal: " + notEqual);
		
		// >	greater than	x > y
		boolean greater = 10 > 5;		System.out.println("Greater: " + greater);
		
		// <	less than	x < y
		boolean less = 10 < 5;			System.out.println("Less: " + less);
		
		// >=	greater than or equal to	x >= y
		boolean greaterEqual = 10 >= 5;	System.out.println("Greater equal: " + greaterEqual);
		
		// <=	less than or equal to	x <= y
		boolean lessEqual = 10 <= 5;	System.out.println("Less equal: " + lessEqual);
		
		System.out.println();
		//Logical operators are used to determine the logic between variables or values
		//The result is a boolean (true or false)
		// && 	logical and	returns true if both statements are true		x < 5 &&  x < 10
		int x = 7;
		boolean and = x < 5 && x < 10; 		System.out.println("logical and: " + and);
		
		// || 	logical or	returns true if one of the statements is true	x < 5 || x < 4
		boolean or = x < 5 || x < 10; 		System.out.println("logical or: " + or);
		
		// !	logical not	reverse the result, returns false if the result is true	!(x < 5 && x < 10)
		boolean not = !(x < 5 || x < 10); 	System.out.println("not: " + not);
		
		//&& has the higher priority in comparison to ||
		boolean lightBulb = true || true && false;		System.out.println("Lightbulb: " + lightBulb);
		
		
		/*
		 * Bitwise operators are not covered in this lecture.
		 * For information about this content see:
		 * https://docs.oracle.com/javase/tutorial/java/nutsandbolts/op3.html
		 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_12_001.htm
		 */
		//->DONE
	}
}
