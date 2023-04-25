package lesson03Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_methods.asp
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_008.htm
 */

/**
 * (*1*)
 * Introduction to methods, return values, and parameters:
 * Methods are a way to semantically structure your code.
 * You can pass data, known as parameters, into a method.
 * You can receive data, known as return values, from methods.
 * 
 * You do not have to repeat code segments and you are
 * able to write more generic code (reusable).
 */
public class Methods
{
	/**
	 * The main method is a method you already know from the previous lectures.
	 * It is the starting point in your project and is called automatically.
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		/*
		 * This is the body of the main method.
		 * All statements are performed sequentially.
		 * Within this body you can call another method like myFirstMethod.
		 * Simply write the name of the identifier (myFirstMethod) and add parentheses. 
		 */
		System.out.println("before the method");
		myFirstMethod(); //<- the code of the method will be executed first and then
		//you continue executing code here...
		System.out.println("after the method");
		System.out.println();
		
		mySecondMethod(42); 		//you can see that we pass the value 42 to the method
			//mySecondMethod(); 	//we cannot call the method without providing an integer.
			//mySecondMethod(true); //the method expects an integer, nothing else (no boolean)
		System.out.println();
		
		boolean isOld = myThirdMethod(42); //this method has a return value, which we can store in a variable.
		System.out.println("Am I old? " + isOld);
		/*
		 * You can also execute the method without storing the return value.
		 * However, the value will be lost then.
		 */
		myThirdMethod(42);
		/*
		 * Any method declared void doesn't return a value. It does not need to 
		 * contain a return statement, but it may do so. In such a case, a return 
		 * statement can be used to branch out of a control flow block and exit 
		 * the method and is simply used like this:
		 * 		return;
		 */
		
		
		/*
		 * Just another example of a method.
		 * We are passing the value of the variable 'text' to the method.
		 * The method returns the first letter, which is just one symbol.
		 * Therefore, we can use the data type 'char' for this use case.
		 */
		String text = "hallo";
		char firstLetter = getFirstLetter(text);
		System.out.println("First letter of "+ text +" is " + firstLetter);
		System.out.println();
		
		/*
		 * Overloading
		 * With method overloading, multiple methods can have the same name 
		 * with different parameters.
		 * 
		 * Consider the following example, which have two methods that add 
		 * numbers of different type:
		 */
		int result1 = plusMethodInt(3, 4);			System.out.println("overloading: int: " + result1);
		double result2 = plusMethodDouble(3.5, 4.2);System.out.println("overloading: double: " + result2);
		/*
		 * Instead of defining two methods that should do the same thing, 
		 * it is better to overload one. In the example below, we overload 
		 * the plusMethod method to work for both int and double:
		 */
		int result3 = plusMethod(3, 4);				System.out.println("overloading: int: " + result3);
		double result4 = plusMethod(3.5, 4.2);		System.out.println("overloading: double: " + result4);
		//Multiple methods can have the same name as long as the number and/or type of parameters are different.
		System.out.println();
		
