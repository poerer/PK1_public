package lesson08Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_inheritance.asp
 * https://de.wikibooks.org/wiki/Java_Standard:_Vererbung
 * https://openbook.rheinwerk-verlag.de/javainsel/07_002.html
 * https://openbook.rheinwerk-verlag.de/javainsel/07_003.html
 * https://openbook.rheinwerk-verlag.de/javainsel/07_004.html
 */

/**
 * (*1*)
 * Introduction to Inheritance and the substitution principle.
 * The most important keywords for this session are 'extends' and 'super'.
 * In the Java language, classes can be derived from other classes, thereby 
 * inheriting fields and methods from those classes.
 * A class that is derived from another class is called a subclass (also a 
 * derived class, extended class, or child class). The class from which the 
 * subclass is derived is called a superclass (also a base class or a parent 
 * class).
 * Excepting Object, which has no superclass, every class has one and only one 
 * direct superclass (single inheritance). In the absence of any other explicit 
 * superclass, every class is implicitly a subclass of Object.
 * Classes can be derived from classes that are derived from classes that are 
 * derived from classes, and so on, and ultimately derived from the topmost class, 
 * Object. Such a class is said to be descended from all the classes in the 
 * inheritance chain stretching back to Object.
 * 
 * The idea of inheritance is simple but powerful: When you want to create a new 
 * class and there is already a class that includes some of the code that you 
 * want, you can derive your new class from the existing class. In doing this, 
 * you can reuse the fields and methods of the existing class without having to 
 * write (and debug!) them yourself.
 * A subclass inherits all the members (fields, methods, and nested classes) from 
 * its superclass. Constructors are not members, so they are not inherited by 
 * subclasses, but the constructor of the superclass can be invoked from the subclass.
 * The Object class, defined in the java.lang package, defines and implements behavior 
 * common to all classes—including the ones that you write. In the Java platform, 
 * many classes derive directly from Object, other classes derive from some of those 
 * classes, and so on, forming a hierarchy of classes. That is why, if you write your 
 * own class and instantiate an object you notice some methods you have not
 * written e.g., notify(). At the top of the hierarchy, Object is the most general 
 * of all classes. Classes near the bottom of the hierarchy provide more specialized 
 * behavior. 
 * 
 * Again, we make use of the Bicycle example from the former chapters to help you 
 * understand this important topic. Imagine that we want to write a new class
 * MountainBike. As you might expect, mountain bikes have the same properties
 * and capabilities as bikes but are a little more specific e.g., it is a special
 * kind of bike suitable for running up and down hills. Another example could be 
 * a racing bike, which is especially suited for driving really fast on roads.
 * The main properties and capabilities are identical to bikes. Mountain bikes 
 * can also speed up or break. We can get the number of gears etc. BUT we do not
 * want to write all of this again. We just say mountain bikes are basically bikes
 * with some additional features/properties/behavior.
 * ->switch to MountainBike.java (*2*)
 * 
 * @author fuchs
 *
 */
