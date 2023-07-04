package lesson10;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Application3Josephus
{
	public static void main(String[] args)
	{	
		System.out.println("--Josephus Problem--");
		
		// Initialization Josephus + 40 men
		int circleSize = 41;	// Number of persons
		int stepSize = 3;		// Every stepSize person has to leave the circle
		// Create the circle
		LinkedList<Integer> circle = new LinkedList<Integer>();
		
		for (int i = 1; i <= circleSize; i++)
		{
			circle.add(i);
		}
		
		Iterator<Integer> ringIter = circle.iterator();
		
		while (circle.size()>1)
		{
			int tmp = stepSize;
			
			// Persons we have to skip according to the stepSize
			while (tmp > 1)
			{
				ringIter.next(); 	// skip person
				tmp--;				// counter
				
				// When we reach the end of the list we have to continue from the beginning. 
				ringIter = closeCircle(ringIter, circle);
			}
			// The person, who has to commit suicide
			int suicide = ringIter.next();
			
			// Output for checking intermediate results
			System.out.println("Remaining: " + circle);
			System.out.println("Suicide: " + suicide);
			
			// The person dies
			ringIter.remove();
			
			// If the removed element is the last one then we have to start again from the beginning
			ringIter = closeCircle(ringIter, circle);
		}
		
		//The output shows the index position of the last remaining person (Josephus).
		System.out.println("Josephus position: " + circle.get(0));
	}

	/**
	 * This method simulates a circle with a list. If there is no more element a new iterator
	 * is assigned to the old one based on the new list size.
	 * @param ringIter the iterator of the list
	 * @param circle the list of persons
	 * @return new iterator starting from the beginning with fewer elements
	 */
	public static Iterator<Integer> closeCircle(Iterator<Integer> ringIter, List<Integer> circle)
	{
		// If there are no more remaining elements we start again from the beginning
		if (!ringIter.hasNext())
		{
			return ringIter = circle.iterator();
		}
		return ringIter;
	}
}