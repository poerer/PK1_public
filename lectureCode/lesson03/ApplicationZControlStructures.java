package lesson03;

/**
 * Explaining control structures
 * 
 * @author Fuchs
 *
 */
public class ApplicationZControlStructures
{

	public static void main(String[] args)
	{
		System.out.println("--Control Structures--");
		// ifStatement();
		 ifStatementShort();
		// ifElseIfStatement();
		// handsOnSession();
		// switchCaseStatement();
		// switchCaseStatementNew();
	}

	/**
	 * classic if statement
	 */
	public static void ifStatement()
	{
		boolean isChecked = false;
		char state;

		if (isChecked == true)
		{
			state = '+';
		} 
		else
		{
			state = '-';
		}

		System.out.println("Leading sign: " + state);
	}

	/**
	 * Method explaining possible problems when writing in short format
	 */
	public static void ifStatementShort()
	{
		boolean isChecked = true;
		char state;

		if (isChecked)
			state = '+';
			//System.out.println("True");
		else
			state = '-';
			System.out.println("False");
		
		
		System.out.println("Leading sign: " + state);
	}

	/**
	 * classic elseif statement
	 */
	public static void ifElseIfStatement()
	{
		boolean hungry = true;
		boolean workingDay = true;
		String state = "";

		if (hungry == true)
		{
			state = "eat something";
		} 
		if (workingDay == true)
		{
			state = state + " go to work";
		} 
		else
		{
			state = state + " stay at home";
		}

		System.out.println(state);
	}

	/**
	 * Test your understanding of the logic operators and their combinations
	 */
	public static void handsOnSession()
	{
		boolean a, b, c, d;
		a = false; 	
		b = true;
		c = false;
		d = true;	
		if (a && b || c && d)
		{
			System.out.println("A");
		}
		else if (a && b && c || d)
		{
			System.out.println("B");
		}
		else if (a && b && (c || d))
		{
			System.out.println("C");
		}
	}

	/**
	 * classic switch case statement
	 */
	public static void switchCaseStatement()
	{
		int count = 0;

		switch (count)
		{
			case 0:
				System.out.println("zero");
				break;
			case 1:
				System.out.println("one");
				break;
			case 2:
				System.out.println("two");
				break;
			default:
				System.out.println("?");
				break;
		}
		/*
		 * String status = "average"; switch(status) { case "bad":
		 * System.out.println("Needs to be repaired..."); break; case "average":
		 * System.out.println("No worries..."); break; case "optimal":
		 * System.out.println("Everything is working..."); break; default:
		 * System.out.println("Undefined status..."); break; }
		 */
		/*
		 * boolean severe = false; String message = "cold"; switch(message) {
		 * case "cold": if(severe == true) System.out.println("Go to bed...");
		 * else System.out.println("Go to work..."); break; case "fever":
		 * if(severe == true) System.out.println("See a doctor..."); else
		 * System.out.println("Go to bed..."); break; case "headache": if(severe
		 * == true) System.out.println("Go to a hospital..."); else
		 * System.out.println("Simulating?"); break; default:
		 * System.out.println("Unknown disease"); break; }
		 */

	}
	/**
	 * New switch case (Java 17)
	 */
	public static void switchCaseStatementNew()
	{
		int days;
		String month = "February";
		switch(month)
		{
			case "January", "March", "May", "July",
			"August", "October", "December" -> {days = 31;}
			case "April", "June", "September", 
			"November" -> {days = 30;}
			case "February" -> days = 28;
			default -> days = 0;
		}
		System.out.println("Days: " + days);
		
		
		
		int day = switch(month)
		{
			case "January", "March", "May", "July",
			"August", "October", "December" -> 31;
			case "April", "June", "September", 
			"November" -> 30;
			case "February" -> 28;
			default -> 0;
		};
		System.out.println("Days: " + day);
	}
}
