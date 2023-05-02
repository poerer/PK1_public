package lesson04Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_while_loop.asp
 * https://www.w3schools.com/JAVA/java_for_loop.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Kontrollstrukturen
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_007.htm
 */

/**
 * (*1*)
 * Introduction to loops (while, do while, for).
 * The statements inside your source files are generally executed from top to bottom, 
 * in the order that they appear. Control flow statements, however, break up the flow 
 * of execution by employing decision making, looping, and branching, enabling your 
 * program to conditionally execute particular blocks of code.
 * 
 * @author fuchs
 *
 */
public class Loops
{
	
	public static void main(String[] args)
	{
		//explaining the while loop
		whileLoop();
		System.out.println();
		
		//explaining the do-while loop
		doWhileLoop();
		System.out.println();
		
		//explaining the for loop
		forLoop();
		System.out.println();
		
		//explaining the enhanced for loop
		enhancedForLoop();
		System.out.println();
		
		//example: print all even numbers up till a certain value
		printEvenNumbers(99);
	}
	
	/**
	 * The while statement continually executes a block of statements 
	 * while a particular condition is true.
	 */
	public static void whileLoop()
	{
		/*
		 * The while statement evaluates an expression, which must return a boolean value. 
		 * If the expression evaluates to true, the while statement executes the 
		 * statement(s) in the while block. The while statement continues testing 
		 * the expression and executing its block until the expression evaluates to false. 
		 * Using the while statement to print the values from 1 through 10 can be 
		 * accomplished as in the following code snippet:
		 */
		int count = 1;
        while (count < 4) 
        {
        	//new block -> keep in mind the visibility of local variables!
            System.out.println("while loop: count is: " + count);
            count++;
        }
	}
	
	/**
	 * The Java programming language also provides a do-while statement.
	 */
	public static void doWhileLoop()
	{
		/*
		 * The difference between do-while and while is that do-while evaluates 
		 * its expression at the bottom of the loop instead of the top. Therefore, 
		 * the statements within the do block are always executed at least once, 
		 * as shown in the following program:
		 */
		int count = 1;
        do 
        {
            System.out.println("do while loop: count is: " + count);
            count++;
        } while (count < 1); //check expression after executing the statements in the block
	}
	
	/**
	 * The for statement provides a compact way to iterate over a range of values. 
	 * Programmers often refer to it as the "for loop" because of the way in which
	 * it repeatedly loops until a particular condition is satisfied.
	 */
	public static void forLoop()
	{
		/*
		 * for(initialization; termination; increment) 
		 * {
		 * 	  statement(s)
		 * }
		 * 
		 * When using this version of the for statement, keep in mind that:
		 * The initialization expression initializes the loop; 
		 * it is executed once, as the loop begins.
		 * When the termination expression evaluates to false, the loop terminates.
		 * The increment expression is invoked after each iteration through the loop; 
		 * it is perfectly acceptable for this expression to increment or decrement a value.
		 * 
		 * The following program uses the general form of the for statement to 
		 * print the numbers 1 through 10 to standard output:
		 */
		for(int i = 1; i < 11; i++)
		{
            System.out.println("for loop: count is: " + i);
        }
		/*
		 * Notice how the code declares a variable within the initialization 
		 * expression. The scope of this variable extends from its declaration 
		 * to the end of the block governed by the for statement, so it can be 
		 * used in the termination and increment expressions as well. If the 
		 * variable that controls a for statement is not needed outside of the 
		 * loop, it's best to declare the variable in the initialization 
		 * expression. The names i, j, and k are often used to control for loops; 
		 * declaring them within the initialization expression limits their 
		 * life span and reduces errors.
		 * 
		 * The three expressions of the for loop are optional.
		 */
	}
	
	/**
	 * The for statement also has another form designed for iteration through 
	 * Collections and arrays. This form is sometimes referred to as the 
	 * enhanced for statement, and can be used to make your loops more compact 
	 * and easy to read.
	 */
	public static void enhancedForLoop()
	{
		/*
		 * To demonstrate, consider the following array, which holds the 
		 * numbers 1 through 5 (see the file Arrays.java for details about arrays)
		 */
		int[] numbers = {1, 2, 3, 4, 5};
		//The following program uses the enhanced for loop to loop through the array:
		for (int item : numbers) 
		{
            System.out.println("enhanced for loop: count is: " + item);
        }
		/*
		 * In this example, the variable item holds the current value from the 
		 * numbers array. We recommend using this form of the for statement instead 
		 * of the general form whenever possible.
		 * Advantage: readability, shorter code
		 * Disadvantage: no access to the index -> cannot easily change values
		 * in the array. 
		 */
	}
	
	/**
	 * Example: this method prints all even numbers from 0 to a given number
	 * @param value - the maximum number up till which even numbers
	 * will be printed
	 */
	public static void printEvenNumbers(int value)
	{
		//while loop
		while(value > 0) //execute statements as long value is greater than 0
		{
			//check, whether value is even
			if(value % 2 == 0)
			{
				System.out.println("even " + value);
			}
			//decrement value, otherwise it would be an infinite loop.
			value--;
		}
	}
	//->switch to Arrays.java (*2*)
}
