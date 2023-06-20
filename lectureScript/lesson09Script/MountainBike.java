package lesson09Script;

/**
 * Same class as in the previous chapter. We just slightly modified the
 * printDescription method and removed the super.printDescription() statement.
 * We did this because otherwise we would have called the method printDescription
 * from the parent first. However, as you know, this method is abstract now. This
 * means it has no implementation. Therefore, this call would have resulted in a
 * compiler error.
 * 
 * @author fuchs
 *
 */
public class MountainBike extends Bicycle
{
	private int seatHeight;
	
	/**
	 * This is the constructor of our mountain bike. As you can see, it expects
	 * one value for the seat height.
	 * 
	 * @param seatHeight - the seat height of the mountain bike in cm
	 */
	public MountainBike(int seatHeight)
	{
		super(10, 10, 10);
		this.seatHeight = seatHeight;
	}
	
	/**
	 * Set the seat height of the mountain bike.
	 * 
	 * @param height in cm
	 */
	public void setSeatHeight(int height)
	{
		this.seatHeight = height;
	}
	
	/**
	 * Get the seat height of the mountain bike.
	 * 
	 * @return the seat height in cm
	 */
	public int getSeatHeight()
	{
		return this.seatHeight;
	}
	
	@Override
	public void printDescription()
	{
		System.out.println("This is a mountain bike");
	}
}
