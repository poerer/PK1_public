package lesson11;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ReadImage
{

	public ReadImage()
	{
		File image = new File("Data" + File.separator + "uni.png");
		readFileByte(image);
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
			/*
			int b = input.read();
			while(b != -1)
			{
				System.out.print(b + " ");
				b = input.read();
			}
			*/
			
			BufferedImage loader = ImageIO.read(input);
			workWithImage(loader);			
			
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
	 * Read the image and print it to the console using characters
	 * @param loader
	 */
	private void workWithImage(BufferedImage loader)
	{
		int width = loader.getWidth();
		int height = loader.getHeight();
		
		System.out.println("width: " + width);
		System.out.println("height: " + height);
		
		//run over the image pixelwise
		//if RGB value is != 0  print 1 otherwise print 0
		for(int i = 0; i < height; i++)
		{
			for(int j = 0; j < width; j++)
			{
				if(loader.getRGB(j, i)!=0)System.out.print("1");
				else System.out.print("0");
			}
			System.out.println();
		}
	}
}


