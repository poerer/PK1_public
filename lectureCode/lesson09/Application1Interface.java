package lesson09;

import lesson09.example01.*;

public class Application1Interface
{
	public static void main(String[] args)
	{
		Staff staff = new Staff("Tom", 66);
		PoliceOfficer police = new PoliceOfficer();
			Student student = new Student("Carla", 30);
		
		
		
		System.out.println(SalaryUtils.compareSalary(police, staff));
	}
}
