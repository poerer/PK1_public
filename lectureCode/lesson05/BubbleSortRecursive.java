package lesson05;

public class BubbleSortRecursive
{

	public static void main(String[] args)
	{
		System.out.println("--BubbleSort-Recursive--");
		int[] array = createRandomArray(10, 80);
		
		startSortingRecursive(array, 1, 0);
		// print the sorted array
		printArray(array, 0);
		
	}

	
	/**
	 * replaced both for-loops with a recursive call
	 * @param array
	 * @param i
	 * @param j
	 */
	public static void startSortingRecursive(int[] array, int i, int j)
	{
		if (i < array.length)
		{
			if (j == array.length - i)
			{
				//print intermediate results
				printArray(array, 0);
				startSortingRecursive(array, i + 1, 0);
			} 
			else
			{
				if (array[j] > array[j + 1])
				{
					int temp = array[j + 1];
					array[j + 1] = array[j];
					array[j] = temp;
				}
				startSortingRecursive(array, i, j + 1);
			}
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
	 * print the content of the array
	 * 
	 * @param array
	 */
	public static void printArray(int[] array, int index)
	{
		if(index < array.length)
		{
			System.out.print(array[index] + ", ");
			index++;
			printArray(array, index);
		}
		else
		{
			System.out.println();
		}
	}
}
