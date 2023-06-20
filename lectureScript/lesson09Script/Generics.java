package lesson09Script;
/*
 * Additional resources you might find useful:
 * https://openbook.rheinwerk-verlag.de/javainsel/11_001.html#u11
 */


/**
 * (*9*)
 * Introduction to Generics.
 * Generics allow you to abstract over types. The most common examples are 
 * container types, such as those in the Collections hierarchy (ArrayList, 
 * HashMap, ...).
 * Here is a small excerpt from the definition of the interface List in 
 * package java.util:
 * 				public interface List <E> 
 * 				{
 * 					void add(E x);
 * 					Iterator<E> iterator();
 * 				}
 * This code should all be familiar, except for the stuff in angle brackets. 
 * Those are the declarations of the formal type parameters of the interface 
 * List. Type parameters can be used throughout the generic declaration, 
 * pretty much where you would use ordinary types.
 * You might imagine that List<Integer> stands for a version of List where E 
 * has been uniformly replaced by Integer:
 * 				public interface IntegerList 
 * 				{
 * 					void add(Integer x);
 * 					Iterator<Integer> iterator();
 * 				}
 * This intuition can be helpful, but it's also misleading.
 * It is helpful, because the parameterized type List<Integer> does indeed have 
 * methods that look just like this expansion.
 * It is misleading, because the declaration of a generic is never actually 
 * expanded in this way. There aren't multiple copies of the code--not in source, 
 * not in binary, not on disk and not in memory. A generic type declaration is 
 * compiled once and for all, and turned into a single class file, just like an 
 * ordinary class or interface declaration.
 * Type parameters are analogous to the ordinary parameters used in methods or 
 * constructors. Much like a method has formal value parameters that describe the 
 * kinds of values it operates on, a generic declaration has formal type parameters. 
 * When a method is invoked, actual arguments are substituted for the formal 
 * parameters, and the method body is evaluated. When a generic declaration is 
 * invoked, the actual type arguments are substituted for the formal type parameters.
 * A note on naming conventions. We recommend that you use pithy (single character 
 * if possible) yet evocative names for formal type parameters. It's best to avoid 
 * lower case characters in those names, making it easy to distinguish formal type 
 * parameters from ordinary classes and interfaces. Many container types use E, 
 * for element, as in the examples above. 
 * 
 * Let's test your understanding of generics. Is the following code snippet legal?
 * 				List<String> ls = new ArrayList<String>(); // 1
 * 				List<Object> lo = ls; // 2 
 * Line 1 is certainly legal. The trickier part of the question is line 2. This 
 * boils down to the question: is a List of String a List of Object. Most people 
 * instinctively answer, "Sure!"
 * Well, take a look at the next few lines:
 * 				lo.add(new Object()); // 3
 * 				String s = ls.get(0); // 4: Attempts to assign an Object to a String!
 * Here we've aliased ls and lo. Accessing ls, a list of String, through the 
 * alias lo, we can insert arbitrary objects into it. As a result ls does not 
 * hold just Strings anymore, and when we try and get something out of it, we 
 * get a rude surprise. The Java compiler will prevent this from happening of 
 * course. Line 2 will cause a compile time error.
 * 
 * @author fuchs
 *
 */
