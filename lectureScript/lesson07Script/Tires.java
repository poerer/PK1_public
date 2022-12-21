package lesson07Script;

/**
 * (*9*)
 * A really simple class helping you to understand unidirectional and bidirectional
 * relations.
 * 
 * To understand unidirectional relations we just need the default constructor
 * and the method
 * 		public void printTire()
 * +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
 * The field
 * 		Bicycle bike
 * and the methods
 * 		public void setBike(Bicycle bike)		
 * 		public Bicycle getBike()
 * will be used for bidirectional relations. Just ignore those till then.
 * 
 * @author fuchs
 *
 */
public class Tires
{
	//only necessary for bidirectional relationship
	private Bicycle bike;
	
	/**
	 * We did not write a constructor for this class. This means that a default
	 * constructor is used. The default constructor does not expect parameters.
	 * Since this class has no properties (except the reference to Bicycle, 
	 * which we will not use for unidirectional relations) the constructor does 
	 * not need to initialize any fields (properties).
	 */
	
	/**
	 * Simple method to just print something to the console.
	 */
	public void printTire()
	{
		System.out.println("I am a tire");
	}
	//switch back to Relations.java (*10*)
	
	/**
	 * Currently, the reference field (private Bicycle bike) is pointing
	 * nowhere. That is why the result when printing this reference would be
	 * null.
	 * This method sets the reference of this class to a different location.
	 * This new location hopefully reference an object in memory.
	 * 
	 * @param bike - reference to a Bicycle.java instance
	 */
	public void setBike(Bicycle bike)
	{
		this.bike = bike;
	}
	
	/**
	 * Returns the reference to a Bicycle.java object. In case the reference
	 * is not set to a valid memory space (where an object of the respective
	 * class is located) the method returns null.
	 * 
	 * @return reference to a Bicycle.java object.
	 */
	public Bicycle getBike()
	{
		return bike;
	}
	
}
