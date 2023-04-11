/*
 * The script is created using various resources like:
 * https://docs.oracle.com/javase/tutorial/index.html 
 * and other topic specific resources acknowledged in the respective lessons. 
 */

/* This is the package name.
 * A package is a folder automatically created in your workspace
 * to help you organize your Java project. 
 * For this lecture, you should create a package for each assignment.
 * Packages are written in camel case format and start with a lower case letter.
 */
package lesson01Script;

/**
 * (*1*)
 * This script is meant as an interactive helper.
 * You can uncomment lines of code, change values and run the application 
 * to check the results.
 * 
 * This is your first class.
 * Each class is a file in your workspace located in the folder
 * of the respective package.  
 * 
 * The header of the class consists of three words:
 * 1. visibility
 * 'public' is a key word having a specific meaning. 
 * (will be later explained in the chapter about object orientation)
 * 2. class type
 * 'class' is a key word, which means that you are writing a new class.
 * Later you will learn about other kinds of constructs like interfaces.
 * 3. identifier
 * 'Introduction' is just a unique identifier for this class.
 * It should be written in camel case format and ALWAYS starts with a capital letter.
 * Camel case means that you write the first letter
 * of a new word in capital letters e.g., FirstClass, NrOfPlayers
 * 
 * Just copy this header line without thinking about the individual key words.
 * However, you should modify the identifier to fit your needs e.g., 
 * 'Assignment01' might be a good identifier for the first assignment.
 * 
 * @author Fuchs
 *
 */
public class Introduction
{
	/**
	 * This is the main method.
	 * It is the starting point into your project and consists of three key words.
	 * 1. visibility
	 * 'public' see chapter object orientation
	 * 2. class or object method
	 * 'static' see chapter object orientation
	 * 3. return value
	 * 'void' see chapter methods and control structures
	 * 4. identifier
	 * 'main' is an identifier telling the compiler to start executing code
	 * from here on. Each application has one (and only one) main method.
	 * 5. parameters
	 * '(String[] args)' are parameters the method can use to work with.
	 * Parameters consist of a data type (in this case String) and in this
	 * case a data structure (array) and an identifier (args). You will learn 
	 * about data types next week in the chapter about data types, about parameters 
	 * in the chapter about methods and control structures, and arrays in the 
	 * chapter about loops and arrays. 
	 * 
	 * After this 'headline' (also called method signature) providing you with 
	 * some meta-information about what this method is all about, you have to 
	 * write curly brackets. These curly brackets are opening up a new block. 
	 * In such a block you can then add your statements e.g., calculations.  
	 * Statements need to end with a semicolon (;) e.g.,
	 * 						int x = 10 + 5;
	 * 						System.out.println(x);
	 * In this first week, it is sufficient to simply copy the lines of code below
	 * this comment. 
	 * Important: to keep your code as readable as possible you have to make use 
	 * of indentation to show the reader of your code that there is a new block. 
	 * 
	 * @param args - not used in this example
	 */
	public static void main(String[] args)
	{
		/*
		 * This is a typical print statement.
		 * The sentence in the parentheses is printed to the console.
		 * We will use this command to show results of calculations.
		 * As you can see, each statement ends with a semicolon ;.
		 * You could write multiple statements in just one line, however, to 
		 * facilitate reading your code you should use one line for one statement.
		 * 
		 * 
		 * Just copy this line of code to print something to the console.
		 * You can edit the blue text to print something else.
		 */
		System.out.println("This was the first lesson");
	}
	//switch to RectangleExample.java (*2*)
}

