package lesson07;

public class Application
{
	public static void main(String[] args)
	{
			//System.out.println(Student.nrOfStudents);
		Student klaus = new Student("Klaus", 19);
		Student petra = new Student("Petra", 20);
			//System.out.println(Student.nrOfStudents);
			//System.out.println(klaus.nrOfStudents);	//caution 

		petra.setMatrNr("01/12344");
		klaus.setMatrNr("01-23452");
			//System.out.println(Student.checkMatrNr(petra.getMatrNr()));
			//System.out.println(Student.checkMatrNr(klaus.getMatrNr()));
		
		
		
		
		
		
		/*
		 * +++++++++++++++++++++++++++++++++++++
		 * ++++++++++++++Relations++++++++++++++
		 * +++++++++++++++++++++++++++++++++++++
		 */
		
		University konstanz = new University("University of Konstanz", 100);
		Student bert = new Student("Bert", 19);
		bert.setUniversity(konstanz);
			//System.out.println(bert.getName());
			//System.out.println(konstanz.getName());
			//System.out.println(bert.getUniversity().getName());
			
			
		
		
		
		
		
		
		Student tom = new Student("Tom", 50);
		Student lena = new Student("Lena", 20);
		konstanz.registerStudent(bert);
		konstanz.registerStudent(lena);
		konstanz.registerStudent(tom);
			//konstanz.dropStudent(lena);
			//System.out.println(lena.getUniversity());
			//konstanz.printAllStudents();
		
		
		/*
		 * ++++++++++++++++++++++++++++++++++
		 * ++++++++++++++MyList++++++++++++++
		 * ++++++++++++++++++++++++++++++++++
		 */
		
		MyList list = new MyList();
			//System.out.println(list.getSize());
		list.add(10);
		list.add(5);
		list.add(10);
			//System.out.println(list.get(1));
			//System.out.println(list.getSize());
	}
}
