package lesson09Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_abstract.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Klassen#abstract
 * https://openbook.rheinwerk-verlag.de/javainsel/07_006.html#u7.6
 */

/**
 * (*1*)
 * Introduction to abstract classes:
 * The most important keyword for this session is 'abstract'.
 * An abstract class is a class that is declared abstract—it may or may not 
 * include abstract methods. Abstract classes cannot be instantiated, but they 
 * can be subclassed.
 * An abstract method is a method that is declared without an implementation 
 * (without braces, and followed by a semicolon), like this:
 * 				abstract void moveTo(double deltaX, double deltaY);
 * If a class includes abstract methods, then the class itself must be declared 
 * abstract, as in:
 * 			public abstract class GraphicObject 
 * 			{
 * 				// declare fields
 * 				// declare nonabstract methods
 * 				abstract void draw();
 * 			}
 * When an abstract class is subclassed, the subclass usually provides implementations 
 * for all of the abstract methods in its parent class. However, if it does not, 
 * then the subclass must also be declared abstract.
 * 
 * As an example, we will use our classes from the previous session: 
 * Bicycle.java, MountainBike.java, RacingBike.java
 * We will only slightly modify the Bicycle class:
 * Bicycle will be changed to an abstract class with the abstract method printDescription
 * ->switch to Bicycle.java (*2*)
 * @author fuchs
 *
 */
public class AbstractClass
{
	public static void main(String[] args)
	{
		/*
		 * (*4*)
		 * As already introduced, we cannot instantiate an abstract class.
		 * This means that there cannot be a Bicycle object. However, there can
		 * be an object of type Bicycle. Since MountainBike is a child of Bicycle
		 * it is of type MountainBike and of type Bicycle (remember the instanceof
		 * operator from the previous session).
		 */
		//Instantiating an object Bicycle is not possible anymore
				//Bicycle bike = new Bicycle(10, 10, 10); //uncomment to see the error
		//However, we can instantiate a mountain bike:
		MountainBike bike1 = new MountainBike(10);
		//which is of type MountainBike and Bicycle and Object:
		System.out.println("bike1 is of type MountainBike: " + (bike1 instanceof MountainBike));
		System.out.println("bike1 is of type Bicycle: " + (bike1 instanceof Bicycle));
		//we still have access to all methods and fields as before
		System.out.println("bike1 speed: " + bike1.getSpeed());
		System.out.println("************");
		/*
		 * we can also work with the substitution principle since a reference on
		 * Bicycle is still valid:
		 */
		Bicycle bike2 = new RacingBike(50);
		//bike2 is of type RacingBike and Bicycle and Object but it is NOT a MountainBike
		System.out.println("bike2 is of type MountainBike: " + (bike2 instanceof MountainBike));
		System.out.println("bike2 is of type RacingBike: " + (bike2 instanceof RacingBike));
		System.out.println("bike2 is of type Bicycle: " + (bike2 instanceof Bicycle));
		System.out.println("************");
		printBike(bike1);
		printBike(bike2);
		/*
		 * Summary:
		 * An abstract class can only be subclassed; it cannot be instantiated. 
		 * An abstract class can contain abstract methods—methods that are 
		 * declared but not implemented. Subclasses then provide the 
		 * implementations for the abstract methods.
		 */
		//switch to Interfaces.java (*5*)
	}
	
	/**
	 * Same method as in the previous session.
	 * Bicycle is here a reference object that is why we can call this method
	 * passing a mountain bike or a racing bike.
	 * 
	 * @param bike - any kind of Bicycle
	 */
	public static void printBike(Bicycle bike)
	{
		bike.printDescription();
	}
}
