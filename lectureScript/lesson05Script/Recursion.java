package lesson05Script;
/*
 * Additional resources you might find useful:
 * https://www.geeksforgeeks.org/recursion-in-java/
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_008.htm
 */

/**
 * (*1*)
 * Introduction to recursion:
 * In Java, the function-call mechanism supports the possibility of having 
 * a method call itself. This functionality is known as recursion.
 * All recursive functions can be rewritten as an iterative approach and
 * also the other way round.
 * Usually, recursive methods are more elegant (require less code) but
 * are less efficient in comparison to iterative approaches.
 * 
 * @author fuchs
 */
public class Recursion
{
	public static void main(String[] args)
	{
		/*
		 * The idea of calling one function from another
		 * immediately suggests the possibility of a function calling itself.
		 * 
		 * Pitfalls of recursion: 
		 * With recursion, you can write compact and 
		 * elegant programs that fail spectacularly at runtime.
		 * 1. Missing trivial case: 
		 * If you are calling a function without a trivial case (base case) 
		 * it will repeatedly call itself and never return. -> StackOverflowError
		 * 
		 * public static double harmonic(int n) 
		 * {
		 * 		return harmonic(n-1) + 1.0/n;
		 * }
		 * 
		 * 2. No guarantee of convergence: 
		 * Another common problem is to include within a recursive function 
		 * a recursive call to solve a subproblem that is not smaller than 
		 * the original problem (not reducing n in the recursive call). 
		 * 
		 * public static double harmonic(int n) 
		 * {
		 * 		if (n == 1) return 1.0;
		 * 		{
		 * 			return harmonic(n) + 1.0/n;
		 * 		}
		 * }
		 * 
		 * 3. Excessive memory requirements: 
		 * If a function calls itself recursively an excessive number of times 
		 * before returning, the memory required by Java to keep track of the 
		 * recursive calls may be prohibitive. The following recursive function 
		 * correctly computes the nth harmonic number. However, calling it with 
		 * a huge value of n will lead to a StackOverflowError.
		 * 
		 * public static double harmonic(int n) 
		 * { 
		 * 		if (n == 0) return 0.0;
		 * 		{
		 * 			return harmonic(n-1) + 1.0/n;
		 * 		}
		 * } 
		 * 
		 * Your first recursive program. The "Hello, World" for recursion is 
		 * the factorial function:
		 */
		int number = 4;
		int fac = fac(number);
		System.out.println("Factorial from " + number + " is " + fac);
		
		/*
		 * Recursive methods can also come with more than just 1 parameter.
		 * A well-known example is calculating the greatest common divisor (gcd)
		 * of two positive integers.
		 */
		int a = 1440;
		int b = 408;
		int gcd = gcd(a, b);
		System.out.println("Greatest common divisor from " + a + " and " + b + " is " + gcd);
		
		/*
		 * In order to improve performance one can think of rewriting
		 * a recursive call in a tail recursive call. This means that
		 * in the return statement no more calculations need to be done
		 * (just the recursive call). As a result, no local variables
		 * need to be kept in memory and, therefore, the recursive stack
		 * is not built. 
		 * 
		 * As an example, we can look at the Fibonacci sequence.
		 * Increase the value to e.g., 45 to see the difference in calculation
		 * time. fibRecursive(value) needs some time to get the result, however,
		 * fibTailRecursive(value) returns the result right away.
 		 */ 
		int value = 6; //change to a higher value to see the benefit of tail recursion
		int fib = fibRecursive(value);
		System.out.println("The Fibonacci number of " + value + " is " + fib);
		fib = fibTailRecursive(value);
		System.out.println("The Fibonacci number of " + value + " is " + fib);		
		
	}
	
