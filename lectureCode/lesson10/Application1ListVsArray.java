package lesson10;

import java.util.ArrayList;
import java.util.LinkedList;

public class Application1ListVsArray
{
	public static void main(String[] args)
	{
		System.out.println("--List vs. Array--");
		
		int size = 100000000;
		//int size = 2000000; // remove
		long start;
		long end;
		
		
		start = System.currentTimeMillis();
		int[] valueArray = returnValuesArray(size);
		end = System.currentTimeMillis();
		System.out.println("Array (primitive) finished in: " + (end - start) + " milliseconds");
		
		System.gc();
		
		start = System.currentTimeMillis();
		Integer[] valueArray2 = returnValuesArray2(size);
		end = System.currentTimeMillis();
		System.out.println("Array (objects) finished in: " + (end - start) + " milliseconds");
		
		System.gc();
		
		start = System.currentTimeMillis();
		ArrayList<Integer> valueList= returnValuesList(size);
		end = System.currentTimeMillis();
		System.out.println("ArrayList finished in: " + (end - start) + " milliseconds");
		
		System.gc();
		
		start = System.currentTimeMillis();
		LinkedList<Integer> valueLinkedList= returnValuesLinkedList(size);
		end = System.currentTimeMillis();
		System.out.println("LinkedList finished in: " + (end - start) + " milliseconds");
		
		
		//Manipulate an existing list:
		/*
		ArrayList<Integer> valueList= returnValuesList(size);
		System.out.println("ArrayList size: " + valueList.size());
		start = System.currentTimeMillis();
		manipulateArrayList(valueList);
		end = System.currentTimeMillis();
		System.out.println("ArrayList finished in: " + (end - start) + " milliseconds; size: " + valueList.size());
		
		LinkedList<Integer> linkedList = returnValuesLinkedList(size);
		System.out.println("LinkedList size: " + linkedList.size());
		start = System.currentTimeMillis();
		manipulateLinkedList(linkedList);
		end = System.currentTimeMillis();
		System.out.println("LinkedList finished in: " + (end - start) + " milliseconds; size:  " + linkedList.size());
		*/
	}
	/**
	 * Fill an array with numbers from 0 - size
	 * @param size threshold value
	 * @return int array with numbers from 0 - size
	 */
	public static int[] returnValuesArray(int size)
	{
		int[] valueArray = new int[size];
		for(int i = 0; i < size; i++)
		{
			valueArray[i] = i;
		}
		
		return valueArray;
	}
	/**
	 * Fill an array with objects from 0 - size
	 * @param size threshold value
	 * @return Integer array with numbers from 0 - size
	 */
	public static Integer[] returnValuesArray2(int size)
	{
		Integer[] valueArray = new Integer[size];
		for(int i = 0; i < size; i++)
		{
			valueArray[i] = i;
		}
		
		return valueArray;
	}
	/**
	 * Fill a list with numbers from 0 - size
	 * @param size threshold value
	 * @return list with Integers from 0 - size
	 */
	public static ArrayList<Integer> returnValuesList(int size)
	{
		ArrayList<Integer> valueList = new ArrayList<Integer>(size);
		for(int i = 0; i < size; i++)
		{
			valueList.add(i);	
		}
		
		return valueList;
	}
	public static LinkedList<Integer> returnValuesLinkedList(int size)
	{
		LinkedList<Integer> valueList = new LinkedList<Integer>();
		for(int i = 0; i < size; i++)
		{
			valueList.add(i);	
		}
		
		return valueList;		
	}

	
	public static void manipulateLinkedList(LinkedList<Integer> linkedList)
	{
		int steps = 5000;
		while(steps > 0)
		{
			
			//int index = (int)(Math.random() * linkedList.size());
			//linkedList.remove(index);
			
			linkedList.removeFirst();
			steps--;
		}
	}
	
	public static void manipulateArrayList(ArrayList<Integer> arrayList)
	{
		int steps = 5000;
		while(steps > 0)
		{
			
			//int index = (int)(Math.random() * arrayList.size());
			//arrayList.remove(index);
			
			arrayList.remove(0);
			steps--;
		}
	}
	
	
}
