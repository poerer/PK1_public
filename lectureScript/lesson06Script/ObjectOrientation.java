package lesson06Script;
/*
 * Additional resources you might find useful:
 * https://www.w3schools.com/JAVA/java_oop.asp
 * https://de.wikibooks.org/wiki/Java_Standard#Objektorientierung
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_03_001.htm
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_05_001.htm
 */


/*
 * Hint:
 * Since we are using multiple classes we have to work with different files
 * at the same time. Therefore, it does not make sense to read one class
 * after the other. To guide you through this script, we introduced numbered
 * jump marks in parentheses e.g., (*5*). The numbering always starts with 1 
 * (*1*). Unfortunately, you have to search for the numbers yourself in the 
 * different classes. It could happen that you have to jump several times 
 * between the same classes over and over again. This is intended to best
 * communicate the semantics of the respective sessions.
 */
/**
 * (*1*)
 * Introduction to object oriented programming.
 * With the knowledge you gained about the basics of the Java programming language, 
 * you can learn to write your own classes. In this lesson, you will find 
 * information about defining your own classes, including declaring object 
 * variables, methods, and constructors. You will learn to use your classes to 
 * create objects, and how to use the objects you create.
 * 
 * Before going into the details of the implementation, we first have a look
 * at the overall concept.
 * Objects are key to understanding object-oriented technology. Look around right 
 * now and you'll find many examples of real-world objects: your dog, your desk, 
 * your television set, your bicycle.
 * Real-world objects share two characteristics: They all have state and behavior. 
 * Dogs have state (name, color, breed, hungry) and behavior (barking, fetching, 
 * wagging tail). Bicycles also have state (current gear, current pedal cadence, 
 * current speed) and behavior (changing gear, changing pedal cadence, applying brakes). 
 * Identifying the state and behavior for real-world objects is a great way to 
 * begin thinking in terms of object-oriented programming.
 * Take a minute right now to observe the real-world objects that are in your 
 * immediate area. For each object that you see, ask yourself two questions: 
 * "What possible states can this object be in?" and 
 * "What possible behavior can this object perform?". Make sure to write down your 
 * observations. As you do, you'll notice that real-world objects vary in complexity; 
 * your desktop lamp may have only two possible states (on and off) and two 
 * possible behaviors (turn on, turn off), but your desktop radio might have 
 * additional states (on, off, current volume, current station) and behavior 
 * (turn on, turn off, increase volume, decrease volume, seek, scan, and tune). 
 * You may also notice that some objects, in turn, will also contain other objects. 
 * These real-world observations all translate into the world of object-oriented 
 * programming.
 * 
 * Software objects are conceptually similar to real-world objects: they too 
 * consist of state and related behavior. An object stores its state in fields 
 * (variables in some programming languages) and exposes its behavior through 
 * methods (functions in some programming languages). Methods operate on an 
 * object's internal state and serve as the primary mechanism for object-to-object 
 * communication. Hiding internal state and requiring all interaction to be 
 * performed through an object's methods is known as data encapsulation — a 
 * fundamental principle of object-oriented programming
 * 
 * By attributing state (current speed, current pedal cadence, and current gear) 
 * and providing methods for changing that state, the object remains in control 
 * of how the outside world is allowed to use it. For example, if the bicycle 
 * only has 6 gears, a method to change gears could reject any value that is 
 * less than 1 or greater than 6.
 * Bundling code into individual software objects provides a number of benefits, 
 * including:
 * 1. Modularity: The source code for an object can be written and maintained 
 * independently of the source code for other objects. Once created, an object can 
 * be easily passed around inside the system.
 * 2. Information-hiding: By interacting only with an object's methods, the details 
 * of its internal implementation remain hidden from the outside world.
 * 3. Code re-use: If an object already exists (perhaps written by another software 
 * developer), you can use that object in your program. This allows specialists 
 * to implement/test/debug complex, task-specific objects, which you can then trust 
 * to run in your own code.
 * 4. Pluggability and debugging ease: If a particular object turns out to be 
 * problematic, you can simply remove it from your application and plug in a 
 * different object as its replacement. This is analogous to fixing mechanical 
 * problems in the real world. If a bolt breaks, you replace it, not the entire machine
 * 
 * 
 * @author fuchs
 *
 */
