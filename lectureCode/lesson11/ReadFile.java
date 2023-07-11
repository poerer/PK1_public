package lesson11;

import java.io.File;

/**
 * This class introduces some methods on how to deal with files and directories 
 * @author Fuchs
 *
 */
public class ReadFile {

	public ReadFile()
	{
		System.out.println("--Read File--");
		checkDirectory();
	}
	
	/**
	 * Check the content of the directory
	 */
	private void checkDirectory()
	{
		File dataFolder = new File("Data");
		System.out.println("Does the file exist? " 			+ dataFolder.exists());
		System.out.println("Is it a directory? " 			+ dataFolder.isDirectory());
		System.out.println("Can I read the directory? " 	+ dataFolder.canRead());
		System.out.println("Can I write to the directory? " + dataFolder.canWrite());
		
		String[] directory = dataFolder.list();
		
		System.out.println("++++++++CONTENT++++++++");
		for(String content: directory)
		{
			System.out.println("--------------");
			System.out.println(content);
				checkFile(dataFolder, content);
		}
		System.out.println("++++++++CONTENT++++++++");
		
	}
	/**
	 * Check the content of the files/directories
	 * @param dataFolder (File) the directory
	 * @param fileName (String) the file name 
	 */
	private void checkFile(File dataFolder, String fileName)
	{
		File data = new File(dataFolder, fileName);
		System.out.println("Does the file exist? " 		+ data.exists());
		System.out.println("Is it a file? " 			+ data.isFile());
		System.out.println("Can I read the file? " 		+ data.canRead());
		System.out.println("Can I write to the file? " 	+ data.canWrite());
		System.out.println("How big is the file? " 		+ data.length() + " Bytes");
		
		//read the content of the file
			if(data.isFile()) new ReadContent(data);
	}
}
