package lesson11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Example for reading and writing data. Also includes some pattern matching with regular expressions.
 * This example is just to show some simple regular expressions. It will not work on real world data. 
 * @author Fuchs
 *
 */
public class Anonymous
{
	private BufferedWriter output;
		
	public Anonymous()
	{
		System.out.println("--Reading/Writing data--");
		// read the file
		readFile("mail.txt");
		//readFile("mbox");
	}

	private void readFile(String fileName)
	{
		File data = new File("Data" + File.separator + "mails" + File.separator + fileName);
		BufferedReader input;
		
		try
		{
			//initialize the BufferedReader. 
			input = new BufferedReader(new FileReader(data));
			//initialize the BufferedWriter.
			output = new BufferedWriter(new FileWriter("Data" + File.separator + "mails" + File.separator + fileName + "Anonymous.txt"));
			String line;
			String[] words;
			//read the input line by line
			while((line = input.readLine()) != null)
			{
				//split the individual words.
				words = line.split("\\s");
				
				//check the words individually
				for(String word: words)
				{
					//make the named entities anonymous
					hideEMail(word);
				}
			}
			//done reading and writing the data to the file
			input.close();		
			output.close();
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
	
	/**
	 * Make the email addresses anonymous 
	 * @param word single word
	 */
	private void hideEMail(String word)
	{
		//use a regex to find the mail addresses	
		String anonym = word.replaceAll("[\\w\\.]+@[\\w-]+\\.[\\w]+", "<email>");
		writeFile(anonym+" ");
	}	
	
	/**
	 * stream the data to the BufferedWriter.
	 * Insert a new line after a period.
	 * @param anonym
	 */
	private void writeFile(String anonym)
	{
		try
		{
			output.write(anonym);
			System.out.print(anonym);
			//If there is a period followed by a blank space, insert a line break.
			if(anonym.matches(".*\\.\\s"))
			{
				output.newLine();
				System.out.println();
			}
		} 
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