	/**
	 * This method recursively calculates the factorial of a 
	 * natural number including 0.
	 * n! = n × (n−1) × (n−2) × … × 2 × 1
	 * 
	 * The trivial case returns a value without making any subsequent recursive calls. 
	 * It does this for one or more special input values for which the function 
	 * can be evaluated without recursion. For fac(), the base case is n = 0.
	 * 
	 * The reduction step is the central part of a recursive function. It relates 
	 * the value of the function at one (or more) input values to the value of the 
	 * function at one (or more) other input values. Furthermore, the sequence of 
	 * input values values must converge to the base case. For fac(), the value of 
	 * n decreases by 1 for each call, so the sequence of input values converges 
	 * to the trivial case.
	 * 
	 * @param number - natural number including 0
	 * @return the factorial of a given number
	 */
	public static int fac(int number)
	{
		//trivial case, no more recursive calls
		if(number == 0)
		{
			return 1;
		}
		//recursive call by simplifying the problem number-1
		else
		{
			return number * fac(number - 1);
		}
		
		/*
		 * Example with number = 4:
		 * fac(4)
		 * 	fac(3)
		 * 	 fac(2)
		 *    fac(1)
		 *     fac(0)
		 *     return 1
		 *    return 1
		 *   return 2*1
		 *  return 3*2
		 * return 4*6 = 24
		 */
	}
	
	/**
	 * Euclid's algorithm. The greatest common divisor (gcd) of two positive 
	 * integers is the largest integer that divides evenly into both of them.
	 * 
	 * We can efficiently compute the gcd using the following property, which 
	 * holds for positive integers a and b:
	 * If a > b, the gcd of a and b is the same as the gcd of b and a % b.
	 * 
	 * @param a
	 * @param b
	 * @return
	 */
	public static int gcd(int a, int b)
	{
		//trivial case
		if (b == 0)
		{
			return a;
		}
		//recursive call in the else block
        else 
        {
        	return gcd(b, a % b); //this is also tail recursive -> explained later
        }
		
		/*
		 * Example with a = 1440, b = 408
		 * gcd(1440, 408)
		 *  gcd(408, 216)
		 *   gcd(216, 192)
		 *    gcd(192, 24)
		 *     gcd(24, 0)
		 *     return 24
		 *    return 24
		 *   return 24
		 *  return 24
		 * return 24
		 */
	}
	
	/**
	 * The Fibonacci sequence is defined as follows:
	 * Fn = Fn−1 + Fn−2 for n ≥ 2, with F0 = 0 and F1 = 1
	 * 
	 * This method is computationally really expensive.
	 * 
	 * @param number
	 * @return - the Fibonacci number
	 */
	public static int fibRecursive(int number)
	{
		//trivial case
        if (number <= 1) 
        {
        	return number;
        }
        //recursive call in the else block
        else 
        {
        	/*
        	 * in the return statement we have to perform some calculations.
        	 * Therefore, it is NOT tail recursive. Results have to be stored
        	 * till we know the return value to do the calculations => inefficient
        	 */
        	return fibRecursive(number-1) + fibRecursive(number-2);
        }
	}
	
	/**
	 * The Fibonacci sequence is defined as follows:
	 * Fn = Fn−1 + Fn−2 for n ≥ 2, with F0 = 0 and F1 = 1
	 * 
	 * Rewriting the recursive call to avoid the sum in the
	 * return statement.
	 * 
	 * @param number
	 * @return - the Fibonacci number
	 */
	public static int fibTailRecursive(int number)
	{
		/*
		 * We are using a helper function to switch
		 * to a tail recursive solution. The reason for this design decision 
		 * is simple. For the tail recursive call, we need two more variables 
		 * to store intermediate results. These variables need to be 
		 * initialized when first calling the method. However, the caller 
		 * of the method has no idea how to initialize these values. That
		 * is why we have a 'wrapper' function, which just takes the number
		 * and we (as the programmers) forward this value to the correct
		 * function. In a real project, the visibility of the helper function
		 * would be limited e.g., private. We will learn about this in
		 * the chapter about object orientation. 
		 */
		return fibTailRecursiveHelper(number, 0, 1);
	}
	
	/**
	 * In this method you can see the tail recursive call.
	 * The return statement just calls the method again without 
	 * any calculations being done. Therefore, there is no need to keep
	 * track of local variables.
	 * 
	 * @param value - the actual value used as a counter
	 * @param a helper variable
	 * @param b helper variable, later returned as the result
	 * @return - the Fibonacci number
	 */
	public static int fibTailRecursiveHelper(int value, int a, int b )
	{
		//trivial case
		if(value == 0) 
		{
			return a;
		}
		//trivial case
		else if(value == 1) 
		{
			return b;
		}
		//tail recursive call in the else block 
		else
		{
			//we use a and b to store intermediate results.
			//value is just a counter how many times we call the function
			return fibTailRecursiveHelper(value - 1, b, a + b);
		}
	}
	//->switch to RecursionExamples.java (*2*)
	//->DONE
}