public class Generics
{
	public static void main(String[] args)
	{
		/*
		 * Remember our MyList data structure from an earlier session.
		 * This data structure was limited to work with Strings. But now we can
		 * improve our MyList to work with any object by introducing generics.
		 */
		//->switch to MyList.java (*10*)
		/*
		 * (*13*)
		 * Now, let's have a look at our modified data structure MyList. As with
		 * ArrayLists or LinkedLists, we have to specify the type of object we
		 * want to store in our data structure.
		 */
		MyList<Integer> list1 = new MyList<Integer>();
		list1.add(10); list1.add(20); list1.add(30);
		
		MyList<Boolean> list2 = new MyList<Boolean>();
		list2.add(false); list2.add(false); list2.add(true);
		
		MyList<Bicycle> list3 = new MyList<Bicycle>();
		list3.add(new RacingBike(10)); list3.add(new MountainBike(30));
		
		MyList<Apple> list4 = new MyList<Apple>();
		/*
		 * As you can see, we can now add any kind of object to our MyList. If you
		 * want to restrict the type of object, which can be added to MyList, you
		 * simply have to restrict your type variable. To try this out, navigate
		 * to MyList.java and modify the class description as follows:
		 * 				public class MyList<E extends Number>
		 * 										^
		 * 								E has to be a child of Number
		 * If you do this change you will notice that it is not possible anymore
		 * to store Booleans or Bicycles in the MyList data structure (errors in
		 * the respective lines). Integers are a subtype of Number and, therefore,
		 * valid.
		 * 
		 * Imagine, we want to write a method in this class to check, whether
		 * our MyList is empty. The problem is: how do we specify the signature?
		 * 		public static boolean isEmpty(MyList list)
		 * 								     		^
		 * 					type is missing and therefore not correct
		 * 
		 * But what is the type? If we have a look at our lists, they are of
		 * different type. That is why, we have to introduce a variable again.
		 * 		public static boolean isEmpty(MyList<E> list)
		 * 									  		 ^
		 * 							    		type variable
		 * The problem with this solution is that we did not specify this type
		 * variable in our class description because it has nothing to do with
		 * the class. It is just used in this specific method. Therefore, we
		 * have to introduce this type variable in the method signature:
		 * 		public static <E> boolean isEmpty(MyList<E> list)
		 * 					   ^ 						 ^
		 * 				   specified				    used
		 * 
		 * 
		 * An alternative approach would be to use wildcards <?>. Wildcards
		 * are basically a variable for 'unknown type'. The cool thing about
		 * wildcards is that they need not be specified in the method
		 * signature. 
		 * 		public static boolean isEmpty(MyList<?> list)
		 * 											 ^
		 * 										  wildcard
		 * 
		 * Generic methods allow type parameters to be used to express dependencies
		 * among the types of one or more arguments to a method and/or its return 
		 * type. If there isn't such a dependency, a generic method should not be 
		 * used but wildcards.
		 * 
		 * We have implemented both versions, which both work perfectly fine.
		 * ->jump to (*14*) in the same class
		 */
		/*
		 * (*15*)
		 * We will now use both methods to check, whether our lists are empty.
		 */
		System.out.println("list1 is empty: " + isEmptyGeneric(list1));
		System.out.println("list2 is empty: " + isEmptyGeneric(list2));
		System.out.println("list3 is empty: " + isEmptyWildcard(list3));
		System.out.println("list4 is empty: " + isEmptyWildcard(list4));
		/*
		 * As you can see, both methods work perfectly fine. Like with the type
		 * variable defined in the class MyList, we can also restrict the type
		 * variable in the signature of a method or the wildcard directly. Just
		 * jump to the respective method signature and change the code as follows:
		 * public static boolean isEmptyWildcard(MyList<? extends Bicycle> list)
		 * 													^
		 * 							Wildcard restricted to Bicycle and its subtypes
		 * public static <E extends Number> boolean isEmptyGeneric(MyList<E> list)
		 * 						^
		 * 			type variable restricted to Number and its subtypes
		 * Again, both changes will result in compiler errors when calling the method
		 * with the wrong types like Boolean or Apple.									
		 */
		/*
		 * Summary:
		 * Generics are a really advanced topic and we just scratched the surface.
		 * However, we hope that you understood why generics are important and how
		 * they help to make code more generic and flexible.
		 */
		//->DONE
	}
	
	/**
	 * (*14*)
	 * This is a generic method because we have specified a type parameter in
	 * the method signature <E>. 
	 * 
	 * @param list - our data structure with any kind of objects
	 * @return true, if the list is empty, false, otherwise.
	 */
	public static <E> boolean isEmptyGeneric(MyList<E> list)
	{
		if(list.size() == 0) 
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	/**
	 * This method uses a wildcard to be more generic. As you can see,
	 * we do not have to specify a type variable. The drawback of this approach
	 * is that we cannot return a wildcard type, because the type is unknown.
	 * You can simply try to replace the return type boolean with ?. It will
	 * not work.
	 * 
	 * @param list - our data structure with any kind of objects
	 * @return true, if the list is empty, false, otherwise.
	 */
	public static boolean isEmptyWildcard(MyList<?> list)
	{
		if(list.size() == 0) 
		{
			return true;
		}
		else
		{
			return false;
		}		
	}
	//->jump to (*15*) in the same class
}
