package lesson08Script;

/**
 * It is the same class as in the lesson about object orientation.
 * The only difference is the method
 * 				public void printDescription()
 * which prints the properties of the bike to the console (speed, gear, cadence)
 * 
 * @author fuchs
 *
 */
public class Bicycle
{
	//properties:
	private int cadence;
	private int gear;
	private int speed;

	/**
	 * This is the constructor. This method is called when a new object is created.
	 * To create a new Bicycle object called myBike, a constructor is called by 
	 * the new operator.
	 * 
	 * @param startCadence
	 * @param startSpeed
	 * @param startGear
	 */
	public Bicycle(int startCadence, int startGear, int startSpeed) 
	{
	    gear = startGear;
	    cadence = startCadence;
	    speed = startSpeed;
	}
	    
	/**
	 * This is one of the getter methods.
	 * The purpose of this method is to return one of the object's properties.
	 * In this case, by calling the method we return the cadence.  
	 * @return the cadence of the object
	 */
	public int getCadence() 
	{
	    return cadence;
	}
	
	/**
	 * This is a setter method.
	 * The purpose of this method is to change the properties of the object.
	 * In this example, we can modify the cadence. Therefore, this method
	 * needs to be:
	 * 1. public -> accessible through different classes
	 * 2. expecting a parameter -> this is usually the new value for the respective
	 * variable (in our case cadence).
	 * 3. void -> this is not mandatory, however, since we want to modify the
	 * property, there is not need to return something. In sophisticated projects
	 * you can see setter methods, which return a boolean. This simply means that
	 * the method returns true in case the value was changed and false otherwise.
	 * 
	 * @param newValue - the new value for the cadence
	 */
	public void setCadence(int newValue) 
	{
	    cadence = newValue;
	}
	
	/**
	 * The the number of gears
	 * @return the number of gears
	 */
	public int getGear() 
	{
	    return gear;
	}
	/**
	 * Set the number of gears.
	 * @param newValue
	 */
	public void setGear(int newValue) 
	{
	    gear = newValue;
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
	
	/*
	 * no Java Doc! Therefore, someone using this method has no idea
	 * what is happening here. As an exercise you could write the 
	 * Java Doc for this method.
	 */
	public void applyBrake(int decrement) 
	{
		/*
		 * Since we have an entire method to assign values to properties
		 * we can control how to assign these values. E.g., negative speed
		 * is not allowed
		 */
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
	
	/**
	 * This method just prints the properties of the object
	 * to the console.
	 */
	public void printDescription()
	{
		System.out.println("Bicycle has the following properties: "
						+ "	speed: " + this.getSpeed() +
						" cadence: " + this.getCadence() +
						" gear: "	 + this.getGear());
	}
}
