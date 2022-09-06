package lesson01Script;

/**
 * (*2*)
 * Please, read the Introduction first.
 * 
 * This is the code shown in the lecture.
 * Of course, we do not expect that you understand everything,
 * however, you will notice some recurring patterns.
 * 
 * Now, we have two classes in the same package.
 * When you check your workspace you will have a
 * folder (lesson01Script) containing two files 
 * (Introduction.java, RectangleExample.java).
 * 
 * @author Fuchs
 *
 */
/*
 * As you can see, we have the same key words in the headline:
 * 'public', and 'class'. The identifier is different: 'RectangleExample'.
 */
public class RectangleExample
{
	/*
	 * Again, we have only one main method. This is the starting point in
	 * this application. It looks exactly the same as in the previous example.
	 * Therefore, for your application, you can simply copy this line of code.
	 * 
	 * Comments:
	 * The blue comments indicate the JavaDoc. JavaDocs are crucial to understand
	 * your code. Therefore, for each method, you have to write a JavaDoc telling 
	 * the reader what the method does. JavaDocs need to be added to each method
	 * and all classes.
	 * Comments in green are used to explain or describe code in the body of 
	 * a method. 
	 */
	/**
	 * This is the JavaDoc.
	 * Description of what it does:
	 * This method calculates the area of a rectangle
	 * 
	 * Parameters the method can work with:
	 * @param args - is not used
	 */
	public static void main(String[] args)
	{
		//here, we are declaring variables:
		//data type, identifier (written in camel case and starts with a lower case letter)
		int height; 	// the height of the rectangle (input)
		int width; 		// the width of the rectangle (input)
		int area; 		// the area of the rectangle (result)

		/* We are assigning a value to the variable
		 * It is important to note that the kind of value we can assign to a variable
		 * depends on the DATA TYPE of the variable. This will be explained next week.
		 */
		height = 1;
		width = 5;
		//Depending on the DATA TYPE we can perform different operations (mathematical, logical, ...)
		area = height * width;
		/* We are printing the result to the console.
		 * You can see some strange things like \u00e4 or \u00B2.
		 * This is a unicode encoding, which will be explained next week.
		 * 
		 * Another strange thing is the '+' symbol.
		 * In this case, + is an operator concatenating Strings.
		 * We have a String followed by the content of a variable (area) and we end 
		 * with another String. The + operator combines everything to just one String, 
		 * which is then printed to the console.
		 */
		System.out.println("Fl\u00e4che = " + area + " m\u00B2");
	}
	/*
	 * Summary:
	 * For this very first lesson it is important to know that packages are
	 * basically folders in your workspace and classes are files. Class names start
	 * with a capital letter (ALWAYS).
	 * The main method is the entry point to your application. Just copy the main
	 * method. Later you will learn to write your own methods.
	 * Each statement ends with a semicolon ;. 
	 * The class and its methods are organized in blocks. Use indentation to show
	 * the start and the end of a block. 
	 */
	//->DONE
}
