package lesson06;

/**
 * This class mimics the behavior of a fraction
 * 
 * @author fuchs
 *
 */
public class Fraction {

	//Properties
	private int numerator;
	private int denominator;	
	
	//Constructors
	public Fraction()
	{
		this(1,1);
	}
	public Fraction(int denominator)
	{
		this(1, denominator);
	}
	public Fraction(int numerator, int denominator)
	{
		this.numerator = numerator;
		if(denominator == 0)
		{
			System.out.println("Denominator must not be 0, set to 1 instead");
			this.denominator = 1;
		}
		else
		{
			this.denominator = denominator;	
		}
	}
	
	//Setter/Getter 
	/**
	 * Set the numerator 
	 * @param numerator (int)
	 */
	public void setNumerator(int numerator)
	{
		this.numerator = numerator;
	}
	/**
	 * Set the denominator (int) which must not be 0
	 * @param denominator (int)
	 */
	public void setDenominator(int denominator)
	{
		if(denominator == 0)
		{
			System.out.println("Denominator must not be 0");
		}
		else
		{
			this.denominator = denominator;
		}
	}
	/**
	 * Get the numerator
	 * @return numerator (int)
	 */
	public int getNumerator()
	{
		return this.numerator;
	}
	/**
	 * Get the denominator
	 * @return denominator (int)
	 */
	public int getDenominator()
	{
		return this.denominator;
	}
	
	//Capabilities
	/**
	 * Print attributes to the console
	 */
	public void printFraction()
	{
		System.out.println(numerator + "/" + denominator);
	}
	/**
	 * Multiply the fraction with an integer value.
	 * 
	 * @param value - the integer value, which will be multiplied with the
	 * numerator
	 */
	public void multiply(int value)
	{
		this.numerator = this.numerator * value;
	}
	
	/**
	 * Reduce the fraction
	 */
	private void reduce()
	{
		int z, n, r;
		z = numerator;
		n = denominator;
		r = z % n;
		while(r > 0)
		{
			z = n;
			n = r;
			r = z % n;
		}
		numerator = numerator / n;
		denominator = denominator / n;
	}
	
	/**
	 * Print reduced fraction
	 */
	public void printFractionReduced()
	{
		reduce();
		printFraction();
	}
}
