package lesson08;
import lesson08.example02.*;

public class ApplicationStudent2
{
	public static void main(String[] args)
	{	
		University konstanz = new University("UKON", 100);
		UniMember member = new UniMember("Clara", 50);
		Student max = new Student("Max", 20);
		konstanz.registerStudent(max);
		max.printMember();
			System.out.println(max);
		
		System.out.println(member.checkId("02/123123"));
		System.out.println(max.checkId("02/123123"));
	}
}
