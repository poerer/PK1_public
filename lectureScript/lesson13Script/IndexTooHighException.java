package lesson13Script;

/**
 * (*4*)
 * This class extends an exception being more specific.
 * 
 * @author fuchs
 *
 */
public class IndexTooHighException extends IndexOutOfBoundsException
{
	/**
	 * We use the constructor to provide the programmer with additional information
	 * about the circumstances why the exception was thrown.
	 * 
	 * @param index - the index the programmer was looking for
	 * @param length - the length of the array
	 */
	public IndexTooHighException(int index, int length)
	{
		System.out.println("your index: " + index + " is too high "
				+ "for the array of length: " + length);
	}
	//->switch to Exceptions.java (*5*)
}
