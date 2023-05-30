package lesson07;

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
	public static final int MAX_ECTS = 80;
	public static int nrOfStudents;
	private String name;
	private University university;
	private String matrNr = "";
	private int age;
	private String[] borrowedBooks = new String[3];
	
	static
	{
		//System.out.println("First thing on the console...");
		//nrOfStudents = 100;
	}
	
	/**
	 * Constructor
	 * 
	 * @param name - the name of the student (cannot be changed)
	 * @param age - the student's age (cannot be changed)
	 */
	public Student(String name, int age)
	{
		nrOfStudents++;
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Set the matriculation number.
	 * The number must not be negative or 0.
	 * @param matrNr - a positive integer number
	 */
	public void setMatrNr(String matrNr)
	{
		if(matrNr.length() > 0)
		{
			this.matrNr = matrNr;
		}
	}
	
	public void setUniversity(University uni)
	{
		this.university = uni;
	}
	
	/**
	 * Get the matriculation number of the respective 
	 * student.
	 * @return the matriculation number. -1 if not yet set.
	 */
	public String getMatrNr()
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
	public University getUniversity()
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
	
	/**
	 * Check, whether the assigned matriculation number has a correct format.
	 * @param matrNr
	 * @return true, if correct matriculation number; false otherwise
	 */
	public static boolean checkMatrNr(String matrNr)
	{
		if(matrNr.length() > 6)
		{
			if(matrNr.charAt(2) == '/')
			{
				if(matrNr.substring(0, 2).equals("01") && 
				   Integer.parseInt(matrNr.substring(3, matrNr.length()-1)) > 0)
				{
					return true;
				}
			}
		}
		return false;	
	}
}
