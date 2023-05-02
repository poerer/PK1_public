package lesson04;

public class ApplicationSortBubbleSort
{

	public static void main(String[] args)
	{
		System.out.println("--BubbleSort--");
		//get a random array
		int[] array = ApplicationLoopIndexArray.createRandomArray(10, 40);
		
		//print the unsorted array
		ApplicationLoopIndexArray.printArray(array);
		
		//perform a bubble sort
		startSortingIterative(array);
		
		// print the sorted array
			//ApplicationLoopIndexArray.printArray(array);
	}

	/**
	 * perform a bubble sort algorithm
	 * 
	 * @param array
	 *            - which will be sorted
	 */
	public static void startSortingIterative(int[] array)
	{
		int tmp;

		for (int i = 1; i < array.length; i++)
		{
			for (int j = 0; j < array.length - i; j++)
			{
				// Performing the swap of neighboring elements
				if (array[j] > array[j + 1])
				{
					tmp = array[j];
					array[j] = array[j + 1];
					array[j + 1] = tmp;
				}
			}	
			System.out.print("Step " + i + ": ");
			ApplicationLoopIndexArray.printArray(array);
		}
	}
}
