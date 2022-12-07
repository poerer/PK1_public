package lesson05Script;
/*
 * Additional assignments can be found here:
 * https://www.geeksforgeeks.org/practice-questions-for-recursion/
 * https://www.techiedelight.com/recursion-practice-problems-with-solutions/
 */

/**
 * (*2*)
 * This class provides some examples for recursive algorithms.
 * 1. Sum of all values
 * 2. Towers of Hanoi
 * 
 * @author fuchs
 *
 */
public class RecursionExamples
{
	public static void main(String[] args)
	{
		//simple example to start with: calculating the sum
		int value = 400;
		int sum = sum(value);
		System.out.println("the sum of all numbers till " + value + " is " + sum);
		
		//this can be also calculated iteratively
		sum = sumIterative(value);
		System.out.println("the sum of all numbers till " + value + " is " + sum);
		
		//well-known problem: the towers of Hanoi
		int towerHeight = 4;
		towersHanoi(towerHeight);
	}
	
	/**
	 * This methods sums up all values till we reach the value of the
	 * argument (value). It only works for natural numbers including 0.
	 * This is the recursive solution. 
	 * 
	 * @param value
	 * @return the sum of all values till the argument value.
	 */
	public static int sum(int value)
	{
		if(value == 0)
		{
			return value;
		}
		else
		{
			return value + sum(value-1);
		}
	}
	
	/**
	 * This methods sums up all values till we reach the value of the
	 * argument (value). It only works for natural numbers including 0.
	 * This is the iterative solution.
	 * 
	 * @param value
	 * @return the sum of all values till the argument value.
	 */
	public static int sumIterative(int value)
	{
		int sum = 0;
		for (int i=1; i <= value; i++) 
		{
			sum = sum + i;
		}
		return sum;
	}
	
	/**
	 *  recursive solution to towers of Hanoi. In the towers of Hanoi problem, 
	 *  we have three poles and n discs that fit onto the poles. The discs 
	 *  differ in size and are initially stacked on one of the poles, in order 
	 *  from largest (disc n) at the bottom to smallest (disc 1) at the top. 
	 *  The task is to move all n discs to another pole, while obeying the 
	 *  following rules:
	 *  1 Move only one disc at a time.
	 *  2 Never place a larger disc on a smaller one.
	 *  Recursion provides just the plan that we need: First we move the top n−1 
	 *  discs to an empty pole, then we move the largest disc to the other 
	 *  empty pole, then complete the job by moving the n−1 discs onto the 
	 *  largest disc.
	 * @param towerHeight - how many discs are present
	 */
	public static void towersHanoi(int towerHeight)
	{
		/*
		 * we need the helper because of the second parameter.
		 * The caller has no idea what this parameter does and that it is 
		 * necessary to print the direction where to move the disk.
		 */
		towerHanoiHelper(towerHeight, true);
	}
	
	/**
	 * Helper function to solve the tower of hanoi problem
	 * 
	 * @param towerHeight - how many discs are present
	 * @param left - direction where to move
	 */
	public static void towerHanoiHelper(int towerHeight, boolean left)
	{
		/*
		 * Approach:
		 * Take an example for 2 disks :
		 * 	Let rod 1 = 'A', rod 2 = 'B', rod 3 = 'C'.
		 * 	Step 1 : Shift first disk from 'A' to 'B'.
		 * 	Step 2 : Shift second disk from 'A' to 'C'.
		 * 	Step 3 : Shift first disk from 'B' to 'C'.
		 * 
		 * The pattern here is :
		 * 	Shift 'n-1' disks from 'A' to 'B'.
		 * 	Shift last disk from 'A' to 'C'.
		 * 	Shift 'n-1' disks from 'B' to 'C'. 
		 */
		
		//trivial case
		if (towerHeight == 0) 
		{
			/*
			 * We do not need to return a value but simply leave the method.
			 * That is why we have an empty return statement. As you can
			 * see in the head of the method the return data type is void.
			 * That means we are not executing more code in this method.
			 */
			return; 
		}
		//recursive call being a little bit simpler towerHeight - 1
		towerHanoiHelper(towerHeight - 1, !left);
        if(left) //direction where to move -> left
        {
        	System.out.println(towerHeight + " left");
        }
        else  //direction where to move -> right    
        {
        	System.out.println(towerHeight + " right");
        }
        //recursive call being a little bit simpler towerHeight - 1
        towerHanoiHelper(towerHeight-1, !left);
	}
}
