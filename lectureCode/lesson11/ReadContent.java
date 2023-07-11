package lesson11;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ReadContent {


	public ReadContent(File data) 
	{
		System.out.println("Read content of File: " + data.getName());
		BufferedReader in;
		
		try 
		{
			in = new BufferedReader(new FileReader(data));

			String line;
			String[] word;
			
			//read the input line by line
			while((line = in.readLine()) != null)
			{
				//print the single lines to the console
					System.out.println(line);
				
				
				word = line.split(",");
					
				for(String token: word)
				{
					
					//print the single tokens
						System.out.println(token);
				}
				
			}
			in.close();
		} 
		catch (IOException e) 
		{
			e.printStackTrace();
		}
	}
}
