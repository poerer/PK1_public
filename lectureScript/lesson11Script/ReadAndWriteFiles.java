package lesson11Script;
/*
 * Additional resources you might find useful:
 * https://de.wikibooks.org/wiki/Java_Standard:_Datenströme
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_17_001.htm
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * (*2*)
 * Introduction to Streams.
 * An I/O Stream represents an input source or an output destination. A stream 
 * can represent many different kinds of sources and destinations, including 
 * disk files, devices, other programs, and memory arrays.
 * Streams support many different kinds of data, including simple bytes, primitive 
 * data types, localized characters, and objects. Some streams simply pass on 
 * data; others manipulate and transform the data in useful ways. No matter how 
 * they work internally, all streams present the same simple model to programs 
 * that use them: A stream is a sequence of data. A program uses an input stream 
 * to read data from a source, one item at a time. A program uses an output 
 * stream to write data to a destination, one item at a time.
 * For us, the most important distinction is whether we have to use a byte
 * oriented stream or a character oriented stream.
 * 
 * Byte streams:
 * Programs use byte streams to perform input and output of 8-bit bytes. All 
 * byte stream classes are descended from InputStream and OutputStream.
 * There are many byte stream classes. To demonstrate how byte streams work, 
 * we'll focus on the file I/O byte streams, FileInputStream and FileOutputStream. 
 * Other kinds of byte streams are used in much the same way; they differ mainly 
 * in the way they are constructed.
 * 
 * Character streams:
 * The Java platform stores character values using Unicode conventions. Character 
 * stream I/O automatically translates this internal format to and from the 
 * local character set. In Western locales, the local character set is usually an 
 * 8-bit superset of ASCII. For most applications, I/O with character streams is 
 * no more complicated than I/O with byte streams. Input and output done with 
 * stream classes automatically translates to and from the local character set. 
 * A program that uses character streams in place of byte streams automatically 
 * adapts to the local character set.
 * 
 * Rule of thumb:
 * If your file contains characters such as words or numbers, please, use a 
 * character stream. Byte streams should only be used for the most primitive form
 * of I/O.
 * 
 * @author fuchs
 *
 */
public class ReadAndWriteFiles
{
	public static void main(String[] args)
	{
		//First, we have to access our file using a path to the location.
		File file = new File("src" + File.separator + "/lesson11Script" + 
									 File.separator + "original");
		//We can quickly check, whether it is really a file
		System.out.println("Is it a file: " + file.isFile());
		//Since it is a file, we can try to read its content
			//readContentByte(file); //uncomment->switch to the method to see the code
			//readContentChar(file); //uncomment->switch to the method to see the code
		/*
		 * Currently, we are using the stream to read one symbol at a time. This
		 * is really inefficient. I/O queries take a lot of resources, which we
		 * want to reduce. That is why we are using a buffer to read many symbols 
		 * at a time instead of using the read() method, which
		 * reads just one symbol.
		 */
			//readContentBuffer(file); //uncomment->switch to the method to see the code
		/*
		 *  As you can see, reading the content of a file is not this complicated.
		 *  Same thing is true for writing data to a file. Just assume we want to
		 *  copy the content to another file:
		 */
			//copyContent(file); //uncomment->switch to the method to see the code
		
		/*
		 * Summary:
		 * The java.io package contains many classes that your programs can use 
		 * to read and write data. Most of the classes implement sequential access 
		 * streams. The sequential access streams can be divided into two groups: 
		 * those that read and write bytes and those that read and write Unicode 
		 * characters. Each sequential access stream has a speciality, such as 
		 * reading from or writing to a file, filtering data as its read or written, 
		 * or serializing an object. 
		 */
		//->switch to StringRegex.java (*3*)	
	}
	
