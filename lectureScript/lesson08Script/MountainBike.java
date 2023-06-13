package lesson08Script;

/**
 * (*2*)
 * A class declaration for a MountainBike class that is a subclass of Bicycle.
 * To indicate this relation (parent -> child) we use the keyword 'extends'.
 * Mountain bike being more specific extends the more abstract class Bicycle.
 * And, as you know, all classes extend Object.
 * Object (overall parent) -> Bicycle (parent) -> MountainBike (child)
 * 
 * MountainBike inherits all the public fields and methods of Bicycle and adds the 
 * field seatHeight and methods to set and get it. Except for the constructor, 
 * it is as if you had written a new MountainBike class entirely from scratch, 
 * with four fields and nine methods. However, you didn't have to do all the work. 
 * This would be especially valuable if the methods in the Bicycle class were 
 * complex and had taken substantial time to debug.
 * 
 * @author fuchs
 *
 */
public class MountainBike extends Bicycle
{
	/*
	 * As you can see from the class description
	 * 			public class MountainBike extends Bicycle
	 *										 ^ 										
	 *									 new keyword
	 *
	 * MountainBike is the subclass of Bicycle. Therefore, it has access to all
	 * public fields (properties) and methods (capabilities) from Bicycle. 
	 * For the MountainBike.java class we are just specifying one new field 
	 * (seatHeight). This property is specific for mountain bikes. Our Bicycle 
	 * class has no idea about this property and, therefore, cannot use it.
	 * Since the field is private, we also add the respective get and set methods
	 * to this class (encapsulation).
	 */
	private int seatHeight;
	
	/**
	 * This is the constructor of our mountain bike. As you can see, it expects
	 * one value for the seat height.
	 * 
	 * @param seatHeight - the seat height of the mountain bike in cm
	 */
	public MountainBike(int seatHeight)
	{
		/*
		 * Imagine you want to instantiate a new mountain bike. What we already
		 * know is that it has a seat height and all the properties of a common
		 * bike (gear, speed, cadence).
		 * Since we do not have access to these fields (they are private) how
		 * can we initialize these properties? These fields are basically 
		 * responsible for the status of a Bicycle object. Therefore, they are
		 * usually initialized in the constructor of the Bicycle class. This
		 * means that we have to call the constructor of the Bicycle from our
		 * MountainBike constructor. This is done with the keyword 'super'. 
		 */
		super(10, 10, 10);
		/*
		 * 'super' works like 'this'. Whereas 'this' is the self reference, 'super'
		 * is referencing the parent. Therefore, you can also call methods of the
		 * parent in the child:
		 */
		System.out.println("Speed of the bike using super: "+ super.getSpeed());
		/*
		 * In case the parent has a constructor, which does not need parameters
		 * there is no need to explicitly write: 	
		 * 			super();
		 * This is invoked automatically.
		 */
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
	//->switch to Inheritance.java (*3*)
	
	/*
	 * (*5*)
	 * An instance method in a subclass with the same signature (name, plus the 
	 * number and the type of its parameters) and return type as an instance 
	 * method in the superclass overrides the superclass's method. The ability 
	 * of a subclass to override a method allows a class to inherit from a 
	 * superclass whose behavior is "close enough" and then to modify behavior 
	 * as needed. The overriding method has the same name, number and type of 
	 * parameters, and return type as the method that it overrides. An overriding 
	 * method can also return a subtype of the type returned by the overwritten 
	 * method. This subtype is called a covariant return type.
	 * When overriding a method, you might want to use the @Override annotation 
	 * that instructs the compiler that you intend to override a method in the 
	 * superclass. If, for some reason, the compiler detects that the method does 
	 * not exist in one of the superclasses, then it will generate an error.
	 */
	@Override
	public void printDescription()
	{
		super.printDescription();
		System.out.println("Mountain bike has additionally a seat height of: " +
							this.getSeatHeight());
		System.out.println();
	}
	//->switch to Inheritance.java (*6*)
}
