package lesson11Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_files.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_File
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_16_001.htm
 */

//we need to import some classes to facilitate file access
import java.io.File;

/**
 * (*1*)
 * Introduction to Files.
 * The Java File class, in the Java IO API gives you access to the underlying 
 * file system. Using the Java File class you can:
 * - Check if a file or directory exists.
 * - Create a directory if it does not exist.
 * - Read the length of a file.
 * - Rename or move a file.
 * - Delete a file.
 * - Check if path is file or directory.
 * - Read list of files in a directory.
 * As you can see, the Java File class only gives you access to the file and 
 * directory meta data. If you need to read or write the content of files you
 * will have to use streams e.g., FileInputStream, FileOutputStream.
 * 
 * @author fuchs
 *
 */
public class AccessFiles
{
	public static void main(String[] args)
	{
		/*
		 * Before you can do anything with the file system or File class, you 
		 * must create a Java File instance. The class File has multiple constructors
		 * for example one, which expects a String as parameter. This String is 
		 * meant to be the path to the file or directory we want to investigate.
		 * Since Java is platform independent the delimiter between directories
		 * should be flexible (e.g., / or \). Therefore, you can make use of the 
		 * class variable:
		 * 				File.separator
		 * which automatically introduces the correct delimiter. A path can either
		 * be absolute (starting from the root of a file system) or relative
		 * (starting from your Java project).
		 * Here is an example of creating a Java File instance using a relative
		 * path:
		 */
		File file = new File("src" + File.separator + "/lesson11Script" + 
						File.separator + "original");
		//Using this instance we can now retrieve some meta information:
		System.out.println("Does the file exist? " + file.exists());
		System.out.println("Can we read the file? " + file.canRead());
		System.out.println("Can we write to the file? " + file.canWrite());
		/*
		 * Another example with File being a directory:
		 */
		File folder = new File("src" + File.separator + "/lesson11Script");
		System.out.println("Is folder a directory? " + folder.isDirectory());
		//if it is a directory, we can list all children:
		System.out.println("Children:");
		for(String child: folder.list())
		{
			System.out.print(child);
			System.out.print("   ");
		}
		System.out.println();
		/*
		 * As you can see, it is really simple to get all files and folders of
		 * a directory. We can also do this approach to crawl an entire file
		 * system. Therefore, we write a recursive method:
		 */
		//uncomment to see the outcome
				//crawlFileSystem(new File("src")); //uncomment
	}
	
	/**
	 * (*2*)
	 * We are recursively crawling a directory with all its sub directories.
	 * We print the result to the console.
	 * 
	 * @param current
	 */
	public static void crawlFileSystem(File current)
	{
		System.out.println(current);
		//get all children of this directory
		for(String child: current.list())
		{
			System.out.println("\t" + child);
			File data = new File(current, child);
			//if it is a directory, we do a recursive call
			if(data.isDirectory())
			{
				crawlFileSystem(data);
			}
		}
	}
	//->switch to ReadAndWriteFiles.java (*2*)
}
