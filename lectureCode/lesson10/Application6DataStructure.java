package lesson10;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class Application6DataStructure
{
	public static void main(String[] args)
	{
		System.out.println("--Data Structures--");
		//show the difference between hashSets and treeSets
		compareCollections();
	}
	
	private static void compareCollections()
	{
		//Initialize a hashSet (elements are NOT sorted)
		Collection<Double> hs = new HashSet<>();
		hs.add(5.5);
		hs.add(3.3);
		hs.add(3.3); //duplicate entry
		hs.add(1.1);
		hs.add(2.2);
		print(hs);
		//Initialize a treeSet (elements are sorted)
		Collection<Double> ts = new TreeSet<>();
		ts.add(5.5);
		ts.add(3.3);
		ts.add(3.3); //duplicate entry
		ts.add(1.1);
		ts.add(2.2);
		print(ts);	
		//Initialize an ArrayList
		Collection<Double> al = new ArrayList<>();
		al.add(5.5);
		al.add(3.3);
		al.add(3.3); //duplicate entry
		al.add(1.1);
		al.add(2.2);
		print(al);	
		
	}
	
	/**
	 * print the collection
	 * @param c
	 */
	private static void print(Collection<?> c)
	{
		Iterator<?> iter = c.iterator();
		while(iter.hasNext())
		{
			System.out.print(iter.next() + "  ");
		}
		System.out.println();
		System.out.println("------");
	}
	
}
