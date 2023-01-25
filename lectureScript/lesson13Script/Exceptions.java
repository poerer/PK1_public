package lesson13Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_try_catch.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Exceptions
 * https://openbook.rheinwerk-verlag.de/javainsel/08_001.html#u8
 */

/**
 * (*1*)
 * The term exception is shorthand for the phrase 'exceptional event'.
 * Definition: An exception is an event, which occurs during the execution of a 
 * program, that disrupts the normal flow of the program's instructions. When an 
 * error occurs within a method, the method creates an object and hands it off 
 * to the runtime system. The object, called an exception object, contains 
 * information about the error, including its type and the state of the program 
 * when the error occurred. Creating an exception object and handing it to the 
 * runtime system is called throwing an exception. After a method throws an 
 * exception, the runtime system attempts to find something to handle it. The 
 * set of possible "somethings" to handle the exception is the ordered list of 
 * methods that had been called to get to the method where the error occurred. 
 * The list of methods is known as the call stack.
 * The runtime system searches the call stack for a method that contains a block 
 * of code that can handle the exception. This block of code is called an exception 
 * handler. The search begins with the method in which the error occurred and 
 * proceeds through the call stack in the reverse order in which the methods were 
 * called. When an appropriate handler is found, the runtime system passes the 
 * exception to the handler. An exception handler is considered appropriate if the 
 * type of the exception object thrown matches the type that can be handled by the 
 * handler. The exception handler chosen is said to catch the exception. If the 
 * runtime system exhaustively searches all the methods on the call stack without 
 * finding an appropriate exception handler the runtime system (and, consequently, 
 * the program) terminates.
 * 
 * The three kinds of exceptions:
 * The first kind of exception is the checked exception. These are exceptional 
 * conditions that a well-written application should anticipate and recover from. 
 * For example, suppose an application prompts a user for an input file name, 
 * then opens the file by passing the name to the constructor for java.io.FileReader. 
 * Normally, the user provides the name of an existing, readable file, so the 
 * construction of the FileReader object succeeds, and the execution of the 
 * application proceeds normally. But sometimes the user supplies the name of a 
 * nonexistent file, and the constructor throws java.io.FileNotFoundException. 
 * A well-written program will catch this exception and notify the user of the 
 * mistake, possibly prompting for a corrected file name. Checked exceptions are 
 * subject to the Catch or Specify Requirement. All exceptions are checked 
 * exceptions, except for those indicated by Error, RuntimeException, and their 
 * subclasses.
 * The second kind of exception is the error. These are exceptional conditions 
 * that are external to the application, and that the application usually cannot 
 * anticipate or recover from. For example, suppose that an application successfully 
 * opens a file for input, but is unable to read the file because of a hardware 
 * or system malfunction. The unsuccessful read will throw java.io.IOError. An 
 * application might choose to catch this exception, in order to notify the user 
 * of the problem — but it also might make sense for the program to print a stack 
 * trace and exit. Errors are not subject to the Catch or Specify Requirement. 
 * Errors are those exceptions indicated by Error and its subclasses.
 * The third kind of exception is the runtime exception. These are exceptional 
 * conditions that are internal to the application, and that the application 
 * usually cannot anticipate or recover from. These usually indicate programming 
 * bugs, such as logic errors or improper use of an API. For example, consider 
 * the application described previously that passes a file name to the constructor 
 * for FileReader. If a logic error causes a null to be passed to the constructor, 
 * the constructor will throw NullPointerException. The application can catch 
 * this exception, but it probably makes more sense to eliminate the bug that 
 * caused the exception to occur. Runtime exceptions are not subject to the Catch 
 * or Specify Requirement. Runtime exceptions are those indicated by RuntimeException 
 * and its subclasses. 
 * Errors and runtime exceptions are collectively known as unchecked exceptions.
 * 
 * @author fuchs
 *
 */
