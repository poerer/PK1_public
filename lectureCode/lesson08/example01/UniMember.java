package lesson08.example01;

/**
 * This class is a parent class for all members of a
 * university. It comes with several fields to best
 * represent the state of university members.
 * 
 * @author fuchs
 *
 */
public class UniMember
{
	private String name;
	private University university;
	private String id = "";
	private int age;
	
	
	public UniMember()
	{
		System.out.println("Parent");
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

}
