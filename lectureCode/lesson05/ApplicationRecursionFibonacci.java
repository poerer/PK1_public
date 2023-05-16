package lesson05;

public class ApplicationRecursionFibonacci
{

	public static void main(String[] args)
	{
		System.out.println("-- Recursion - FIBONACCI--");
		
		int fib = 5;
		//int fib = 46;
		
		System.out.println("Fib (iterative): " + fibonacciIterative(fib));		
		System.out.println("Fib (recursive): " + fibonacciRecursive(fib));
		
		
		//int[] memory = new int[fib+1];
		//System.out.println("Fib (recursive) SPEED: " + fibonacciRecursiveSpeed(fib, memory));
		//System.out.println("Fib (tailrecursive): " + fibonacciRecursiveTailCall(fib, 0, 1));
	}
	/**
	 * recursive implementation of the fibonacci numbers.
	 * @param a
	 * @return
	 */
	public static int fibonacciRecursive(int a)
	{
		if(a == 0) return 0;
		else if(a == 1) return 1;
		else
		{
			return fibonacciRecursive(a-1) + fibonacciRecursive(a-2);
		}
	}
		
	/**
	 * Iterative implementation of the fibonacci numbers
	 * @param a
	 * @return
	 */
	public static int fibonacciIterative(int a)
	{
		int x = 0, y = 1, z = 1;
        for (int i = 0; i < a; i++) 
        {
            x = y;
            y = z;
            z = x + y;
        }
        return x;		
	}

	/**
	 * Recursive tail call implementation of the Fibonacci numbers.
	 * @param a
	 * @param b
	 * @param c
	 * @return
	 */
	public static int fibonacciRecursiveTailCall(int value, int a, int b)
	{
		if(value == 0) return a;
		else if(value == 1) return b;
		else
		{
			return fibonacciRecursiveTailCall(value - 1, b, a + b);
		}
	}
	
	
	
	
	/**
	 * Recursive implementation of the fibonacci numbers.
	 * Speed up with an additional array to store intermediate results.
	 * @param a
	 * @param memory - storage
	 * @return
	 */
	public static int fibonacciRecursiveSpeed(int a, int[] memory)
	{
		if(a == 0)
		{
			return 0;
		}
		else if(a == 1)
		{
			return 1;
		}
		else
		{
			if(memory[a] != 0)
			{		
				return memory[a];
			}
			else
			{
				memory[a] = fibonacciRecursiveSpeed(a-1, memory) + fibonacciRecursiveSpeed(a-2, memory);
				return memory[a];
			}
		}		
	}
}
