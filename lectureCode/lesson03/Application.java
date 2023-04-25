package lesson03;

/**
 * Explain the use of different methods
 * @author Fuchs
 *
 */
public class Application 
{
	public static void main(String[] args)
	{
		//Start of the program
		//int result = rectangleArea(2, 4);
		//System.out.println("Area: " + result);
		
		//End of the program
			//boolean result = nAnd(true, true);
			//System.out.println(result);
			//System.out.println(args[0]);
	}
	
	/**
	 * This method calculates the area of a rectangle.
	 * @param height - the height of the rectangle
	 * @param width - the width of the rectangle
	 * @return the area of the rectangle as integer
	 */
	public static int rectangleArea(int height, int width)
	{		
		int area = height * width;
		return area;
	}
	
	/**
	 * This method simulates an NAND gate.
	 * @param a - first switch
	 * @param b - second switch
	 * @return !(a && b)
	 */
	public static boolean nAnd(boolean a, boolean b)
	{
		boolean result;
		result = !(a && b);
		return result;
	}
}


