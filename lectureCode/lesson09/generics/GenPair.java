package lesson09.generics;

public class GenPair<T>
{
	private T l;
	private T r;
	
	/**
	 * Allow only identical types T
	 * @param l
	 * @param r
	 */
	public GenPair(T l, T r)
	{
		this.l = l;
		this.r = r;
	}
	
	/**
	 * The left element
	 * @return
	 */
	public T getL()
	{
		return this.l;
	}
	
	/**
	 * get right element
	 * @return
	 */
	public T getR()
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
