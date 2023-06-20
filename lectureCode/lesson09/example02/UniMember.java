package lesson09.example02;

/**
 * This class is a parent class for all members of a
 * university. It comes with several fields to best
 * represent the state of university members.
 * 
 * @author fuchs
 *
 */
public abstract class UniMember 
{
	private String name;
	private University university;
	private String id = "";
	private int age;
	
	public UniMember(String name, int age)
	{
		this.name = name;
		this.age = age;
	}
	
	/**
	 * Set the id number.
	 * The number must not be negative or 0.
	 * @param matrNr - a positive integer number
	 */
	public void setId(String id)
	{
		if(id.length() > 0)
		{
			this.id = id;
		}
	}
	
	/**
	 * Set the university
	 * @param uni
	 */
	public void setUniversity(University uni)
	{
		this.university = uni;
	}
	
	/**
	 * Get the id number of the respective 
	 * student.
	 * @return the matriculation number. -1 if not yet set.
	 */
	public String getId()
	{
		return this.id;
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
     * Check, whether the assigned id number has a correct format.
	 * @param id
	 * @return true, if correct id number; false otherwise
	 */
	public abstract boolean checkId(String id);
	
	
	public final void printMember()
	{
		System.out.println("Name: " + this.name);
		System.out.println("Age: " + this.age);
		System.out.println("University: " + this.university);
	}
	
	public String toString()
	{
		return "Name: " + this.name;
	}
}
