package lesson08;

import lesson08.example02.*;

public class ApplicationSubstitution
{
	public static void main(String[] args)
	{
		
		//Substitution principle:
		Student max = new Student("Max", 20);
		Staff lena = new Staff("Lena", 18);
		
		System.out.println(getAgeInDays(max));
		System.out.println(getAgeInDays(lena));
		
		
		
		//instanceof operator:
		max.setId("01/1234");
		lena.setId("03/12344");
		
		University uni = new University("UKON", 100);
			//System.out.println(uni.checkId(max));
			//System.out.println(uni.checkId(lena));
	}
	
	public static int getAgeInDays(UniMember uni)
	{
		return uni.getAge() * 365;
	}
}
