package lesson03;

/**
 * Explain the scope of variables
 * @author Fuchs
 *
 */
public class ApplicationMethodScope
{
	public static void main(String[] args)
	{
		System.out.println("--Scope of Variables--");
		
		int start = 0;
		System.out.println("1. Value of start: " + start);
		methodFirst();
		System.out.println("2. Value of start: " + start);
		methodSecond(start);
		System.out.println("4. Value of start: " + start);
		System.out.println("6. Value of start: " + methodThird(start));
		System.out.println("7. Value of start: " + start);
	}
	
	/**
	 * This method wants to access the start variable initialized in methodStart
	 */
	public static void methodFirst()
	{
		//This is an error. start is not visible
			//start = 10;
	}
	
	/**
	 * This method uses the input and assigns another value to it.
	 */
	public static void methodSecond(int start)
	{
		start = 20;
		System.out.println("3. Value of start: " + start);
	}
	
	/**
	 * This method uses the input and assigns another value to it.
	 */
	public static int methodThird(int start)
	{
		start = 30;
		System.out.println("5. Value of start: " + start);
		return start;
	}
}
