package lesson10;

import java.util.Iterator;
import java.util.LinkedList;


public class Application2Iterator 
{
	public static void main(String[] args)
	{
		System.out.println("--Iterator--");
		
		LinkedList<String> names = new LinkedList<String>();
		names.add("Anna");
		names.add("Berta");
		names.add("Charlie");
		names.add("Doris");
		names.add("Emil");
		
		
		problemWithFor1(names);
		//problemWithFor2(names);
		//iterator(names);
	}
	
	/**
	 * Best solution to traverse a list
	 * @param names
	 */
	public static void iterator(LinkedList<String> names)
	{
		Iterator<String> iter = names.iterator();
		
		while(iter.hasNext())
		{
			System.out.println(iter.next());
			iter.remove();
			//System.out.println("Size: " + names.size());
		}
		
		//Alternative:
		/*
		for(Iterator<String> iter2 = names.iterator(); iter2.hasNext();)
		{
			System.out.println(iter2.next());
			iter2.remove();
			//System.out.println("Size: " + names.size());
		}
		*/
	}
	
	/**
	 * We try to mimic the behavior of the iterator.
	 * Result: We will not show all elements in the list
	 * @param names
	 */
	public static void problemWithFor1(LinkedList<String> names)
	{
		
		for(int i = 0; i < names.size(); i++)
		{
			System.out.println(names.get(i));
			names.remove(i);
		}
	}
	
	/**
	 * A little work around. However, we return the list in the wrong order
	 * @param names
	 */
	public static void problemWithFor2(LinkedList<String> names)
	{
		for(int i = (names.size()-1); i >= 0; i--)
		{			
			System.out.println(names.get(i));
			names.removeLast();
		}
	}

}
