package lesson04;

public class ApplicationLoopIndexArray {

	public static void main(String[] args)
	{
		System.out.println("--Datastructure Array--");
		
		//explainArray(); 	//Array
		//System.out.println(createRandomArray(10, 50));
		//printArray(createRandomArray(10, 50));
		//handsOnArray(); //HANDS ON SESSION
		//array2Dim(); 	//two dimensional array
		//print2DArray(); //print 2d array
		//arrayHighDim(); //high dimensional array
	}
	
	/**
	 * Method explaining the use of arrays
	 */
	public static void explainArray()
	{	
		//Beispiel aus den Folien LoopsAndArrays
		int[] example = {15, 24, 15, 15, 9, 76, 91, 2, 0, -5};
		
		//Einfache for-Schleife
		for(int i = 0; i < example.length; i++)
		{
			System.out.println("Index: " + i + " Wert: " + example[i]);
		}
		
		System.out.println("******");
		//Erweiterte for-Schleife
		for(int i: example)
		{
			System.out.print(i + ", ");
		}
	}
	
	/**
	 * This method returns an array of a given length with random
	 * integer numbers in a given range.
	 * 
	 * @param length - length of the array
	 * @param range - the range of the randomly generated numbers
	 * @return array of a given length with random integer numbers
	 */
	public static int[] createRandomArray(int length, int range)
	{
		int[] randomArray = new int[length];
		for (int i = 0; i < randomArray.length; i++)
		{
			randomArray[i] = (int) (Math.random() * range);
		}
		return randomArray;
	}
	
	/**
	 * Prints the content of an integer array to the console.
	 * 
	 * @param array
	 */
	public static void printArray(int[] array)
	{
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}

	/**
	 * Hands-On-Session
	 * Understand arrays and loops
	 */
	public static void handsOnArray()
	{	
		int[] array1 = {1,2,3};
		int[] array2 = new int[3];

		for(int i = 0; i < array1.length; i++)
		{
			array2[i] = array1[array1.length - i];			
		}
		printArray(array1);
		printArray(array2);
	}	
	
	/**
	 * Method explaining 2 dim arrays
	 */
	public static void array2Dim()
	{
		//initializing 2 dim array
		int[][] twoDim = {{1,2},{3,4},{5,6}};
		//printing results
		for(int i = 0; i < twoDim.length; i++)
		{
			for(int j = 0; j < twoDim[i].length; j++)
			{
				System.out.println("twoDim[" + i +  "][" + j + "] = " + twoDim[i][j]);
			}
		}
	}
	
	/**
	 * Method explaining 2 dim arrays
	 */
	public static void print2DArray()
	{
		//initializing 2 dim array
		int[][] twoDim = {{1,2},{3,4},{5,6}};
		//printing results
		for(int i = 0; i < twoDim.length; i++)
		{
			for(int j = 0; j < twoDim[i].length; j++)
			{
				System.out.print(twoDim[i][j] + " ");
			}
			System.out.println();
		}
	}	
	
	/**
	 * Explain how to create high dimensional arrays.
	 * 
	 */
	public static void arrayHighDim()
	{
		boolean[][][] threeDim = new boolean[4][4][4];
		System.out.println(threeDim[1][2][3]);
		
		int[][] twoDim = new int[3][ ];
		//						 	^
		//						  EMPTY!
		
		//Is there something available at the second position?
		System.out.println(twoDim[1]);
		
		//We have to put an array manually in each and every position
		twoDim[0] = new int[1];
		twoDim[1] = new int[3];
		twoDim[2] = new int[1];
		
		for(int i = 0; i < twoDim.length; i++)
		{
			for(int j = 0; j < twoDim[i].length; j++)
			{
				System.out.print(twoDim[i][j] + " ");
			}
			System.out.println();
		}
		
	}
		
}
