package lesson06Script;

/**
 * (*2*)
 * This class is an example of a bike.
 * We have to think about characteristics of the bike, as well
 * as certain properties and abilities.
 * 
 * You will notice that the Bicycle class does not contain a main method. 
 * That's because it's not a complete application; it's just the blueprint for 
 * bicycles that might be used in an application. The responsibility of creating 
 * and using new Bicycle objects belongs to some other class in your application.
 * In our example, it is the class ObjectOrientation.java.
 * 
 * Another difference to previous sessions is the method declaration.
 * You will notice that a keyword in the head of a method declaration is missing 
 * ('static'). This keyword is responsible for telling the compiler to interpret
 * the method/variable as a class or object variable/method. The difference
 * between the two will be explained in the next lecture.
 * 
 * @author fuchs
 *
 */
public class Bicycle
{
	/*
	 * The Bicycle class uses the following lines of code to define its fields (properties):
	 * 	
	 *  public int cadence;
	 * 	public int gear;
	 * 	public int speed;
	 * 
	 * Field declarations are composed of three components, in order:
	 * 1. Zero or more modifiers, such as public or private.
	 * 2. The field's type.
	 * 3. The field's name.
	 * The fields of Bicycle are named cadence, gear, and speed and are all of data type 
	 * integer (int). The public keyword identifies these fields as public members, 
	 * accessible by any object that can access the class.
	 * The first (left-most) modifier used lets you control what other classes have access 
	 * to a member field. For the moment, consider only public and private. Other access 
	 * modifiers will be discussed later in your studies.
	 * public modifier = the field is accessible from all classes.
	 * private modifier = the field is accessible only within its own class.
	 * In the spirit of encapsulation, it is common to make fields private. This means 
	 * that they can only be directly accessed from the Bicycle class. We still need 
	 * access to these values, however. This can be done indirectly by adding public 
	 * methods that obtain the field values for us (setter and getter methods).
	 */
	private int cadence;
	private int gear;
	private int speed;
	/*
	 * All variables must have a type. You can use primitive types such as int, float, 
	 * boolean, etc. Or you can use reference types, such as Strings, arrays, or objects.
	 * 
	 * All variables, whether they are fields, local variables, or parameters, follow 
	 * the same naming rules and conventions 
	 */
	
	/*
	 * A class contains constructors that are invoked to create objects from the class 
	 * blueprint. Constructor declarations look like method declarations—except that they 
	 * use the name of the class and have no return type. For example, Bicycle has 
	 * one constructor:
	 */
	/**
	 * This is the constructor. This method is called when a new object is created.
	 * To create a new Bicycle object called myBike, a constructor is called by 
	 * the new operator -> switch to ObjectOrientation.java to see the code (*3*)
	 * 
	 * (*4*)
	 * 
	 * @param startCadence
	 * @param startSpeed
	 * @param startGear
	 */
	public Bicycle(int startCadence, int startGear, int startSpeed) 
	{
		/*
		 * In the following lines, we are filling the fields (properties, 
		 * object variables) with values. These values are just parameters 
		 * passed to the constructor (local variables).
		 * You can see different colorings (Eclipse default settings):
		 * brown: local variable
		 * blue: field
		 * Whereas local variables are only visible in a certain scope
		 * (method scope, block scope) fields are visible in the entire
		 * class (private/public) or even accessible from different classes/objects
		 * (public).
		 */
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
	    /*
	     * As you can see, the variable cadence is visible throughout the entire 
	     * class. The rest of the method structure is already known.
	     * -> The method is public: is accessible from other classes
	     * -> The method returns an int: we can call this method to retrieve the cadence
	     * -> getCadence(): the name of the method and empty parentheses => no parameters needed
	     */
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
		/*
		 * Again, the field (cadence) is visible in the entire class. 
		 * Since the property is a simple variable, we can assign a new value
		 * to this variable.
		 */
	    cadence = newValue;
	    
	    // -> switch to ObjectOrientation.java to see how to use setter and getter (*5*)
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
}
