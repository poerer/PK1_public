package lesson09;

import java.util.Arrays;

import lesson09.example02.*;

public class Application2Interface2
{
	public static void main(String[] args)
	{	
		//Show the interface Comparable
		Staff[] staffs = new Staff[4];
		staffs[0] = new Staff("Paul", 60);
		staffs[1] = new Staff("Lena", 20);
		staffs[2] = new Staff("Klaus", 40);
		staffs[3] = new Staff("Susanne", 55);
		
		Arrays.sort(staffs);
		
		for(int i = 0; i < staffs.length; i++)
		{
			System.out.println(staffs[i] + " " + staffs[i].getAge());
		}
		
	}
}
