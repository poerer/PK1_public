package lesson09Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_interface.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Interfaces
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_05_013.htm
 */

/**
 * (*5*)
 * Introduction to interfaces:
 * The most important keywords for this session are 'interface' and 'implements'.
 * There are a number of situations in software engineering when it is important 
 * for disparate groups of programmers to agree to a "contract" that spells out 
 * how their software interacts. Each group should be able to write their code 
 * without any knowledge of how the other group's code is written. Generally 
 * speaking, interfaces are such contracts.
 * For example, imagine a futuristic society where computer-controlled robotic 
 * cars transport passengers through city streets without a human operator. 
 * Automobile manufacturers write software (Java, of course) that operates the 
 * automobile—stop, start, accelerate, turn left, and so forth. Another 
 * industrial group, electronic guidance instrument manufacturers, make computer 
 * systems that receive GPS (Global Positioning System) position data and wireless 
 * transmission of traffic conditions and use that information to drive the car.
 * The auto manufacturers must publish an industry-standard interface that spells 
 * out in detail what methods can be invoked to make the car move (any car, 
 * from any manufacturer). The guidance manufacturers can then write software 
 * that invokes the methods described in the interface to command the car. Neither 
 * industrial group needs to know how the other group's software is implemented. 
 * In fact, each group considers its software highly proprietary and reserves the 
 * right to modify it at any time, as long as it continues to adhere to the 
 * published interface.
 * 
 * In the Java programming language, an interface is a reference type, similar 
 * to a class, that can contain only constants, method signatures, and static 
 * methods. Method bodies exist only for static methods. Interfaces cannot be 
 * instantiated—they can only be implemented by classes (or extended by other 
 * interfaces, which will not be tackled in this basic course).
 * ->switch to Buyable.java (*6*)
 * 
 * @author fuchs
 *
 */
public class Interfaces
{
	public static void main(String[] args)
	{
		/*
		 * (*8*)
		 * Let's have a look at our interface Buyable and our class Apple.
		 * Interfaces cannot be instantiated, therefore, the following code
		 * does not work:
		 */
					//new Buyable(); //uncomment to see the error
		//Of course, we can work with our Apple
		Apple apple1 = new Apple(0.5);
		System.out.println("apple1 costs: " + apple1.getPrice());
		//Let's have a look at the type of this apple1
		System.out.println("apple1 is an Apple: " + (apple1 instanceof Apple));
		System.out.println("apple1 is Buyable: " + (apple1 instanceof Buyable));
		/*
		 * As we can see, by using Interfaces, we can assign another type to an 
		 * object. That is why interfaces are used to inherit types. Of course,
		 * these types can be used as a reference to the object:
		 */
		Buyable apple2 = new Apple(0.1);
		/*
		 * Since apple1 and apple2 are of type Buyable, we can use the method
		 * 			comparePrice(Buyable product1, Buyable product2)
		 * to print the higher price of the two:	
		 */
		comparePrice(apple1, apple2);
		/*
		 * This is not this surprising and not this interesting. But now we do
		 * something strange: 
		 */
		RacingBike bike = new RacingBike(30);
		comparePrice(apple1, bike);
		/*
		 * Why can we compare Apples and RacingBikes? The answer is simple. We 
		 * just modified RacingBike that it implements Buyable. As a result, 
		 * RacingBikes are also of type Buyable and we have access to the 
		 * method getPrice(). And this is the strength of interfaces. When you 
		 * define a new interface, you are defining a new reference data type. 
		 * You can use interface names anywhere you can use any other data type 
		 * name. If you define a reference variable whose type is an interface, 
		 * any object you assign to it must be an instance of a class that 
		 * implements the interface.
		 */
		/*
		 * Summary:
		 * An interface declaration can contain method signatures, static methods 
		 * and constant definitions. The only methods that have implementations 
		 * are static methods.
		 * A class that implements an interface must implement all the methods 
		 * declared in the interface.
		 * An interface name can be used anywhere a type can be used.
		 */
		//->switch to Generics:java (*9*)
	}
	
	/**
	 * This method prints the price of the more expensive product to the console.
	 * 
	 * @param product1 - something of type Buyable like Apple
	 * @param product2 - something of type Buyable like Apple
	 */
	public static void comparePrice(Buyable product1, Buyable product2)
	{
		System.out.print("The higher price is: ");
		if(product1.getPrice() > product2.getPrice())
		{
			System.out.println(product1.getPrice());
		}
		else
		{
			System.out.println(product2.getPrice());
		}
	}
}
