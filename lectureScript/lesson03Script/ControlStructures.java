package lesson03Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_conditions.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Kontrollstrukturen
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_02_006.htm
 */

/**
 * (*2*)
 * Introduction to control structures (if, else, else if, switch).
 * The statements inside your source files are generally executed from top to bottom, 
 * in the order that they appear. Control flow statements, however, break up the flow 
 * of execution by employing decision making, looping, and branching, enabling your 
 * program to conditionally execute particular blocks of code.
 * 
 * @author fuchs
 *
 */
public class ControlStructures
{
	public static void main(String[] args)
	{
		/*
		 * Feel free to change the input parameters of the methods
		 * to play around with the corresponding control structures.
		 */
		
		//explaining if-then
		ifThen(true);
		System.out.println();
		//explaining if-then-else
		ifThenElse(false);
		System.out.println();
		//explaining necessity of else if
		elseIf(50);
		System.out.println();
		//explaining switch
		switchCase(10);
		System.out.println();
		
		/*
		 * Attention:
		 * When introducing control structures the visibility of variables changes.
		 * Currently, we are only working with local variables.
		 * The identifier of a local variable is written in brown color (default).
		 * Local means that these variables are only visible in the block they have
		 * been declared and initialized.
		 * Remember: Blocks are structures displayed with curly brackets {}. Examples
		 * are the bodies of methods, which are written in curly brackets, or any kind
		 * of control structure or loop construct.
		 */
		scope();
		//->DONE
	}
	
	/**
	 * The if-then statement is the most basic of all the control flow statements. 
	 * It tells your program to execute a certain section of code only if a 
	 * particular test evaluates to true.
	 * 
	 * @param toTest - a boolean variable, which can be modified to test control structures
	 */
	public static void ifThen(boolean toTest)
	{
		//If this test evaluates to false, control jumps to the end of the if-then statement.
		if(toTest == true)
		{
			//this block is the 'then' clause:
			System.out.println("this is the \"then\" clause");
		}
		System.out.println("code executed after the control structure.");
	}
	
	/**
	 * The if-then-else statement provides a secondary path of 
	 * execution when an "if" clause evaluates to false
	 * 
	 * @param toTest - a boolean variable, which can be modified to test control structures
	 */
	public static void ifThenElse(boolean toTest)
	{
		//If this test evaluates to false, control jumps to the else block.
		if(toTest == true)
		{
			//this block is the 'then' clause:
			System.out.println("this is the \"then\" clause");
		}
		else
		{
			//this block is the 'else' clause:
			System.out.println("this is the \"else\" clause");
		}
		System.out.println("code executed after the control structure.");
	}
	
	public static void elseIf(int points)
	{
		/*
		 * The value of points can satisfy more than one expression 
		 * in the compound statement: 50 > 30 and 50 > 20. Therefore,
		 * ALL statements, which are correct, are executed.
		 */
		if(points > 10)
		{
			System.out.println("if: points > 10");
		}
		if(points > 20)
		{
			System.out.println("if: points > 20");
		}
		if(points > 30)
		{
			System.out.println("if: points > 30");
		}
		else
		{
			//this block is the 'else' clause:
			System.out.println("if: this is the \"else\" clause");
		}
		
		/*
		 * The value of points can satisfy more than one expression 
		 * in the compound statement: 50 > 30 and 50 > 20. However, 
		 * once a condition is satisfied, the appropriate statements 
		 * are executed (50 > 10) and the remaining conditions are not evaluated.
		 */
		if(points > 10)
		{
			System.out.println("else if: points > 10");
		}
		else if(points > 20)
		{
			System.out.println("else if: points > 20");
		}
		else if(points > 30)
		{
			System.out.println("else if: points > 30");
		}
		else
		{
			//this block is the 'else' clause:
			System.out.println("else if: this is the \"else\" clause");
		}		
	}
	
