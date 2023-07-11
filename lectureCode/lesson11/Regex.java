package lesson11;

import java.util.ArrayList;
import java.util.List;

public class Regex
{
	public Regex()
	{
		System.out.println("--Regular Expressions--");
		exampleRegex();
	
	}
	
	private void exampleRegex()
	{
		List<String> lost = new ArrayList<String>();
		lost.add( "I lost my wallet");
		lost.add( "I lost my phone");
		lost.add( "I lost my: money");
		lost.add( "I lost my: red");
		
		for(String content : lost)
		{
			System.out.println(content.matches("I lost my wallet"));
			//System.out.println(content.matches("I lost my \\w+"));
			//System.out.println(content.matches("I lost my:? \\w+"));
			//System.out.println(content.matches("I lost my:? (wallet|money|phone)"));
		}
		/*
		System.out.println("D13-b".matches("(\\w+[^1-8](2|3))-[a-z0-9]"));
		System.out.println("FaLsE!2-Z".matches("(\\w+[^1-8](2|3))-[a-z0-9]"));
		System.out.println("tRuEÄ2-a".matches("(\\w+[^1-8](2|3))-[a-z0-9]"));
		*/
	}
}
