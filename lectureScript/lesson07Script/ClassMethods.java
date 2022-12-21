package lesson07Script;
/*
 * Additional resources you might find useful:
 * https://de.wikibooks.org/wiki/Java_Standard:_Klassen
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_03_005.htm
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_05_001.htm
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_05_007.htm
 */

/**
 * (*1*)
 * Introduction to class variables and methods.
 * The most important keyword for this session is 'static'. Adding this keyword
 * to a variable/method declaration tells the compiler to interpret it as
 * a class variable/method. The most important characteristic of such class
 * variables/methods is that they are independent from the objects. This means
 * 1. These variables/methods also exist although no object has been instantiated.
 * 2. They are independent from the number of instances.
 * 3. They are initialized during startup of the project.
 * 
 * We modified the Bicycle.java file from the previous chapter to help you
 * understand this topic.
 * -> switch to Bicycle.java (*2*)
 * 
 * @author fuchs
 *
 */
public class ClassMethods
{
	public static void main(String[] args)
	{
		/*
		 * (*3*)
		 * Since class variables exist although no object has been instantiated
		 * we can make use of the getCount variable in the class Bicycle. However,
		 * we cannot use gear, id, cadence, or speed without instantiating an
		 * object.
		 * To access the class variable, we need a reference. Since we have
		 * no objects available we make use of the class name as reference.
		 * In our example the getCount variable is public. Class variables
		 * can also be set to private.
		 */
		System.out.println("(variable) Bike count: " + Bicycle.getCount);
		/*
		 * You can also refer to static fields with an object reference like
		 * 		myBike.getCount;
		 * but this is discouraged because it does not make it clear that they 
		 * are class variables.
		 * 
		 * Since there is no object available we cannot access the object
		 * variables. This would make no sense because they define the status
		 * of the object.
		 */
		//Uncomment the line to see the error:
				//System.out.println("Bike cadence: " + Bicycle.getCadence());
		
		//-> switch to Bicycle.java (*4*)
		/*
		 * (*5*)
		 * The Java programming language supports static methods as well as 
		 * static variables. Static methods, which have the static modifier in 
		 * their declarations, should be invoked with the class name, without 
		 * the need for creating an instance of the class, as in:
		 * 		ClassName.methodName(args)
		 * A common use for static methods is to access static fields. For 
		 * example, we could add a static method to the Bicycle class to access 
		 * the getCount static field:
		 */
		System.out.println("(method) Bike count: " + Bicycle.getCount());
		
		/*
		 * To better understand the difference between class variables (getCount)
		 * and object variables (id) have a look at the following example:
		 */
		Bicycle bike1 = new Bicycle(1,1,1);
		//we have to reference the object variable using the object's name (bike1)
		System.out.println("bike1 ID: " + bike1.getId());
		//we will access the class variable using the class name
		System.out.println("bike count: " + Bicycle.getCount());
				//the following statement also works but MUST NOT be used:
				//System.out.println("bike count: " + bike1.getCount()); 
		Bicycle bike2 = new Bicycle(1,1,1);
		//bike1 ID is still the same (1)
		System.out.println("bike1 ID: " + bike1.getId());
		//count is increasing because now, we have 2 bikes
		System.out.println("bike count: " + Bicycle.getCount());
		Bicycle bike3 = new Bicycle(1,1,1);
		//bike2 ID is 2
		System.out.println("bike2 ID: " + bike2.getId());
		//However, the count of bikes is 3
		System.out.println("bike count: " + Bicycle.getCount());
		/*
		 * Not all combinations of instance and class variables and methods are allowed:
		 * 1. Instance methods can access instance variables and instance methods directly.
		 * 2. Instance methods can access class variables and class methods directly.
		 * 3. Class methods can access class variables and class methods directly.
		 * 4. Class methods cannot access instance variables or instance methods directly
		 * they must use an object reference. Also, class methods cannot use the this 
		 * keyword as there is no instance for this to refer to.
		 * 
		 * Summary:
		 * You specify a class variable or a class method by using the static 
		 * keyword in the member's declaration. A member that is not declared 
		 * as static is implicitly an instance member. Class variables are shared 
		 * by all instances of a class and can be accessed through the class name 
		 * as well as an instance reference. Instances of a class get their own 
		 * copy of each instance variable, which must be accessed through an 
		 * instance reference.
		 */
		//-> switch to Relations.java (*6*)
	}
}
