package lesson07Script;
/*
 * Additional resources you might find useful:
 * https://docs.oracle.com/javase/tutorial/collections/implementations/list.html
 */

/**
 * (*6*)
 * Introduction to unidirectional and bidirectional relations.
 * An important keyword for this session is 'this'.
 * Objects can have a relation with other objects (has an object, 
 * knows an object). Such a relation can be unidirectional:
 * Object A knows object B but object B does not know object A
 * or bidirectional:
 * Object A and object B know each other.
 * Such relations are realized using the reference to the object.
 * 
 * Within an instance method or a constructor, this is a reference 
 * to the current object — the object whose method or constructor is 
 * being called. You can refer to any member of the current object 
 * from within an instance method or a constructor by using this.
 * -> switch to Bicycle.java (*7*)
 * 
 * 
 * @author fuchs
 *
 */
public class Relations
{
	public static void main(String[] args)
	{
		/*
		 * (*8*)
		 * We are instantiating bikes using the two different constructors:
		 */
		Bicycle bike1 = new Bicycle(10, 10, 10); //<- this is already known
		System.out.println("Bike1 cadence: " + bike1.getCadence() + " gear: " + 
							bike1.getGear() + " speed: " + bike1.getSpeed());
		Bicycle bike2 = new Bicycle(); //<- this is new
		System.out.println("Bike2 cadence: " + bike2.getCadence() + " gear: " + 
							bike2.getGear() + " speed: " + bike2.getSpeed());
		/*
		 * As you can see, in the empty constructor we are calling the other 
		 * constructor with parameters initializing our bike2 with some initial
		 * values (0, 21, 0).
		 */
		
		/*
		 * Unidirectional relations:
		 * Imagine our bike has tires and these tires are also objects. That
		 * is why we are creating a new class called Tires.java. For simplicity
		 * reasons this class has no special properties or capabilities. It just
		 * consists of two constructors and a reference to a bike (will be used
		 * later for bidirectional relations). Have a quick look at the class
		 * Tires.java -> switch to Tires.java (*9*) 
		 */
		
		/*
		 * (*10*)
		 * (unidirectional relationship):
		 * The overall idea is to tell the bike that it knows (has) tires. 
		 * Therefore, we have to modify our Bicycle.java. The only changes
		 * will be done in the constructor -> switch to Bicycle.java (*11*)
		 */
		
		/*
		 * (*12*)
		 * Since we modified the Bicycle.java class, we can now use the new
		 * properties (front, back) to access Tires.java through the class
		 * Bicycle.
		 */
		Bicycle bike3 = new Bicycle(); 	//instantiate a new object
		Tires back = bike3.back;		//access the back tires through bike3
		back.printTire();				//use the new reference to print the tire
		//We can also access the printTire() method by adding another dot (.).
		bike3.front.printTire();
		//   ^     ^
		//1. dot: get the reference to Tires
		//2. dot: access the printTire() method using the front reference.
		
		/*
		 * (bidirectional relationship):
		 * If you like, you can checkout Tires.java again and have a look at the
		 * others methods not used, yet.
		 * The idea is that Bicycle.java knows Tires.java (as we have already seen)
		 * but also that Tires.java knows Bicycle.java. Imagine the tires know to
		 * which bike they belong to.
		 * Therefore, we have to pass the reference of the bike to the tires. Since
		 * we instantiate the tires in the Bicycle.java class we can make use
		 * of the self reference ('this') to do so.
		 * 
		 * But first, let's check out what happens, when we try to access the
		 * Bicycle.java reference without setting this bidirectional relationship.
		 */
		System.out.println("no bidirectional relationship established: " + 
							bike3.front.getBike());
		/*
		 * You can see on the console that the resulting reference is null.
		 * The tires do not know the bike they belong to. Now, we are modifying
		 * Bicycle.java to set the reference for the tires correctly.
		 * -> switch to Bicycle.java (*13*)
		 */
		/*
		 * (*14*)
		 * The reference for the back tires is now set correctly. We will use 
		 * the same code as before just changing the tires (from front to back).
		 */
		System.out.println("no bidirectional relationship established: " + 
							bike3.back.getBike());
		/*
		 * When running the code you can see a strange output e.g.,
		 * lesson07Script.Bicycle@67b64c45
		 * The output might be slightly different for each of you. What you
		 * see is the hashcode of the location in memory where the object
		 * is being stored. But still we get the object and could do something
		 * with it:
		 */
		int speed = bike1.back.getBike().getSpeed();
		System.out.println("Bike1 speed: " + speed);
		/*
		 * We are starting with the object bike1.
		 * Since bike1 knows the back tire we can get this tire.
		 * The tire also knows its bike to which it belongs to (bike1).
		 * When getting back bike3 we are getting one of its properties (speed).
		 * 
		 * Of course, this code does not make sense because we could just use
		 * 		bike1.getSpeed()
		 * to get the speed of bike1. But it nicely shows how to work with 
		 * these references.
		 */
		System.out.println();
		
		
		/* 
		 * Just for fun, we are implementing our own list data structure. Since
		 * we have no idea about complex index structures, we make use of relations
		 * between objects. As you can see, LinkedLists make use of bidirectional
		 * relations (element1 <=> element2). Our list data structure is simpler. 
		 * We just consider unidirectional relationships:
		 * 		guard -> element1 -> element2 -> element3 ... elementN <- guard
		 * E.g., element1 knows element2 but element2 does not know element1.
		 * 
		 * As a first step, we have to come up with a name: MyList.
		 * As a next step, we have to think about properties and functionalities
		 * of our MyList: 
		 * 1. add elements - add an element of a specific type (in our case Strings).
		 * 2. get elements - get an element at a certain position.
		 * 3. get the size - return the number of elements currently stored.
		 * As a result, we want programmers to use our list like this:
		 * 			MyList list = new MyList();
		 * 			list.add("hello world");
		 * 			int size = list.size();
		 * 			String content = MyList.get(0);
		 * ->switch to MyList.java (*15*)
		 */
		
		/*
		 * (*18*)
		 * Now, we can make use of our data structure like we did with the 
		 * ArrayList and LinkedList:
		 */
		//Initialize the data structure:
		MyList myDataStructure = new MyList();
		//Add elements to the data structure:
		myDataStructure.add("first");
		myDataStructure.add("second");
		myDataStructure.add("third");
		/*
		 * You can practice by implementing the remove functionality in MyList:
		 * 			myDataStructure.remove(1); 
		 */
		//Get the size and an element from the data structure:
		System.out.println("MyList size: " + myDataStructure.size());
		System.out.println("MyList get element: " + myDataStructure.get(1));
		
		
		/*
		 * Summary:
		 * 'this' is a self reference. There are three different use cases when
		 * to use 'this':
		 * 1. If there are local variables shadowing a field (having the same name)
		 * 2. To call a constructor with e.g., different parameters.
		 * 3. To pass a reference of the current object to a different class.
		 * 
		 * If a reference is not pointing to an object stored in memory it will
		 * return null as value.
		 */
		//->DONE
	}
}
