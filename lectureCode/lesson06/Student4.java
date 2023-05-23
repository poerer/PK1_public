package lesson06;

/**
 * This class mimics the behavior of a student.
 * 
 * @author fuchs
 *
 */
public class Student4
{
	private String name;
	private String university;
	private int matrNr = -1;
	private int age;
	private String[] borrowedBooks = new String[3];

	/**
	 * Set the matriculation number.
	 * The number must not be negative or 0.
	 * @param matrNr - a positive integer number
	 */
	public void setMatrNr(int nr)
	{
		if(nr > 0)
		{
			this.matrNr = nr;
		}
	}
	
	/**
	 * Get the matriculation number of the respective 
	 * student.
	 * @return the matriculation number. -1 if not yet set.
	 */
	public int getMatrNr()
	{
		return matrNr;
	}
	
	public int getAge()
	{
		return age;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getUniversity()
	{
		return university;
	}
	/**
	 * Borrow a book given its title and the number of the
	 * shelf where the book will be stored.
	 * @param bookTitle - the title of the book as String
	 * @param shelf - value between 0 and 2
	 */
	public void borrowBook(String bookTitle, int shelf)
	{
		if(shelf >= 0 && shelf < borrowedBooks.length)
		{
			borrowedBooks[shelf] = bookTitle;	
		}
		else
		{
			System.out.println("Cannot borrow " + bookTitle + " because shelf " + shelf + " is invalid");
		}
	}
	
	/**
	 * Print all borrowed books to the console.
	 */
	public void printBorrowedBooks()
	{
		for(String book: borrowedBooks)
		{
			if(book != null)
			{
				System.out.println(book);
			}
		}
	}
}
