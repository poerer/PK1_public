package lesson10;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

public class Application5Queue {

	public static void main(String[] args)
	{
		System.out.println("--Queue--");
		
		Queue<String> people = new LinkedList<String>();
		
		people.offer("Tom");
		people.offer("Kevin");
		people.offer("Stacy");
		
		System.out.println(people.poll());
		System.out.println(people.peek());
		System.out.println(people.size());
		
		//printExample();
		//ferryExample();
	}
	/**
	 * Comparing the schedule of stacks vs. queues
	 */
	public static void ferryExample()
	{
		Queue<String> ferries = new ArrayDeque<String>();
		ferries.offer("Mercedes");
		ferries.offer("Opel");
		ferries.offer("BMW");
		ferries.offer("Honda");
		ferries.offer("VW");
		System.out.println(ferries);
		while(!ferries.isEmpty())
		{
			System.out.print(ferries.poll() + " ");
		}
		System.out.println();
	}
	/**
	 * This method explains a possible scenario in which queues are a good choice for the underlying data structure.
	 */
	public static void printExample()
	{
		Queue<String> printQueue = new ArrayDeque<String>();
		printQueue.offer("1. printing job");
		printQueue.offer("2. printing job");
		printQueue.offer("3. printing job");
		printQueue.offer("4. printing job");
		printQueue.offer("5. printing job");
		System.out.println(printQueue);
		while(!printQueue.isEmpty())
		{
			System.out.println(printQueue.poll() + " ");
		}
	}
}
