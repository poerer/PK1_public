package lesson09.example01;

public class University
{
	private String name;
	private Student[] students;
	
	public University(String name, int capacity)
	{
		this.name = name;
		this.students = new Student[capacity];
	}
	
	/**
	 * Get the name of the University
	 * @return
	 */
	public String getName()
	{
		return this.name;
	}
	
	/**
	 * Get the capacity of the university.
	 * 
	 * @return maximum amount of students
	 */
	public int getCapacity()
	{
		return this.students.length;
	}
	
	/**
	 * Get an array of all students being registered at the university
	 * @return array of students
	 */
	public Student[] getStudents()
	{
		return this.students;
	}
	
	/**
	 * A new student registers for the university
	 * @param student
	 * @return true if successful, false otherwise
	 */
	public boolean registerStudent(Student student)
	{
		for(int i = 0; i < this.students.length; i++)
		{
			if(this.students[i] == null)
			{
				this.students[i] = student;
				student.setUniversity(this);
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Student leaves the university.
	 * One more space is available for a new student.
	 * @param student
	 * @return true if successful, false otherwise
	 */
	public boolean dropStudent(Student student)
	{
		for(int i = 0; i < this.students.length; i++)
		{
			if(this.students[i] == student)
			{
				this.students[i] = null;
				return true;
			}
		}
		return false;
	}
	
	/**
	 * Print all registered students to the console.
	 */
	public void printAllStudents()
	{
		for(Student student: this.students)
		{
			if(student != null)
			{
				System.out.println(student.getName());	
			}
		}
	}
	
	public String toString()
	{
		return this.getName();
	}
	
	public boolean checkId(UniMember member)
	{
		String id = member.getId();
		
		if(id.length() > 6 && id.charAt(2) == '/')
		{
			if(((member instanceof Student) && id.substring(0, 2).equals("01")) || 
			   ((member instanceof Staff)   && id.substring(0, 2).equals("03"))	&& 
			   Integer.parseInt(id.substring(3, id.length()-1)) > 0)
			{
				return true;
			}
		}
		return false;	
	}
}