public class Exceptions
{
	public static void main(String[] args)
	{
		/*
		 * The first step in constructing an exception handler is to enclose the 
		 * code that might throw an exception within a try block. In general, a 
		 * try block looks like the following:
		 * 				try 
		 * 				{
		 * 					code
		 * 				}
		 * The segment in the example labeled code contains one or more legal 
		 * lines of code that could throw an exception. You can put each line of 
		 * code that might throw an exception within its own try block and provide 
		 * separate exception handlers for each. Or, you can put all the lines of 
		 * code within a single try block and associate multiple handlers with it.
		 * If an exception occurs within the try block, that exception is handled 
		 * by an exception handler associated with it. You associate exception 
		 * handlers with a try block by providing one or more catch blocks directly 
		 * after the try block. No code can be between the end of the try block 
		 * and the beginning of the first catch block:
		 * 				try 
		 * 				{
		 * 					code
		 * 				}
		 * 				catch(ExceptionType name)
		 * 				{
		 * 					code
		 * 				}
		 * 				catch(ExceptionType name)
		 * 				{
		 * 					code
		 * 				}
		 * Each catch block is an exception handler that handles the type of 
		 * exception indicated by its argument. The argument type, ExceptionType, 
		 * declares the type of exception that the handler can handle and must 
		 * be the name of a class that inherits from the Throwable class. The 
		 * handler can refer to the exception with name. The catch block contains 
		 * code that is executed if and when the exception handler is invoked. 
		 * The runtime system invokes the exception handler when the handler is 
		 * the first one in the call stack whose ExceptionType matches the type 
		 * of the exception thrown. The system considers it a match if the thrown 
		 * object can legally be assigned to the exception handler's argument.
		 * Example: IndexOutOfBoundsException
		 */
		int[] container = new int[5]; //Array with 5 elements (index: 0, 1, 2, 3, 4)
		//Index out of bounds exception (index 5)
				//container[5] = 10; //uncomment to see the exception
		//solution:
		try 
		{
			container[5] = 10;
		}
		catch(ArrayIndexOutOfBoundsException e)
		{
			System.out.println("Catch block!");
			/*
			 * We can now try to handle the exception. Perhaps the programmer
			 * wanted to assign a value to the last index position of this array
			 * which would be 4 and not 5.
			 */
			container[4] = 10;
		}
		for(int i = 0; i < container.length; i++)
		{
			System.out.print(container[i] + " ");
		}
		System.out.println();
		
		/*
		 * The previous example showed how to write an exception handler. Sometimes, 
		 * it's appropriate for code to catch exceptions that can occur within it. 
		 * In other cases, however, it's better to let a method further up the 
		 * call stack handle the exception. For example, if you were providing 
		 * the class as part of a package of classes, you probably couldn't 
		 * anticipate the needs of all the users of your package. In this case, 
		 * it's better to not catch the exception and to allow a method further 
		 * up the call stack to handle it.
		 * Let's modify the previous example to specify the exceptions it can 
		 * throw instead of catching them. To specify that arrays can throw an
		 * IndexOutOfBounds exception, add a throws clause to the method declaration. 
		 * Therefore, we have to write a method first. The throws clause comprises 
		 * the throws keyword followed by a comma-separated list of all the exceptions 
		 * thrown by that method. The clause goes after the method name and argument 
		 * list and before the brace that defines the scope of the method.
		 * ->switch to (*2*) in the same class
		 */
		/*
		 * (*3*)
		 * Now, we are calling the method, which passes the exception along the 
		 * call stack. Therefore, we, as the caller, have to handle the 
		 * exception. The catch block is not where the exception occurred but
		 * hopefully we are able to deal with the exception given our context.
		 */
		try 
		{
			throwException();	
		}
		catch(IndexOutOfBoundsException e)
		{
			System.out.println("The caller catched the exception!");
		}
		
		/*
		 * Before you can catch an exception, some code somewhere must throw 
		 * one. Any code can throw an exception: your code, code from a package 
		 * written by someone else such as the packages that come with the Java 
		 * platform, or the Java runtime environment. Regardless of what throws 
		 * the exception, it's always thrown with the throw statement.
		 * As you have probably noticed, the Java platform provides numerous 
		 * exception classes. All the classes are descendants of the Throwable 
		 * class, and all allow programs to differentiate among the various 
		 * types of exceptions that can occur during the execution of a program.
		 * You can also create your own exception classes to represent problems 
		 * that can occur within the classes you write. In fact, if you are a 
		 * package developer, you might have to create your own set of exception 
		 * classes to allow users to differentiate an error that can occur in 
		 * your package from errors that occur in the Java platform or other packages.
		 * 
		 * All methods use the throw statement to throw an exception. The throw 
		 * statement requires a single argument: a throwable object. Throwable 
		 * objects are instances of any subclass of the Throwable class. The 
		 * objects that inherit from the Throwable class include direct descendants 
		 * (objects that inherit directly from the Throwable class) and indirect 
		 * descendants (objects that inherit from children or grandchildren of 
		 * the Throwable class). Throwable has two direct descendants: Error and 
		 * Exception.
		 * Error Class:
		 * When a dynamic linking failure or other hard failure in the Java virtual 
		 * machine occurs, the virtual machine throws an Error. Simple programs 
		 * typically do not catch or throw Errors.
		 * Exception Class:
		 * Most programs throw and catch objects that derive from the Exception 
		 * class. An Exception indicates that a problem occurred, but it is not 
		 * a serious system problem. Most programs you write will throw and catch 
		 * Exceptions as opposed to Errors.
		 * The Java platform defines the many descendants of the Exception class. 
		 * These descendants indicate various types of exceptions that can occur. 
		 * For example, IllegalAccessException signals that a particular method 
		 * could not be found, and NegativeArraySizeException indicates that a 
		 * program attempted to create an array with a negative size.
		 * One Exception subclass, RuntimeException, is reserved for exceptions 
		 * that indicate incorrect use of an API. An example of a runtime exception 
		 * is NullPointerException, which occurs when a method tries to access a 
		 * member of an object through a null reference.
		 * 
		 * Creating Exception Classes:
		 * When faced with choosing the type of exception to throw, you can either 
		 * use one written by someone else — the Java platform provides a lot of 
		 * exception classes you can use — or you can write one of your own. You 
		 * should write your own exception classes if you answer yes to any of the 
		 * following questions; otherwise, you can probably use someone else's.
		 * 1. Do you need an exception type that isn't represented by those in the 
		 * Java platform?
		 * 2. Would it help users if they could differentiate your exceptions from 
		 * those thrown by classes written by other vendors?
		 * 3. Does your code throw more than one related exception?
		 * 4. If you use someone else's exceptions, will users have access to those 
		 * exceptions? 
		 * 
		 * Let's have a look at an example. We have written our own exception by
		 * extending the IndexOutOfBoundsException because we want to be more 
		 * specific.
		 */
		//->switch to IndexTooHighException.java (*4*)
		
		/*
		 * (*5*)
		 * Again, we are forcing an IndexOutOfBoundsException, however, this time
		 * our exception will be thrown.
		 */
		System.out.println("++++++++++++++++++++++++");
		System.out.println("Our exception:");
		int index = 10;
		if(index >= container.length)
		{
			throw new IndexTooHighException(index, container.length);
		}
		/*
		 * Using our exception, we can provide the programmer with some additional 
		 * information like array length or index.
		 */
		/*
		 * Summary:
		 * A program can use exceptions to indicate that an error occurred. To 
		 * throw an exception, use the throw statement and provide it with an 
		 * exception object — a descendant of Throwable — to provide information 
		 * about the specific error that occurred. A method that throws an uncaught, 
		 * checked exception must include a throws clause in its declaration. A 
		 * program can catch exceptions by using a combination of the try and catch
		 * blocks.
		 * The try block identifies a block of code in which an exception can occur.
		 * The catch block identifies a block of code, known as an exception handler, 
		 * that can handle a particular type of exception.
		 * The try statement should contain at least one or more catch blocks. 
		 * The class of the exception object indicates the type of exception thrown. 
		 * The exception object can contain further information about the error, 
		 * including an error message.
		 */
		//->DONE!
		
	}
	
	/**
	 * (*2*)
	 * We pass the exception further up the call stack. Therefore, someone else
	 * has to catch the exception.
	 * 
	 * @throws IndexOutOfBoundsException
	 */
	public static void throwException() throws IndexOutOfBoundsException
	{//									  ^					^
	 //								   keyword	  comma separated list of possible exceptions
		/*
		 * We are forcing an exception but pass the exception to the caller of
		 * the method:
		 */
		int[] a = {1};
		a[1] = 1;
	}
	//->return to (*3*) in the same class 
}
	

