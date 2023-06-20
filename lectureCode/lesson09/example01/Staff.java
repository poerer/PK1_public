package lesson09.example01;

/**
 * The class mimics the behavior of the university staff.
 * 
 * 
 * @author fuchs
 *
 */
public class Staff extends UniMember implements Salary
{
	public static int nrOfStaff;
	
	public Staff(String name, int age)
	{
		super(name, age);
		Staff.nrOfStaff++;
	}
		
	@Override
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
	
	@Override
	public double getSalary()
	{
		return 5000;
	}
}
