package lesson05;

public class ApplicationRecursionPascalTriangle
{
	public static void main(String[] args)
	{
		System.out.println("--Pascal Triangle--");
							  //row,column
		//System.out.println(pascal(4, 2));
	}
	
	/**
	 * This method returns the number of the pascal triangle at 
	 * the given position
	 * @param n - depth
	 * @param k - width
	 * @return number at the respective position (int)
	 */
	public static int pascal(int n, int k)
	{
		//root 		border objects
		if(k == 0 || k == n)
		{
			return 1;
		}

		//otherwise
		else
		{
			return pascal(n-1, k) + pascal(n-1, k-1);	
		}
	}
}
