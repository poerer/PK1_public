package lesson08Script;

/**
 * This class is identical to the MountainBike class.
 * The only difference is a different field: 
 * 			private int tireWidth;
 * 
 * @author fuchs
 *
 */
public class RacingBike extends Bicycle
{
	
	private int tireWidth;
	
	/**
	 * Constructor
	 * 
	 * @param tireWidth - the width of the tires in mm
	 */
	public RacingBike(int tireWidth)
	{
		super(10, 10, 10);
		this.tireWidth = tireWidth;
	}
	
	/**
	 * Set the tire width of the racing bike
	 * 
	 * @param width in mm
	 */
	public void setTireWidth(int tireWidth)
	{
		this.tireWidth = tireWidth;
	}
	
	/**
	 * Get the tire width of the racing bike
	 * 
	 * @return the tire width in mm
	 */
	public int getTireWidth()
	{
		return this.tireWidth;
	}
	
	@Override
	public void printDescription()
	{
		super.printDescription();
		System.out.println("Racing bike has additionally a tire width: " +
							this.getTireWidth());
		System.out.println();
	}
}
