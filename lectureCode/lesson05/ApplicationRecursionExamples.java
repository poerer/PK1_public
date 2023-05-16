package lesson05;

public class ApplicationRecursionExamples
{
	public static void main(String[] args)
	{
		System.out.println("--Recursion--");
		//descend(10);
		
		//factorial:
		int n = 6;
		//System.out.println("Recursive call: " + getFactorial(n));
		//System.out.println("Iterative call: " + itFactorial(n));

		//exponentiation:
		int a = 2;
		int b = 8;
		System.out.println(a + "^" + b + " = " + power(a, b));
		
		//ggT:
		//System.out.println("Recursive ggT: " + ggTRecursive(a, b));
		//System.out.println("Iterative ggT: " + ggT(a, b));
	}

	/**
	 * Introduction
	 * @param n
	 */
	public static void descend(int n)
	{
		System.out.println(n);
		descend(n - 1);
	}

	
	/**
	 * Recursive solution. Calculate the faculty of a given number.
	 * 
	 * @param n (int)
	 * @return faculty of n (int)
	 */
	public static int getFactorial(int factorial)
	{
		if(factorial > 0)
		{
			return factorial * getFactorial(factorial-1); //recursive call
		}
		else //non-recursive part
		{
			return 1;
		}
	}

	/**
	 * Iterative solution. Calculate the faculty of a given number.
	 * 
	 * @param n (int)
	 * @return faculty of n (int)
	 */
	public static int itFactorial(int n)
	{
		int result = 1;
		for (int i = 1; i <= n; i++)
		{
			result = result * i;
		}
		return result;
	}
	
	/**
	 * Exponentiation of x to the power of y.
	 * Recursive solution.
	 * @param x - the basis
	 * @param y - the exponent
	 * @return - result of x to the power of y
	 */
	public static int power(int x, int y)
	{
		int assistantResult;
		if(y == 0)
		{
			return 1;
		}
		else
		{
			assistantResult = power(x, y-1);
			return x * assistantResult;
		}
	}
	
	
	/**
	 * Return the ggT of two positive variables.
	 * Based on the pseudo code published on Wikipedia
	 * https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
	 * @param a input int
	 * @param b input int
	 * @return ggT of a and b (int)
	 */
	public static int ggTRecursive(int a, int b)
	{
		if (b == 0) // Line 1
		{
			return a; // Line 2
		}
		else // Line 3
		{
			return ggTRecursive(b, a%b); // Line 3
		}
	}
	/**
	 * Euclidean Algorithm (iterative)
	 * Reference: https://de.wikipedia.org/wiki/Euklidischer_Algorithmus
	 * @param a first input
	 * @param b second input 
	 */
	public static int ggT(int a, int b)
	{		
		//if a = 0
		if(a == 0)
		{
			//then return b
			return b;
		}
		//else
		else
		{
			//while b != 0
			while(b != 0)
			{
				//if a > b
				if(a > b)
				{
					//then a <- a - b
					a = a - b;
				}
				//else
				else
				{
					//b <- b - a
					b = b - a;
				}
			}
			//return a
			return a;
		}	
	}
}
