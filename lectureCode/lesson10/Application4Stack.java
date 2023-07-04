package lesson10;

import java.util.Stack;

public class Application4Stack {
	
	public static void main(String[] args)
	{
		System.out.println("--Stack--");
		
		Stack<Integer> stack = new Stack<Integer>();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);	
		
		System.out.println(stack.search(40));
		System.out.println(stack.search(10));
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		
		
		//undoExample();
		//ferryExample();
	}
	/**
	 * Comparing the schedule of stacks vs. queues
	 */
	public static void ferryExample()
	{
		Stack<String> ferries = new Stack<String>();
		ferries.push("Mercedes");
		ferries.push("Opel");
		ferries.push("BMW");
		ferries.push("Honda");
		ferries.push("VW");
		System.out.println(ferries);
		while(!ferries.isEmpty())
		{
			System.out.print(ferries.pop() + " ");
		}
		System.out.println();
	}
	/**
	 * This method explains a possible scenario in which stacks are a good choice for the underlying data structure.
	 */
	public static void undoExample()
	{
		Stack<String> operation = new Stack<String>();
		operation.push("action: new document");
		operation.push("action: enlargeFontSize");
		operation.push("action: write(My First Research Paper)");
		operation.push("action: shrinkFontSize");
		operation.push("action: write(In this ...)");
		operation.push("action: save document");
		System.out.println(operation);
		while(!operation.isEmpty())
		{
			System.out.println("undo " + operation.pop() + " ");
		}
	}
}
