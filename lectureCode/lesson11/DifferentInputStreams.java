package lesson11;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class DifferentInputStreams
{
	public DifferentInputStreams()
	{
		System.out.println("--Different Input Streams--");
		//simple input file with standard characters
			File file = new File("Data" + File.separator + "inputTest1.txt");
		//Use a different input file including special characters
			//File file = new File("Data" + File.separator + "inputTest2.txt");
		
		readFileByte(file);
		System.out.println();
		readFileChar(file);
	}
	/**
	 * Reading a file using a FileInputStream (1 Byte)
	 * @param file
	 */
	private void readFileByte(File file)
	{
		System.out.println("FileInputStream:");
		FileInputStream input;
		try
		{
			input = new FileInputStream(file);
			int b = input.read();
			
			while(b != -1)
			{
				System.out.print((char)b);
				//System.out.print("-"+b + " ");
				b = input.read();
			}
			input.close();			
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	/**
	 * Read the file using a FileReader (2 Bytes)
	 * @param file
	 */
	private void readFileChar(File file)
	{
		System.out.println("FileReader:");
		FileReader input;
		try
		{
			input = new FileReader(file);
			int c = input.read();
			
			while(c != -1)
			{
				System.out.print((char)c);
				//System.out.print("-"+c + " ");
				c = input.read();
			}
			input.close();
		} 
		catch (FileNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
