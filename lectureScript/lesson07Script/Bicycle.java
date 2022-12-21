package lesson07Script;

/**
 * 
 * +++++++++++++++++++++++++++++++++++++++++++++++++
 * ++Please, read the file ClassMethods.java first++
 * +++++++++++++++++++++++++++++++++++++++++++++++++
 * 
 * (*2*)
 * 
 * We will extend and adept the Bicycle class using class variables (properties)
 * and the 'this' reference.  
 * 
 * When a number of objects are created from the same class blueprint, they each 
 * have their own distinct copies of instance variables. In the case of the 
 * Bicycle class, the instance variables are cadence, gear, and speed. Each Bicycle 
 * object has its own values for these variables, stored in different memory 
 * locations. Sometimes, you want to have variables that are common to all objects. 
 * This is accomplished with the static modifier. Fields that have the static 
 * modifier in their declaration are called static fields or class variables. 
 * They are associated with the class, rather than with any object. Every instance 
 * of the class shares a class variable, which is in one fixed location in memory. 
 * Any object can change the value of a class variable, but class variables can 
 * also be manipulated without creating an instance of the class.
 * For example, suppose you want to create a number of Bicycle objects and assign 
 * each a serial number, beginning with 1 for the first object. This ID number is 
 * unique to each object and is therefore an instance variable. At the same time, 
 * you need a field to keep track of how many Bicycle objects have been created so 
 * that you know what ID to assign to the next one. Such a field is not related to 
 * any individual object, but to the class as a whole. For this you need a class 
 * variable, getCount, as follows:
 * 
 * @author fuchs
 *
 */
public class Bicycle
{
	//this is a class field/variable (property)
	public static int getCount;
	
	//properties of the bike
	private int id;
	private int cadence;
	private int gear;
	private int speed;
	
	//(*11 continue*) skip the next two lines if you are reading (*2*)
	public Tires front;
	public Tires back;
	
	/**
	 * This is the constructor. 
	 * 
	 * @param startCadence
	 * @param startSpeed
	 * @param startGear
	 */
	public Bicycle(int cadence, int gear, int speed) 
	{
		//whenever a new bike is instantiated the variable getCount is increased.
		Bicycle.getCount++; //class variable.
		this.id = getCount; //we assign the current count to the id
	  //-> switch to ClassMethods.java (*3*)
		
		/*
		 * (*11*)
		 * Our bike has now two new properties (leftTire, rightTire) 
		 * For simplicity reasons we set the visibility to public (*11 continue*)
		 * As you can see, we are setting the reference of front and back to
		 * new instances of Tires.java. By using these references the class
		 * Bicycle now knows the two objects (front, back).
		 */
		front = new Tires();
		back = new Tires();
		/*
		 * We are now using front and back in the class Relations.
		 * -> switch to Relations.java (*12*)
		 */
		
		/*
		 * (*13*)
		 * We are passing a self reference to the method in the class Tires.java.
		 * Therefore, the back tires know the bike they belong to. The front tires
		 * still have no idea to which bike they belong to.
		 */
		back.setBike(this);
		//-> switch to Relations.java (*14*)
		
		//(*7*)
		/*
		 * The most common reason for using the this keyword is because a field 
		 * is shadowed by a method or constructor parameter (local variable).
		 * Each argument to the constructor shadows one of the object's fields 
		 * — inside the constructor 'cadence' is a local copy of the constructor's 
		 * first argument. To refer to the Bicycle field 'cadence', the constructor 
		 * must use this.cadence.
		 */
		this.cadence = cadence;
		this.gear = gear;
	    this.speed = speed;
	}
	    
	/**
	 * Second constructor not using any parameters.
	 * In such a case we are using the 'this' keyword to call the parameterized 
	 * constructor with some default values.
	 */
	public Bicycle()
	{
		/*
		 * From within a constructor, you can also use the this keyword to call 
		 * another constructor in the same class. Doing so is called an explicit 
		 * constructor invocation.
		 * 
		 * This class contains two constructors. Each constructor initializes no 
		 * or all of the Bicylce's member variables (properties/fields). The 
		 * constructors provide a default value for any property whose initial 
		 * value is not provided by an argument. For example, the no-argument 
		 * constructor creates a Bicycle with 0 cadence, 21 gears, and 0 speed. 
		 * As before, the compiler determines which constructor to call, based 
		 * on the number and the type of arguments.
		 * 
		 * If present, the invocation of another constructor (using 'this') must 
		 * be the first line in the constructor.
		 */
		this(0, 21, 0); //calls the other constructor passing parameters
		//-> switch to Relations.java (*8*)

		
	}
	
	/**
	 * (*4*)
	 * Return the number of bikes instantiated in the application.
	 * 
	 * @return number of bikes (int)
	 */
	public static int getCount()
	{
		//the Bicycle. statement is optional in this case:
		return Bicycle.getCount;
		//-> switch to ClassMethods.java (*5*)
	}
	
	/**
	 * Get the unique id of the bike.
	 * 
	 * @return the unique id as int
	 */
	public int getId()
	{
		return this.id;
	}
	
	/**
	 * Return the cadence.
	 *   
	 * @return the cadence of the object
	 */
	public int getCadence() 
	{
	    return cadence;
	}
	
	/**
	 * Set the cadence
	 * 
	 * @param newValue - the new value for the cadence
	 */
	public void setCadence(int cadence) 
	{
	    this.cadence = cadence;
	}
	
	/**
	 * The the number of gears
	 * 
	 * @return the number of gears
	 */
	public int getGear() 
	{
	    return gear;
	}
	/**
	 * Set the number of gears.
	 * 
	 * @param newValue
	 */
	public void setGear(int gear) 
	{
	    this.gear = gear;
	}
	
	/**
	 * Get the current speed.
	 * 
	 * @return the current speed.
	 */
	public int getSpeed() 
	{
	    return speed;
	}
	
	/**
	 * Applying the brakes. As a consequence the current speed
	 * will be reduced. The speed can only be decreased to a 
	 * minimum of 0. Negative speed is not possible.
	 * 
	 * @param decrement - the amount how much to decrease the speed
	 */
	public void applyBrake(int decrement) 
	{
		//negative speed is not allowed		 
		if(speed - decrement < 0)
		{
			speed = 0;
		}
		else
		{
			//this is a faster way to write: speed = speed - decrement
			speed -= decrement;	
		}
	}
	  
	/**
	 * This method increases the speed property of the
	 * object by the parameter passed to the method.
	 * There is no upper bound.
	 * 
	 * @param increment - number, how much you want to accelerate.
	 */
	public void speedUp(int increment) 
	{
		//this is a faster way to write: speed = speed + increment
	    speed += increment;
	}
}
