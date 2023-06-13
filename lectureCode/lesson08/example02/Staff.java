package lesson08.example02;

/**
 * The class mimics the behavior of the university staff.
 * 
 * 
 * @author fuchs
 *
 */
public class Staff extends UniMember
{
	public static int nrOfStaff;
	
	public Staff(String name, int age)
	{
		super(name, age);
		Staff.nrOfStaff++;
	}
	
	/**
     * Check, whether the assigned id number has a correct format.
	 * @param id
	 * @return true, if correct matriculation number; false otherwise
	 */
	public boolean checkId(String id)
	{
		if(id.length() > 6)
		{
			if(id.charAt(2) == '/')
			{
				if(id.substring(0, 2).equals("03") && 
				   Integer.parseInt(id.substring(3, id.length()-1)) > 0)
				{
					return true;
				}
			}
		}
		return false;	
	}
}
