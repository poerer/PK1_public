package lesson06;

/**
 * This class mimics the behavior of a student.
 * 
 * @author fuchs
 *
 */
public class Student3
{
	public String name;
	public String university;
	public int matrNr = -1;
	public int age;
	public String[] borrowedBooks = new String[3];
	
	/**
	 * Print all borrowed books to the console.
	 */
	public void printBorrowedBooks()
	{
		for(String book: borrowedBooks)
		{
			System.out.println(book);
		}
	}
	
	/**
	 * Borrow a book given its title and the number of the
	 * shelf where the book will be stored.
	 * @param bookTitle - the title of the book as String
	 * @param shelf - value between 0 and 2
	 */
	public void borrowBook(String bookTitle, int shelf)
	{
		borrowedBooks[shelf] = bookTitle;	
	}
}