	/**
	 * Unlike if-then and if-then-else statements, the switch statement can 
	 * have a number of possible execution paths.
	 * The body of a switch statement is known as a switch block. 
	 * A statement in the switch block can be labeled with one or more case 
	 * or default labels. The switch statement evaluates its expression, 
	 * then executes all statements that follow the matching case label.
	 * 
	 * @param month
	 */
	public static void switchCase(int month)
	{
		/*
		 * The following code example uses an int named month whose value 
		 * represents a month. The code displays the name of the month, 
		 * based on the value of month, using the switch statement.
		 * 
		 * An important point of interest is the break statement. 
		 * Each break statement terminates the enclosing switch statement. 
		 * Control flow continues with the first statement following the switch block. 
		 * The break statements are necessary because without them, statements 
		 * in switch blocks fall through: All statements after the matching case label 
		 * are executed in sequence, regardless of the expression of subsequent 
		 * case labels, until a break statement is encountered. 
		 */
		String monthString;
        switch (month) 
        {
            case 1:  monthString = "January";
                     break; //Each break statement terminates the enclosing switch statement.
            case 2:  monthString = "February";
                     break;
            case 3:  monthString = "March";
                     break;
            case 4:  monthString = "April";
                     break;
            case 5:  monthString = "May";
                     break;
            case 6:  monthString = "June";
                     break;
            case 7:  monthString = "July";
                     break;
            case 8:  monthString = "August";
                     break;
            case 9:  monthString = "September";
                     break;
            case 10: monthString = "October";
                     break;
            case 11: monthString = "November";
                     break;
            case 12: monthString = "December";
                     break;
            default: monthString = "Invalid month";
                     break;
        }
        System.out.println("switch case: current month " + monthString);
        
        //You could also display the name of the month with if-then-else statements:
        if (month == 1) 
        {
            System.out.println("January");
        } 
        else if (month == 2) 
        {
            System.out.println("February");
        }
        //...and so on
        
        /*
         * Deciding whether to use if-then-else statements or a switch statement is based 
         * on readability and the expression that the statement is testing. An if-then-else 
         * statement can test expressions based on ranges of values or conditions, whereas 
         * a switch statement tests expressions based only on a single integer, 
         * enumerated value, or String object.
         */
        
        /*
         * The following code example shows how a statement can have multiple case labels. 
         * The code example calculates the number of days in a particular month:
         */
        int year = 2000;
        int numDays = 0;

        switch (month) 
        {
            case 1: case 3: case 5:
            case 7: case 8: case 10:
            case 12:
                numDays = 31;
                break;
            case 4: case 6:
            case 9: case 11:
                numDays = 30;
                break;
            case 2:
                if (((year % 4 == 0) && 
                     !(year % 100 == 0))
                     || (year % 400 == 0))
                    numDays = 29;
                else
                    numDays = 28;
                break;
            default:
                System.out.println("Invalid month.");
                break;
        }
        System.out.println("switch case: number of days = " + numDays);
	}
	
	/**
	 * This method explains, how the block scope works.
	 */
	public static void scope()
	{
		/*
		 * A block begins with an open brace {, followed by zero or more statements, 
		 * followed by a close brace }. You can declare local variables anywhere in 
		 * a method body. However, if you declare a variable within a block, then it 
		 * only has scope within the block.
		 */
		if(4 < 5)
		{
			//new block
			int y = 10; //initialize a new local variable.
		}
			//y = 20; //will not work, uncomment to check!
		/*
		 * We started a block and within the block we declared y. y is created at the 
		 * declaration. It disappears once we exit the end of the block. Thus, assigning
		 * a new value to y fails to compile because y is not in scope. It's only valid 
		 * within a block.
		 * The block is often called the inner scope. The method body is then the outer 
		 * scope. If you can't find the variable you're looking for in the inner scope, 
		 * then you look at the outer scope. This is how x is found. When you start a 
		 * block, it has access to all variables as if you had never started the block. 
		 * When you exit a block, the variables in the block are invalid.
		 */
		int x = 4;
		if(4 > 2)
		{
			//new block (inner scope) has access to variables of the outer scope (method)
			x = 10;
			int z = 3;
			if(true) //change the condition to false to see the influence on x.
			{
				//new block (inner scope) has access to variables of the outer scope (the outer if block)
				x = 15;
				z = 5;
			}
		}
		System.out.println("scope of variables: " + x);
		//the method cannot access variables declared within the if clauses
			//z = 10; //uncomment to see the error
	}
}
