package lesson09.generics;

public class Pair
{
	private Object l;
	private Object r;
	
	/**
	 * All Objects are allowed to construct a pair.
	 * Even Objects of a different type.
	 * @param l
	 * @param r
	 */
	public Pair(Object l, Object r)
	{
		this.l = l;
		this.r = r;
	}
	
	/**
	 * get left element as Object
	 * @return
	 */
	public Object getL()
	{
		return this.l;
	}
	
	/**
	 * get right element as Object
	 * @return
	 */
	public Object getR()
	{
		return this.r;
	}
	
	/**
	 * Print the pair to the console
	 */
	public String toString()
	{
		return "(l,r) = (" + l + "," + r + ")";
	}
}