public class ObjectOrientation
{
	public static void main(String[] args)
	{
		/*
		 * In the real world, you'll often find many individual objects all of the 
		 * same kind. There may be thousands of other bicycles in existence, all 
		 * of the same make and model. Each bicycle was built from the same set 
		 * of blueprints and therefore contains the same components. In 
		 * object-oriented terms, we say that your bicycle is an instance of the 
		 * class of objects known as bicycles. A class is the blueprint from which 
		 * individual objects are created.
		 * 
		 * This is a class declaration:
		 *  
		 * 		public class MyClass 
		 * 		{
		 * 			// field, constructor, and 
		 * 			// method declarations
		 * 		}
		 * 
		 * The class body (the area between the braces) contains all the code that 
		 * provides for the life cycle of the objects created from the class: 
		 * 1. constructors for initializing new objects, 
		 * 2. declarations for the fields that provide the state of the class and its objects, 
		 * and 
		 * 3. methods to implement the behavior of the class and its objects.
		 * 
		 * In general, class declarations can include these components, in order:
		 * 1. Modifiers such as public, private, and a number of others that you will 
		 * encounter later in your studies.
		 * 
		 * 2. The class name, with the initial letter capitalized by convention.
		 * 
		 * 3. The name of the class's parent (superclass), if any, preceded by the keyword extends. 
		 * A class can only extend (subclass) one parent (will be covered later -> inheritance).
		 * 
		 * 4. A comma-separated list of interfaces implemented by the class, if any, 
		 * preceded by the keyword implements. A class can implement more than one interface.
		 * (will be covered later -> interfaces and abstract classes)
		 * 
		 * 5. The class body, surrounded by braces, {}.
		 * 
		 * -> switch to the class Bicycle.java to continue reading the script (*2*)...
		 */
		
		//(*3*)
		Bicycle myBike = new Bicycle(30, 0, 8);
		/*
		 * new Bicycle(30, 0, 8) creates space in memory for the object and initializes its fields.
		 * 
		 * The statement above has three parts:
		 * 1. Declaration: declarations associate a variable name with an object type.
		 * Previously, you learned that to declare a variable, you write:
		 * 		type name;
		 * This notifies the compiler that you will use name to refer to data whose type 
		 * is type. With a primitive variable, this declaration also reserves the proper 
		 * amount of memory for the variable.
		 * You can also declare a reference variable on its own line:
		 * 		Bicycle myBike;
		 * If you declare myBike like this, its value will be undetermined (null) until 
		 * an object is actually created and assigned to it. Simply declaring a 
		 * reference variable does not create an object. For that, you need to use the 
		 * new operator, as described in the next section. You must assign an object
		 * to myBike before you use it in your code. Otherwise, you will get a compiler 
		 * error.
		 * 
		 * 2. Instantiation: The new keyword is a Java operator that creates the object.
		 * The new operator instantiates a class by allocating memory for a new object 
		 * and returning a reference to that memory. The new operator also invokes the 
		 * object constructor.
		 * Note: The phrase "instantiating a class" means the same thing as "creating 
		 * an object." When you create an object, you are creating an "instance" of a 
		 * class, therefore "instantiating" a class.
		 * The new operator requires a single, postfix argument: a call to a constructor. 
		 * The name of the constructor provides the name of the class to instantiate.
		 * The new operator returns a reference to the object it created. This reference 
		 * is usually assigned to a variable of the appropriate type, like:
		 * 		Bicycle myBike = new Bicycle(30, 0, 8);
		
		 * 3. Initialization: The new operator is followed by a call to a constructor, 
		 * which initializes the new object.
		 * The class Bicycle contains a single constructor. You can recognize a constructor 
		 * because its declaration uses the same name as the class and it has no return type. 
		 * The constructor in the Bicycle class takes three integer arguments, as declared 
		 * by the code (int startCadence, int startSpeed, int startGear). 
		 * The following statement provides 30, 0 and 8 as values for those arguments:
		 * 		Bicycle myBike = new Bicycle(30, 0, 8);
		 * If a class has multiple constructors, they must have different signatures. 
		 * The Java compiler differentiates the constructors based on the number and the type 
		 * of the arguments.
		 *
		 * Although Bicycle only has one constructor, it could have others, including a 
		 * no-argument constructor:
		 * 	
		 *  	public Bicycle() 
		 *  	{
		 *  		gear = 1;
		 *  		cadence = 10;
		 *  		speed = 0;
		 *  	}
		 */
		  
		  //invokes the no-argument constructor to create a new Bicycle object called yourBike.
		  	 	//Bicycle yourBike = new Bicycle(); //uncomment to see the error because a no-argument constructor is not defined
		
		/*
		 *  Both constructors could have been declared in Bicycle because they have different 
		 *  argument lists. As with methods, the Java platform differentiates constructors on 
		 *  the basis of the number of arguments in the list and their types. You cannot write 
		 *  two constructors that have the same number and type of arguments for the same class, 
		 *  because the platform would not be able to tell them apart. Doing so causes a 
		 *  compile-time error.
		 *  
		 *  You don't have to provide any constructors for your class, but you must be 
		 *  careful when doing this. The compiler automatically provides a no-argument, 
		 *  default constructor for any class without constructors. 
		 */
		//-> switch to Bicycle.java to see the implemented constructor (*4*)
		
		//(*5*)
		/*
		 * In order to access properties, fields, or methods from different classes/objects
		 * we are making use of the dot syntax. This means that you have to use the name
		 * of the reference (in our case myBike) to the object followed by a dot . and then
		 * the name of the field/method.
		 */
		int cadence = myBike.getCadence();
		//					^
		//				dot syntax
		System.out.println("1. cadence of the bike: " + cadence);
		
		//cadence (as defined in Bicycle.java) is private. That is why we (as a 
		//different class ObjectOrientation.java) cannot access this field (property).
			//myBike.cadence; //uncomment, to see the error. The property is not visible.
		
		/*
		 * We can make use of getter and setter methods to manipulate the properties (fields) 
		 * of an object or to retrieve their value. These methods are usually mandatory since 
		 * fields are often private properties. Private properties are only accessible within 
		 * the same class. That is why we are introducing setter and getter methods: 
		 */
		//we change the cadence of this specific object (myBike) using the 'set method'
		myBike.setCadence(20);
		//However, this has no influence on the local variable in this class:
		System.out.println("2. cadence of the bike: " + cadence); //old value
		//That is why we are using the 'get method' in order to retrieve the new value
		cadence = myBike.getCadence();
		System.out.println("3. cadence of the bike: " + cadence); //new value
		
		/*
		 * Importance of the Java Doc:
		 * As you might have noticed when typing in:
		 * myBike.(dot)
		 * a tooltip opens up and shows you all accessible properties and methods 
		 * together with the respective Java Doc. As a recap, the Java Doc should
		 * contain a description of what the method does, together with a description
		 * of a possible return type and parameters. Imagine you have to work on a
		 * project with 991929 methods. You do not know by heart the purpose of 
		 * each method. That is why you are referring to the Java Doc.
		 */
		myBike.speedUp(50); 
		//When hovering over the method's name you can see a description.
		//This is not true for the following method:
		myBike.applyBrake(10);
		/*
		 * As a consequence, you have no idea what this method does (except for the name).
		 * Is there a return value we can use?
		 * What is the parameter doing?
		 * Is there a check that speed cannot be negative? 
		 * Etc.
		 * 
		 * Using this simple example, I hope you got the idea why Java Docs are 
		 * important.
		 */
		
		/*
		 * Usefulness of object orientation:
		 * Since we have a blue print of our bike, we can now work with many bikes
		 * having different properties but all of them have the same behavior.
		 */
		//Three bikes with different properties:
		Bicycle bike1 = new Bicycle(10,2,0);
		Bicycle bike2 = new Bicycle(50,7,0);
		Bicycle bike3 = new Bicycle(100,21,0);
		bike1.speedUp(100);
		bike2.speedUp(50);
		bike3.speedUp(1000);
		bike1.applyBrake(1000);
		bike2.applyBrake(40);
		bike3.applyBrake(500);
		System.out.println("Bike1 speed: " + bike1.getSpeed() + " and has " + bike1.getGear() + " gears");
		System.out.println("Bike2 speed: " + bike2.getSpeed() + " and has " + bike2.getGear() + " gears");
		System.out.println("Bike3 speed: " + bike3.getSpeed() + " and has " + bike3.getGear() + " gears");
		
		/*
		 * This was a really simple example and perhaps does not reflect the real world.
		 * E.g., gears cannot be changed this easily that is why you could think about
		 * removing the setGears-method. There is also no upper limit for the speed 
		 * (bike3 is running really fast).
		 * 
		 * Hopefully, you have now an idea what the difference between a class (blue print)
		 * and an object (instance of a class) is. When you start designing your own
		 * class: 
		 * 1. think about the properties of this class. What does an object need to 
		 * define its state e.g., a fraction needs a numerator and a denominator, a
		 * person might need a name, a gender, an age etc.
		 * 2. Declare all these properties (fields) as private
		 * 3. Think about one or more constructors. The constructor initializes your 
		 * object assigning values to its fields (properties). Perhaps for some
		 * objects certain values are important right from the start. E.g., the 
		 * denominator of the fraction should not be 0, the car has a color and a 
		 * certain number of doors, the person has a name etc.
		 * 4. Think about how others (different classes) should be able to access
		 * these properties. If they are allowed to access a property write
		 * the respective setter and getter methods (public). E.g., we can
		 * easily change the profession of a person but not the age.
		 * 5. Think about the capabilities of the objects. Write the respective
		 * methods. E.g., a car is able to accelerate, a lamp consumes electricity,
		 * a data structure might drop all its elements etc.   
		 * 
		 * Summary:
		 * A class declaration names the class and encloses the class body between braces. 
		 * The class name can be preceded by modifiers. The class body contains fields, 
		 * methods, and constructors for the class. A class uses fields to contain state 
		 * information and uses methods to implement behavior. Constructors that initialize 
		 * a new instance of a class use the name of the class and look like methods 
		 * without a return type.
		 * 
		 * You control access to classes and members in the same way: by using an 
		 * access modifier such as public in their declaration.
		 * You create an object from a class by using the new operator and a 
		 * constructor. The new operator returns a reference to the object that 
		 * was created. You can assign the reference to a variable or use it directly.
		 * 
		 * Instance variables and methods that are accessible to code outside of 
		 * the class that they are declared in can be referred to by using a 
		 * qualified name. The qualified name of an instance variable looks like 
		 * this:
		 * 		objectReference.variableName
		 * The qualified name of a method looks like this:
		 * 		objectReference.methodName(argumentList)
		 * or:
		 * 		objectReference.methodName()
		 * The garbage collector automatically cleans up unused objects. An object 
		 * is unused if the program holds no more references to it. You can 
		 * explicitly drop a reference by setting the variable holding the reference 
		 * to null.
		 */
		//->DONE
	}
}