		/*
		 * Attention:
		 * When introducing methods the visibility of variables changes.
		 * Currently, we are only working with local variables.
		 * The identifier of a local variable is written in brown color (default).
		 * Local means that these variables are only visible in the block they have
		 * been declared and initialized.
		 * Remember: Blocks are structures displayed with curly brackets {}. Examples
		 * are the bodies of methods, which are written in curly brackets, or any kind
		 * of control structure or loop construct.
		 */
		//initialize a local variable
		double local = 2.5;				System.out.println("1. Local variable: " + local);
		myForthMethod();				System.out.println("3. Local variable: " + local);
		myFifthMethod(local);			System.out.println("5. Local variable: " + local);
		local = mySixthMethod(local);	System.out.println("7. Local variable: " + local);
	}
	
	/**
	 * A method must be declared within a class. 
	 * It is defined with the name of the method, followed by parentheses ().
	 * 
	 * For each method, you have to write a JavaDoc.
	 * The JavaDoc provides the reader with information about what your method is doing
	 * and additionally, whether parameters are expected or return values provided.
	 * For more information about JavaDoc you can read the following article:
	 * https://www.oracle.com/technetwork/java/javase/documentation/index-137868.html
	 */
	public static void myFirstMethod()
	{
		/*
		 * Let's have a look at the header:
		 * public and static will be covered later in this course (just copy those key words).
		 * 
		 * void is providing you information about the return type.
		 * void is a key word (telling you something about the return type) 
		 * and means that this method is returning nothing.
		 *  
		 *  myFirstMethod is the identifier of the method.
		 *  
		 *  () are the expected parameters. In this case, the method expects nothing (no values).
		 */
		
		/*
		 * This is the body of your own method.
		 * Here you can execute statements like in the main method.
		 */
		System.out.println("\t in the method");
	}
	
	/**
	 * This second method looks different compared to the first method.
	 * In the parentheses a variable with data type is mentioned.
	 * This means that the method expects an int to work with.
	 * You cannot call the method without providing this method a number.
	 * 
	 * @param age - the value we can access in the body of the method.
	 */
	public static void mySecondMethod(int age)
	{
		/*
		 * In the body we can now work with the variable age.
		 */
		System.out.println("I am " + age + " years old");
	}
	
	/**
	 * This third method has a parameter (int age).
	 * Additionally, as you can see in the header we removed 'void'
	 * and inserted boolean instead. This means that the method is returning 
	 * a value of data type boolean to the caller. If a method is returning 
	 * something, you need to write a return statement in the body. 
	 * The value you are returning has to be of the same data type as the one 
	 * mentioned in the header (in this example a boolean).
	 * 
	 * @param age - the value we can access in the body of the method.
	 * @return true, if you are above 50, else otherwise
	 */
	public static boolean myThirdMethod(int age)
	{
		/*
		 * control structures will be covered in the file ControlStructures.java
		 * Either you are executing the if-block or the else-block.
		 */
		if(age > 50)
		{
			/*
			 * the value in the return statement has to have the same data type as
			 * mentioned in the header (in this case: boolean)
			 */
			return true;	 
			//code after the return statement is not executed.
		}
		else
		{
			/*
			 * If your header mentions a return data type, you have to make sure
			 * that you always return something of the same type.
			 * 
			 * Try to comment the 'return false;' statement.
			 * You will notice that the compiler provides you with an error message:
			 * 'this method must return a result of type boolean'
			 */
			return false;
			//code after the return statement is not executed.
		}
	}
	
	/**
	 * Just another method to provide you with one more example.
	 * This method returns the first letter of a String.
	 * 
	 * @param input - input String, from which we cut the first letter.
	 * @return the first character of the input String returned as char.
	 */
	public static char getFirstLetter(String input)
	{
		/*
		 * control structures will be covered in the file ControlStructures.java
		 * Either you are executing the if-block or the else-block.
		 */
		if(input.length() > 0)
		{
			//we extract the first letter of the String (chapter object orientation), which is of type char
			return input.charAt(0);
		}
		else
		{
			//we have to add this default case, otherwise we would get an error message.
			//in any case we have to return something if it is mentioned in the header.
			return ' ';
		}
	}
	
	/**
	 * In this method the variable local, which was initialized in the main
	 * method is not visible. That is why we cannot retrieve the value from
	 * this variable.
	 * Additionally, we can declare a new variable having the same name.
	 */
	public static void myForthMethod()
	{
		//This statement cannot be evaluated. The variable local is not known.
			//local = 10.5; //uncomment to see the error
		
		//However, we can initialize a variable having the same name
		double local = 1.2;			System.out.println("\t 2. Local variable: " + local);
		/*
		 * This variable (like the one in the main method) is only visible
		 * in this block (curly brackets). The main method does not know about 
		 * this variable.
		 */
	}
	
	/**
	 * In this method we can make use of a variable called value.
	 * In the main method we just pass the value of the local variable
	 * to this method.
	 * As you can see, the name of the variable on the head of the method
	 * and the name of the variable, which is passed to the method do 
	 * not need to be identical.
	 * We are now working with the local variable value in this method (block)
	 * 
	 * @param value - local variable we can work with in this method
	 */
	public static void myFifthMethod(double value)
	{
		//This statement cannot be evaluated. The variable local is not known.
			//local = 10.5; //uncomment to see the error
		
		//increase the variable value by one
		value++;					System.out.println("\t 4. Local variable: " + value);
		/*
		 * We can now work with the value in this block, however, there is no chance
		 * to communicate the value back to the main method.
		 * A solution would be to introduce a return statement (see MySixthMethod).
		 */
	}
	
	/**
	 * Again, we can make use of the variable value.
	 * Additionally, we can return a value to the caller (in our scenario the
	 * main method)
	 * 
	 * @param value - local variable we can work with in this method
	 * @return the input value is increased by 1
	 */
	public static double mySixthMethod(double value)
	{
		//increase value by one.
		value++;					System.out.println("\t 6. Local variable: " + value);
		
		//return this value to the caller
		return value; //remember to adjust the head of the method accordingly (double)
	}
	
	/**
	 * This method adds two integers and returns the result.
	 * @param a - first value of the sum
	 * @param b - second value of the sum
	 * @return result of the sum as int
	 */
	public static int plusMethodInt(int a, int b)
	{
		return a + b;
	}
	
	/**
	 * This method adds two doubles and returns the result.
	 * @param a - first value of the sum
	 * @param b - second value of the sum
	 * @return result of the sum as double
	 */
	public static double plusMethodDouble(double a, double b)
	{
		return a + b;
	}
	
	/**
	 * This method adds two integers and returns the result.
	 * @param a - first value of the sum
	 * @param b - second value of the sum
	 * @return result of the sum as int
	 */
	public static int plusMethod(int a, int b)
	{
		return a + b;
	}
	
	/**
	 * This method adds two doubles and returns the result.
	 * @param a - first value of the sum
	 * @param b - second value of the sum
	 * @return result of the sum as double
	 */
	public static double plusMethod(double a, double b)
	{
		return a + b;
	}	
	//->switch to ControlStructures.java (*2*)
}
