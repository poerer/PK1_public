package lesson03;

/**
 * Explaining how the scope of variables in influenced by blocks 
 * e.g., in if conditions
 * @author Fuchs
 *
 */
public class ApplicationZZBlockScope
{
	public static void main(String[] args)
	{
		System.out.println("--Scope of Variables--");
	
		//just declare the variable
		int start = 0;
		int tmp;
		if(start == 0)
		{
			start = 10; //I can access start
			int end = 0;
			System.out.println("1. end: " + end);
		}
		else
		{
			start = 20;			
			//tmp has already been declared
				//tmp = 2;
		}
		System.out.println("1. start: " + start); //start needs to be initialized
		//I cannot access end
			//System.out.println("2. end: " + end);
	}
}
