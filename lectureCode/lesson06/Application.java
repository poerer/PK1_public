package lesson06;

public class Application
{
	public static void main(String[] args)
	{
		Student1 max = new Student1();
			//System.out.println(max);
		
		Student2 frauke = new Student2();
			//System.out.println(frauke);
			//System.out.println(frauke.age);
		frauke.age = 22;
			//System.out.println(frauke.age);
		frauke.age++;
		int age = frauke.age;
			//System.out.println(age);
				
		
		Student3 klaus = new Student3();
		klaus.name = "Klaus";
		klaus.borrowBook("1984", 0);
		klaus.borrowBook("Harry Potter", 1);
		klaus.borrowBook("Game of Thrones", 2);
			//System.out.println(klaus.name);
			//klaus.printBorrowedBooks();
		
		Student3 thorsten = new Student3();
		thorsten.name = "Thorsten";
		thorsten.borrowBook("Tourguide", 0);
		thorsten.borrowBook("Wheel of Time", 1);
		thorsten.borrowBook("Rumo", 2);
			//System.out.println(thorsten.name);
			//thorsten.printBorrowedBooks();
		
	
		Student4 lena = new Student4();
			//lena.name = "Lena";
			//System.out.println("Matr.: " + lena.getMatrNr());
		lena.setMatrNr(123456);
			//System.out.println("Matr.: " + lena.getMatrNr());
		//lena.borrowBook("Game of Thrones", 4);
			//lena.printBorrowedBooks();
	
		Student bert = new Student("Bert", "University of Konstanz", 19);
		
			//System.out.println(bert.getName());
			//System.out.println(bert.getUniversity());
			
			//Student bert1 = new Student();

		/*
		 * ++++++++++++++++++++++++++++++++++++
		 * ++++++++++++++FRACTION++++++++++++++
		 * ++++++++++++++++++++++++++++++++++++
		 */
		
		Fraction frac1 = new Fraction(); 
		Fraction frac2 = new Fraction(5); 
		Fraction frac3 = new Fraction(20, 5); 
			//frac1.printFraction();
		frac2.multiply(10);
			//frac2.printFraction();
			//frac2.printFractionReduced();
			
		//Aliasing
		Fraction frac4 = frac2;
			//frac4.printFraction();
		frac2.multiply(2);
			//frac4.printFraction();
			//frac3.printFractionReduced();
		
		/*
		if(frac2 == frac4)
		{
			System.out.println("equal");
		}
		else
		{
			System.out.println("not equal");
		}
		*/
	}
}