public class Inheritance
{
	public static void main(String[] args)
	{
		/*
		 * (*3*)
		 * We will now instantiate a MountainBike object. In MountainBike.java 
		 * we have just specified one field (property) and two methods. However,
		 * we have access to all public properties and methods from Bicycle. 
		 */
		//First, we will instantiate a mountain bike:
		MountainBike bike1 = new MountainBike(50);
		/*
		 * The speed of the bike is automatically printed to the console, because
		 * this statement is written in the constructor. Therefore, you can see
		 * that we have accessed a property declared in Bicycle using our more
		 * specific MountainBike. We do not have to write all the properties
		 * and methods again, we just use them -> REALLY COOL!
		 * We can also access all the public methods using our object bike1:
		 */
		bike1.speedUp(100);
		System.out.println("Speed of bike1 after speedUp: " + bike1.getSpeed());
		//It is not possible to access private fields (properties) or methods
					//bike1.speed = 40; //umcomment to see the error
		//and we can access our new field seat height
		System.out.println("Seat height of bike1: " + bike1.getSeatHeight());
		/*
		 * Of course, we can also work with a Bicycle object. However, this
		 * object has no properties or methods available for mountain bikes.
		 */
		Bicycle bike2 = new Bicycle(5, 5, 5);
		System.out.println("Speed of bike2: " + bike2.getSpeed());
					//bike2.getSeatHeight(); //uncomment to see the error
		
		/*
		 * Substitution principle:
		 * We have seen that an object is of the data type of the class from 
		 * which it was instantiated. For example, if we write:
		 * 				MountainBike myBike = new MountainBike();
		 * then myBike is of type MountainBike.
		 * MountainBike is descended from Bicycle and Object. Therefore, a 
		 * MountainBike is a Bicycle and is also an Object, and it can be used 
		 * wherever Bicycle or Object objects are called for.
		 * 
		 * The reverse is not necessarily true: a Bicycle may be a MountainBike, 
		 * but it isn't necessarily. Similarly, an Object may be a Bicycle or a 
		 * MountainBike, but it isn't necessarily.
		 * Casting shows the use of an object of one type in place of another type, 
		 * among the objects permitted by inheritance and implementations. For 
		 * example, if we write:
		 * 				Object obj = new MountainBike();
		 * then obj is both an Object and a MountainBike (until such time as obj 
		 * is assigned another object that is not a MountainBike). This is called 
		 * implicit casting.
		 * If, on the other hand, we write:
		 * 				MountainBike myBike = obj;
		 * we would get a compile-time error because obj is not known to the 
		 * compiler to be a MountainBike. However, we can tell the compiler that 
		 * we promise to assign a MountainBike to obj by explicit casting:
		 * 				MountainBike myBike = (MountainBike)obj;
		 * This cast inserts a runtime check that obj is assigned a MountainBike 
		 * so that the compiler can safely assume that obj is a MountainBike. If 
		 * obj is not a MountainBike at runtime, an exception will be thrown.
		 * 
		 * Important:
		 * You can make a logical test as to the type of a particular object 
		 * using the instanceof operator. This can save you from a runtime error 
		 * owing to an improper cast. For example:
		 * 				if (obj instanceof MountainBike) 
		 * 				{
		 * 					MountainBike myBike = (MountainBike)obj;
		 * 				}
		 * Here the instanceof operator verifies that obj refers to a MountainBike 
		 * so that we can make the cast with knowledge that there will be no 
		 * runtime exception thrown.
		 */
		System.out.println("bike1 instance of Bicycle: " + (bike1 instanceof Bicycle));
		System.out.println("bike1 instance of MountainBike: " + (bike1 instanceof MountainBike));
		System.out.println("bike2 instance of Bicycle: " + (bike2 instanceof Bicycle));
		System.out.println("bike2 instance of MountainBike: " + (bike2 instanceof MountainBike));
		/*
		 * As you can see, bike1 and bike2 are both instance of Bicycle. This means
		 * that if we have a method signature, which expects an object of type
		 * Bicycle, we can also pass an object of type MountainBike to this method.
		 * Have a look at the printBike method in this class
		 * ->switch to (*4*)
		 */
		
		/*
		 * (*6*)
		 * In the following example we will instantiate a MountainBike, a Bicycle,
		 * and a RacingBike. In a next step, we will pass the instances to the method:
		 * 					printBike(Bicycle bike)
		 * This is the idea of the substitution principle. We do not have to
		 * change the signature to:
		 * 					printBike(MountainBike bike) or
		 * 					printBike(RacingBike bike)
		 * MountainBike and RacingBike are children of Bicycle and, therefore, of
		 * type Bicycle:  
		 */
		Bicycle bike3 = new MountainBike(10);
		Bicycle bike4 = new RacingBike(20);
		Bicycle bike5 = new Bicycle(30, 30, 10);
		printBike(bike3);
		printBike(bike4);
		printBike(bike5);
		/*
		 * The Java virtual machine (JVM) calls the appropriate method for the 
		 * object that is referred to in each variable. It does not call the 
		 * method that is defined by the variable's type. This behavior is 
		 * referred to as virtual method invocation.
		 */
		
		/*
		 * Summary:
		 * Except for the Object class, a class has exactly one direct superclass. 
		 * A class inherits fields and methods from all its superclasses, whether 
		 * direct or indirect. A subclass can override methods that it inherits.
		 */
		//->DONE
	}
	
	/**
	 * (*4*)
	 * This method expects an object of type Bicycle. It simply calls the method
	 * printDescription of the respective object.
	 * 
	 * @param bike - any kind of Bicycle (could also be a MountainBike)
	 */
	public static void printBike(Bicycle bike)
	{
		//this method has been overwritten in the MountainBike class
		//->switch to MountainBike.java (*5*)
		bike.printDescription();
	}
}
