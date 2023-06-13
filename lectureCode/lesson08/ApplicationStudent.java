package lesson08;

import lesson08.example01.*;

public class ApplicationStudent
{
	public static void main(String[] args)
	{
		UniMember parent = new UniMember();
		parent.setUniversity(new University("UKON", 50));
		System.out.println(parent.getUniversity());
		
		Student child = new Student();
		child.setUniversity(new University("NYU", 100));
		System.out.println(child.getUniversity());
		
		Staff childStaff = new Staff();
		childStaff.setId("03/12343");
		System.out.println(childStaff.getId());
		
	}
}
