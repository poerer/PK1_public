package lesson06;

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
public class Student
{
	private String name;
	private String university;
	private int matrNr = -1;
	private int age;
	private String[] borrowedBooks = new String[3];

	
	/**
	 * Constructor
	 * 
	 * @param name - the name of the student (cannot be changed)
	 * @param university - the university the student is enrolled in (cannot be changed)
	 * @param age - the student's age (cannot be changed)
	 */
	public Student(String name, String university, int age)
	{
		this.name = name;
		this.university = university;
		this.age = age;
	}
	
	
	/**
	 * Set the matriculation number.
	 * The number must not be negative or 0.
	 * @param matrNr - a positive integer number
	 */
	public void setMatrNr(int matrNr)
	{
		if(matrNr > 0)
		{
			this.matrNr = matrNr;
		}
	}
	
	/**
	 * Get the matriculation number of the respective 
	 * student.
	 * @return the matriculation number. -1 if not yet set.
	 */
	public int getMatrNr()
	{
		return this.matrNr;
	}
	
	/**
	 * Get the age of the student
	 * @return
	 */
	public int getAge()
	{
		return this.age;
	}
	
	/**
	 * Get the name of the student
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Get the university the student is enrolled in
	 * @return
	 */
	public String getUniversity()
	{
		return this.university;
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
