package lesson04Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_arrays.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Arrays
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_03_007.htm
 */

/**
 * (*2*)
 * Introduction to arrays.
 * An array is a container that holds a fixed number of values of a single type.
 * The length of an array is established when the array is created. After creation,
 * its length is fixed. 
 * 
 * @author fuchs
 *
 */
public class Arrays
{
	public static void main(String[] args)
	{
		/*
		 * an array is a container in which all elements have the same data type.
		 * You are not allowed to mix data types.
		 * char:
		 * 		['a', 'd', '?']
		 * 
		 * boolean:
		 * 		[true, false, false, true]
		 * 
		 * int:
		 * 		[1, 2, 3, 4, 5, 6]
		 *  	 ^           ^
		 * index 0			 4
		 * length of the array (nr of elements) = 6
		 * Each item in an array is called an element, and each element is accessed 
		 * by its numerical index. As shown in the preceding illustration, numbering 
		 * begins with 0. The 6th element, for example, would therefore be accessed 
		 * at index 5. As you can see the length of the array is always higher than the 
		 * highest index. The reason is simple: the first index is 0 and NOT 1. This
		 * is important to memorize when it comes to loops.
		 */
		
		//explaining fundamentals of arrays
		arraysBasics();
		System.out.println();
		
		//explaining multi-dimensional arrays
		multiDimensionalArrays();
		System.out.println();
		
		//arrays and loops
		arrayLoop();
		System.out.println();
		
		//example: reverse a char array
		char[] letters = {'a', 'r', 'r', 'a', 'y'};
		printReverse(letters);
		//->DONE
	}
	
	public static void arraysBasics()
	{
		/*
		 * The following program creates an array of integers, puts some values 
		 * in the array, and prints each value to standard output.
		 */
		int[] anArray; 			//declares an array of integers
		/*
		 * Like declarations for variables of other types, an array declaration 
		 * has two components: the array's type and the array's name. An array's 
		 * type is written as type[], where type is the data type of the contained 
		 * elements; the brackets are special symbols indicating that this variable 
		 * holds an array. The size of the array is not part of its type (which is 
		 * why the brackets are empty). An array's name can be anything you want, 
		 * provided that it follows the rules and conventions. As with variables 
		 * of other types, the declaration does not actually create an array; 
		 * it simply tells the compiler that this variable will hold an array of 
		 * the specified type.
		 * Similarly, you can declare arrays of other types:
		 * 		byte[] anArrayOfBytes;
		 * 		short[] anArrayOfShorts;
		 * 		long[] anArrayOfLongs;
		 * 		float[] anArrayOfFloats;
		 * 		double[] anArrayOfDoubles;
		 * 		boolean[] anArrayOfBooleans;
		 * 		char[] anArrayOfChars;
		 */
		anArray = new int[3];	//allocates memory for 3 integers
		/*
		 * One way to create an array is with the new operator.
		 * If this statement is missing, then the compiler prints an error 
		 * like the following, and compilation fails:
		 * 'Variable anArray may not have been initialized'.
		 * 
		 * The next few lines assign values to each element of the array:
		 */
		anArray[0] = 100;		//initialize first element
		anArray[1] = 30;		//initialize second element
		anArray[2] = -5;		//initialize third element
		/*
		 * In a real-world programming situation, you would probably use one of 
		 * the supported looping constructs to iterate through each element of 
		 * the array, rather than write each line individually as in the preceding 
		 * example. However, the example clearly illustrates the array syntax.
		 */
		
		//Each array element is accessed by its numerical index (0, 1, 2):
		System.out.println("second element: " + anArray[1]); //change the index to access the other values.
		
		/*
		 * Alternatively, you can use the shortcut syntax to create and 
		 * initialize an array:
		 */
		int[] arrayShort = {100, 30, -5};
		/*
		 * Here the length of the array is determined by the number of values 
		 * provided between braces and separated by commas.
		 */
		System.out.println("third element: " + arrayShort[2]); //change the index to access the other values.
		
		/*
		 * Finally, you can use the built-in length property to determine 
		 * the size of any array. The following code prints the array's size:
		 */
		System.out.println("length of the array: " + anArray.length);
		
		/*
		 * If you get the following error message:
		 * 'java.lang.ArrayIndexOutOfBoundsException'
		 * then you know that the index does not fit your array size.
		 */
	}
	
	/**
	 * You can also declare an array of arrays (also known as a multidimensional array) 
	 * by using two or more sets of brackets. Each element, therefore, must be accessed 
	 * by a corresponding number of index values.
	 */
	public static void multiDimensionalArrays()
	{
		/*
		 * In the Java programming language, a multidimensional array is an array 
		 * whose components are themselves arrays. A consequence of this is that 
		 * the rows are allowed to vary in length, as shown in the following program:
		 */
		String[][] names = {{"Mr. ", "Mrs. ", "Ms. "}, {"Smith", "Jones"}};
	    // Mr. Smith
	    System.out.println("multidimensional arrays: " + names[0][0] + names[1][0]);
	    // Ms. Jones
	    System.out.println("multidimensional arrays: " + names[0][2] + names[1][1]);
	}
	
	/**
	 * Loops are a convenient way to traverse an array.
	 * Well-suited is the for loop because of its control variable.
	 */
	public static void arrayLoop()
	{
		//initialize an array
		boolean[] anArray = {true, false, false, true};
		
		//traverse the array using a for-loop
		for(int i = 0; i < anArray.length; i++)
		{//		^   ^			^			^
	//start: index=0; index < array length; increase the index after executing the body
			//use the control variable as index
			anArray[i] = !anArray[i]; // this line swaps the value of the boolean array
			System.out.println("for loop and array: " + anArray[i]);
		}
		
		//enhanced for loop; no index is available
		for(boolean content: anArray)
		{
			//since we have no index we cannot access anArray
			System.out.println("enhanced for loop and array: " + content);
		}
		
		/*
		 * In case of a multi-dimensional array we need a control variable
		 * for each nested array e.g., three-dimensional = 3 control variables
		 */
		int[][] multiArray = new int[2][3];
		//use a nested for-loop to fill the array with values:
		for(int i = 0; i < multiArray.length; i++)
		{
			for(int j = 0; j < multiArray[i].length; j++)
			{
				multiArray[i][j] = ((i + 1) * (j + 1) * 10) % 3;				
			}
		}
		
		//print the content of the multi-dimensional array
		for(int i = 0; i < multiArray.length; i++)
		{
			System.out.print("multi-dimensional array: ");
			for(int j = 0; j < multiArray[i].length; j++)
			{
				System.out.print(multiArray[i][j] + " ");				
			}
			System.out.println();
		}
	}
	
	/**
	 * Print a char array in reverse order to the console
	 * @param letters - char array to be printed in reverse order to the console
	 */
	public static void printReverse(char[] letters)
	{
		//get the last index position and decrease the index till it is 0
		System.out.print("for-loop reverse order: ");
		for(int i = letters.length - 1; i >= 0; i--)
		{
			System.out.print(letters[i]);
		}
		System.out.println();
		
		//we can also do the same thing with a while loop
		System.out.print("while-loop reverse order: ");
		int index = letters.length - 1;
		while(index >= 0)
		{
			System.out.print(letters[index]);
			index--;
		}
		System.out.println();
	}
}
