package lesson04;

public class ApplicationSieveOfEratosthenes 
{
	public static void main(String[] args)
	{
		System.out.println("--Sieve of Eratosthenes--");
		
		//Initialize the array (Line 1 - 5)
		int n = 100;
		boolean[] sieved = new boolean[n];
		
		//start the calculation
		startSieving(sieved);
	}
	
	//Sieve and print (Line 8 - 20)
	public static void startSieving(boolean[] sieved)
	{
		//Line 8
		for(int i = 2; i <= (int) Math.sqrt(sieved.length); i++)
		{
			//Line 9
			if(!sieved[i] == true)
			{
				//Line 10
				System.out.println(i);
				//Line 11 - 13
				for(int j = i*i; j < sieved.length; j = j + i)
				{
					sieved[j] = true;
				}
			}
		}
		//Line 16 - 20
		for(int i = (int)(Math.sqrt(sieved.length)+1); i < sieved.length; i++)
		{
			//Line 17
			if(!sieved[i] == true)
			{
				System.out.println(i);
			}
		}
	}
}
