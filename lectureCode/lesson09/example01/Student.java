package lesson09.example01;

/**
 * This class mimics the behavior of a student.
 * Students have a name, are registered at a university and have a certain age.
 * These characteristics are mandatory and must, therefore, be specified during
 * initialization. 
 * 
 * Additionally, students can borrow up to three books and could get a matriculation
 * number.
 * 
 * @author fuchs
 *
 */
public class Student extends UniMember
{
	public static final int MAX_ECTS = 80;
	public static int nrOfStudents;
	private String[] borrowedBooks = new String[3];
	
	/**
	 * Constructor
	 * 
	 */
	public Student(String name, int age)
	{
		super(name, age);
		Student.nrOfStudents++;
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
	
	@Override
	public boolean checkId(String id)
	{
		if(id.length() > 6)
		{
			if(id.charAt(2) == '/')
			{
				if(id.substring(0, 2).equals("01") && 
				   Integer.parseInt(id.substring(3, id.length()-1)) > 0)
				{
					return true;
				}
			}
		}
		return false;	
	}
}
