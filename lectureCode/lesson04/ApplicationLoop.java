package lesson04;

public class ApplicationLoop {

	public static void main(String[] args)
	{
		System.out.println("--Loops--");
		//System.out.println(getFactorial(7));
		//nestedLoops();
	}
	

	/**
	 * This method returns the factorial of a given integer.
	 */
	public static int getFactorial(int factorial)
	{
		int result = 1;
		
		while(factorial > 0)
		{
			result = result * factorial;
			factorial--;
		}
		
		return result;
	}
	
	/**
	 * This method introduces an example for nested loops.
	 */
	public static void nestedLoops()
	{
		int tester = 0;
		while(tester == 0)
		{
			for(int i = 0; i < 10; i++)
			{
				System.out.print(i + ", ");
			}
			
			tester = (int) (Math.random()*2);
			System.out.println();
		}
	}
}
