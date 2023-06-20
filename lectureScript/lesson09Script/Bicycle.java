package lesson09Script;

/**
 * (*2*)
 * It is the same class as in the lesson except that we changed it to being
 * an abstract class.
 * Additionally, the method:
 * 				public void printDescription()
 * will also be abstract:
 * 				public abstract void printDescription();
 * This means that we cannot instantiate a Bicycle. If you think about bikes
 * this makes perfectly sense because there is no such thing as just a Bicycle.
 * Bikes can be categorized in e.g., racing bike, mountain bike, city bike etc.
 * If a manufacturer of Bicycles creates a new bike it is not a Bicycle, but 
 * an object of one of these categories. Another example could be for example
 * in the area of geometry. Think about the class shape. A shape is really abstract
 * but a triangle, square, circle is not. Therefore, Shape would be an abstract
 * class and Triangle, Square, and Circle would extend this class. 
 * 
 * The rest remains the same.
 * ->jump to (*3*) in the same class at the very end.
 * 
 * @author fuchs
 *
 */
public abstract class Bicycle
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
	 * The purpose of this method is to return one of the object's properties.
	 *   
	 * @return the cadence of the object
	 */
	public int getCadence() 
	{
	    return cadence;
	}
	
	/**
	 * The purpose of this method is to change the properties of the object.
	 * 
	 * @param newValue - the new value for the cadence
	 */
	public void setCadence(int newValue) 
	{
	    cadence = newValue;
	}
	
	/**
	 * Get the number of gears
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
	 * (*3*)
	 * We changed this method to an abstract method. This means that there is
	 * no implementation of this method. Instead of creating a body using {} we
	 * just add a semicolon ;.
	 * The idea of abstract methods is simple. If a class contains an abstract
	 * method, the class has to be abstract, too. Therefore, it cannot happen
	 * that someone instantiates an object of Bicycle and calls this method
	 * without any content. In our current project, we have to subclasses of
	 * Bicycle namely MountainBike and RacingBike. Since these two classes are
	 * NOT abstract they can be instantiate and, therefore, they have to implement
	 * this abstract method. Given our substitution principle we can, therefore,
	 * write a method, which expects an object reference Bicycle and we 
	 * automatically know that each object has an implemented printDescription 
	 * method. However, each class MountainBike and RacingBike can implement
	 * the method as they like. 
	 */
	public abstract void printDescription();
	//->switch to AbstractClass.java (*4*)
}