	/**
	 * We will access the file using a byte oriented stream.
	 * The output will be printed to the console.
	 * 
	 * @param file - the file we want to read
	 */
	public static void readContentByte(File file)
	{
		System.out.println("+++++++++++++++++++++");
		System.out.println("Byte oriented stream:");
		//We are using a FileInputStream because we read the data from a file
		FileInputStream in;
		
		/*
		 * you can see two new keywords: try, catch
		 * These keywords are responsible for exception handling. This topic will
		 * be introduced later. Just copy the try and catch block without thinking
		 * too much about the structure. The overall idea is that we TRY to do 
		 * something (in our case access the file) and if it fails, we CATCH the
		 * exception.
		 */
		try 
		{
			//we are initializing the stream to our file 
			in = new FileInputStream(file);
			/*
			 * This stream is now used to get the data (single bytes).
			 * The method read() can be used to read data. If there is no more
			 * data available the method will return a -1. Therefore, we can
			 * simply write a loop checking for the input -1.
			 */
			int content;
			while((content = in.read()) != -1)
			{
				//we are printing the bytes to the console.
					System.out.print(content); //uncomment to just see the chars
				//we are casting the bytes to chars
					System.out.print((char)content); //uncomment to just see the bytes
				/*
				 * Interesting are for example the byte codes 10 (new line) and 
				 * 32 empty space.
				 * You can checkout the following table to see, how chars are 
				 * encoded:			https://unicode-table.com/de/
				 * A character is encoded using a decimal number or a unicode 
				 * encoding. We already covered this topic when talking about 
				 * data types.
				 * The € symbol cannot be encoded in a byte and that is why 
				 * we get such an artifact when printing the text the console:
				 * 226â130172¬
				 */
			}
			//IMPORTANT: Always close streams when they are no longer needed.
			in.close();
			System.out.println();
			System.out.println("+++++++++++++++++++++");
		} 
		catch (IOException e) //simply copy this block
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * We will access the file using a character oriented stream.
	 * The output will be printed to the console. The code differs only slightly
	 * from the byte oriented version. It is basically just the kind of stream
	 * we are changing. Now, instead of a FileInputStream we are using a FileReader.
	 * 
	 * @param file - the file we want to read
	 */
	public static void readContentChar(File file)
	{
		System.out.println("+++++++++++++++++++++");
		System.out.println("Character oriented stream:");
		//We are using a FileReader because we read the data from a file
		FileReader in;
		
		try 
		{
			in = new FileReader(file);
			int content;
			
			while((content = in.read()) != -1)
			{
				//we are printing the bytes to the console.
					System.out.print(content); //uncomment to just see the chars
				//we are casting the bytes to chars
					System.out.print((char)content); //uncomment to just see the bytes
			}
			/*
			 * Now, you can see that 8364 corresponds to the € symbol. Since this 
			 * number is to high to be stored in a byte we can show it appropriately 
			 * with a byte oriented stream. Character streams on the other hand use
			 * two bytes to encode symbols and, therefore, are able to encode the data.
			 */
			
			//IMPORTANT: Always close streams when they are no longer needed.
			in.close();
			System.out.println();
			System.out.println("+++++++++++++++++++++");
		} 
		catch (IOException e) //simply copy this block
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * We will access the file using a character oriented stream together with
	 * a buffer to read more than just one symbol at a time.
	 * The buffer uses the input stream (in our case FileReader) to access the
	 * symbols. As a result, the BufferedReader offers a method to read an
	 * entire line as String.
	 * 
	 * @param file - the file we want to read
	 */
	public static void readContentBuffer(File file)
	{
		System.out.println("+++++++++++++++++++++");
		System.out.println("Character oriented stream with buffer:");
		//We are using a BufferedReader to enable a buffer
		BufferedReader in;
		
		try 
		{
			in = new BufferedReader(new FileReader(file));
			String content; //we have to switch from int to String
			
			while((content = in.readLine()) != null)
			{
				//we are printing the bytes to the console.
				System.out.println(content);
			}
			/*
			 * As you can see, we just have to access the file 4 times (once
			 * for each line).
			 */
			
			//IMPORTANT: Always close streams when they are no longer needed.
			in.close();
			System.out.println();
			System.out.println("+++++++++++++++++++++");
		} 
		catch (IOException e) //simply copy this block
		{
			e.printStackTrace();
		}
	}
	
	/**
	 * We will access the file using a character oriented stream together with
	 * a buffer to read more than just one symbol at a time.
	 * The data will then be written to another file using again a buffer. 
	 * 
	 * @param file - the file we want to read
	 */
	public static void copyContent(File file)
	{
		System.out.println("+++++++++++++++++++++");
		System.out.println("Copying files:");
		//We are using a BufferedReader to enable a buffer
		BufferedReader in;
		//We are using a BufferedWriter as output buffer
		BufferedWriter out; 
		//We need a file to which we copy the content
		File copy = new File("src" + File.separator + "/lesson11Script" + 
				 File.separator + "copy");
		
		try 
		{
			in = new BufferedReader(new FileReader(file));
			out = new BufferedWriter(new FileWriter(copy));
			String content;
			
			while((content = in.readLine()) != null)
			{
				//instead of printing we are copying the content
				out.write(content);
					//out.newLine(); //uncomment to get a new line per String
			}
			/*
			 * The result is a little surprising. Everything is one line. In the
			 * previous example we used the System.out.println() statement to 
			 * introduce a new line for each String. This is not happening here.
			 * That is why we have to do this manually. You can uncomment the
			 * statement:
			 * 				out.newLine();
			 * to get an identical copy.
			 */
			
			//IMPORTANT: Always close streams when they are no longer needed.
			in.close();
			out.close();
			System.out.println();
			System.out.println("+++++++++++++++++++++");
		} 
		catch (IOException e) //simply copy this block
		{
			e.printStackTrace();
		}
	}
}
