package lesson08.example01;

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
	
	public Staff()
	{
		Staff.nrOfStaff++;
	}
}
