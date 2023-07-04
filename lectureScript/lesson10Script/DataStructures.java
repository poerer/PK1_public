package lesson10Script;
/*
 * Additional resources you might find useful:
 * https://de.wikibooks.org/wiki/Java_Standard:_Das_Paket_java.util
 * http://dev.usw.at/manual/java/javainsel/javainsel_11_000.htm
 * 
 * In order to use ArrayLists and LinkedLists we have to import the respective
 * classes. 
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ArrayList.html
 * https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/LinkedList.html
 */

/*
 * (*1*)
 * Luckily there are a lot of competent Java developers who already contributed
 * a lot of classes to the Java library. In order to use those classes we just
 * have to import the respective classes to our project. Therefore, we do not
 * have to write a Stack.java or Queue.java on our own but use already 
 * existing classes.
 */
import java.util.Stack;			//implemented stack data structure
import java.util.ArrayDeque;	//implemented queue data structure
import java.util.Queue;			//capabilities of a queue data structure
import java.util.ArrayList;		//implemented ArrayList data structure
import java.util.Arrays;		//To quickly fill the list with elements
import java.util.Iterator;		//In order to traverse lists
import java.util.LinkedList;

/**
 * (*1*)
 * Introduction to data structures.
 * Data structures will be covered in more detail later in your studies. In this
 * session, we will have a brief look at already implemented data structures like
 * lists, stacks and queues and later try to write our own data structure  a 
 * - binary tree - making use of relations between objects. 
 * 
 * @author fuchs
 *
 */
public class DataStructures
{
	public static void main(String[] args)
	{
		/*
		 * Using the knowledge of uni- and bidirectional relationships, we can
		 * implement sophisticated data structures like MyList in the last lesson.
		 * In the Java library, there are already two different implementation of 
		 * lists. The LinkedList makes use of relationships to store elements, 
		 * whereas the ArrayList uses an index structure to access elements. This 
		 * can be problematic when elements are removed or added to the data 
		 * structure because the index structure has to adept.
		 * 
		 * LinkedList:
		 * sketch:
		 * 		guard -> element1 <=> element2 <=> element3 ... elementN <- guard
		 * where:
		 * <=> is a bidirectional relation
		 * -> is a unidirectional relation
		 * 
		 * If you want to get element3 you have to access the first element (using
		 * the guard). This first element knows element2. Element2 knows element3.
		 * Here you can easily see that this kind of implementation is really 
		 * inefficient when you want to get elements in a really long list. However,
		 * removing or adding elements is really simple. You just have to reference
		 * a different object. Assume that you want to delete element2. What you have
		 * to do is to tell element1 that it knows element3 instead of element2.
		 * As you have already learned that if an object is not referenced anymore 
		 * it is deleted (element2).
		 * 
		 * + Easy to remove and add elements
		 * - Difficult to access individual elements
		 * 
		 * ArrayList:
		 * sketch:
		 * 		element1	element2	element3	elementN
		 * 		   [0]		   [1]		   [2]		  [n-1]
		 * where:
		 * [n] is an index for position n in the list.
		 * 
		 * A sophisticated index structure is built in ArrayLists. Therefore, elements
		 * can be easily accessed (like in arrays). However, since lists are 
		 * more flexible, adding or removing elements comes with higher costs. Imagine
		 * what happens if someone wants to delete element2. All elements have
		 * to be shifted in the index structure (element3 is at position 1 now).
		 * If many elements are added or removed from the data structure an 
		 * ArrayList is not the appropriate choice.
		 * 
		 * + Really fast when accessing elements
		 * - Less efficient when removing or adding elements.
		 * 
		 * From the perspective of the programmer, who uses the different lists,
		 * the functionality is more or less the same. As you can see in the
		 * following example, we are initializing two different lists but we
		 * use the same methods to retrieve or add elements:
		 */ 
		//Initialize the two different lists:
		LinkedList<String> listRelation = new LinkedList<String>();
		ArrayList<String> listIndex = new ArrayList<String>();
		/*
		 * Something, which is new are the use of angle brackets <String>.
		 * This means your lists expect objects of type String. We will have a more
		 * detailed look at these angle brackets when we introduce Generics. Just
		 * copy them as they are and fill in the correct type you want to store.
		 * Like with arrays you can only store objects of the same data type
		 * in lists. You cannot add Tires and Bicycles to the same list. Primitive 
		 * data types are also not allowed. Therefore, if you want to add booleans, 
		 * chars, doubles etc. to the list, you have to use their respective object 
		 * counterpart e.g., int -> Integer, double -> Double etc.
		 */
		//Now, lets add elements of type String to the lists:
		listRelation.add("first");		listIndex.add("first");
		listRelation.add("second");		listIndex.add("second");
		listRelation.add("third");		listIndex.add("third");
		//Let's remove one element of the lists
		listRelation.remove(1);		listIndex.remove(1);
		//Let's get one element from the lists
		System.out.println("LinkedList: " + listRelation.get(1) + 
						   " ArrayList: " + listIndex.get(1));		
		/*
		 * As you can see, the code is exactly the same. The difference are the
		 * inner workings of the two list implementations (relations vs. index). 
		 */
		
		/*
		 * Iterator and lists; uncomment to see the output
		 */
				//explainIterator();
		/*
		 * stacks; uncomment to see the output
		 */
				//explainStacks();
		/*
		 * queues; uncomment to see the output
		 */
				//explainQueues();
		/*
		 * comparison between stack and queues; uncomment to see the output
		 */
				//comparisonStackQueue();
		/*
		 * Binary tree; uncomment to see the output
		 */
				explainBinaryTree();
	}
	
	/**
	 * This methods explains, why you should use an iterator to traverse lists.
	 */
	public static void explainIterator()
	{
		System.out.println("+++Iterator+++");
		/*
		 * We have already learned that lists are a more flexible data structure
		 * compared to arrays. We can add or remove elements and do not need to
		 * specify the size of the list beforehand. 
		 * However, this flexibility could also cause problems. Imagine you are
		 * traversing a list using a for-loop. During the traversal elements
		 * are removed. As a consequence, the size of the list changes influencing
		 * our termination condition:
		 * 		i < list.size();
		 * To see this problem you have to uncomment line 82 (*PROBLEM*)
		 */
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.addAll(Arrays.asList(1,2,3,4,5));
		for(int i = 0; i < list.size(); i++)
		{
				//list.remove(i); //(*PROBLEM*)
			System.out.println("elements in list: " + list.get(i));
		}
		/*
		 * If you do not modify the list, you can easily use the loop and 
		 * an index to traverse the list. However, if you modify the list
		 * it could happen, that you are missing data points, or you even
		 * get an exception (IndexOutOfBoundsException).
		 * To solve this issue and always be on the safe side you have to
		 * use an iterator. You can think of an iterator being some kind
		 * of data stream accessing the data structure. This stream connects
		 * to the list and is able to retrieve one element after the other.
		 * To avoid the problem of an IndexOutOfBoundsException the Iterator
		 * is able check, whether there are more elements available.
		 * In order to work with an iterator you have to do the following 
		 * steps:
		 * 1. Initialize the iterator:
		 * This is done by retrieving the iterator from the data structure
		 * and referencing it correctly.
		 * 			Iterator<Integer> iter = list.iterator();
		 * 2. Check, whether there are more elements in the data structure
		 * 			iter.hasNext();
		 * 3. Accessing the next element in the data structure
		 * 			iter.next();
		 */
		Iterator<Integer> iter = list.iterator();
		while(iter.hasNext())
		{
			int i = iter.next();
					iter.remove();	//we remove the element from the list
			System.out.println("Iterator: " + i);
		}
		//Check the size of the list:
		System.out.println("Iterator size: " + list.size());
		/*
		 * Since the iterator acts like a stream you cannot go back and visit
		 * an element again. To do so, you have to initialize a new iterator.
		 * As an example, you can have a look at the file JosephusProblem.java
		 */
		//uncomment to see the Josephus problem:
				//new JosephusProblem();
	}
	/**
	 * This method explains stacks and shows how and when to use this kind of
	 * data structure. 
	 */
	public static void explainStacks()
	{
		System.out.println("+++++STACKS+++++");
		/*
		 * Stacks are based on the 'last in first out' principle.
		 * This means that the last element put on a stack is retrieved first when
		 * popping elements from the stack. Just think of a stack as a pile of books.
		 * When you add a book to this pile it will be put at the top. If you want
		 * to get a book from this pile you take the one from the top. You cannot
		 * access the others (only if you remove all the books above the one you are
		 * looking for).
		 * 
		 * Imagine three elements have been added to the stack data structure. The
		 * result would look like this:
		 * 		|3|	this is the last element put on the stack
		 * 		|2|	this is the second element, which was added to the stack
		 * 		|1|	this element was put first on the stack
		 * When we want to get an element from this stack, we would get the element
		 * 3 first, then 2 and finally 1.
		 * 
		 * In our example, we are adding Strings to the Stack. In theory, you can put
		 * whatever object you like to the stack. The objects just have to be of 
		 * the same type e.g., all elements being Strings, or Bicycles. You are not
		 * allowed to put objects of different type on the Stack e.g., a Double and 
		 * a String.
		 * To indicate what type is put on the stack you have to use angle brackets:
		 * 			Stack<Bicycle> bikes = new Stack<Bicycle>();
		 * This means your stack expects objects of type Bicycle. We will have a more
		 * detailed look at these angle brackets when we introduce Generics. Just
		 * copy them as they are.
		 * 
		 * In our example, we are building a pile of Strings:
		 */
		Stack<String> pileOfBooks = new Stack<String>();
		/*
		 * After initializing our stack you can see that the stack has a lot of
		 * properties and capabilities. E.g., a programmer wrote a method to add
		 * elements to this stack: 
		 */
		pileOfBooks.push("Game of Thrones"); //1. element
		pileOfBooks.push("Harry Potter");	//2. element
		pileOfBooks.push("1984");			//3. element
		/*
		 * Our stack now looks like this:
		 * 		|     1984		|	<- top
		 * 		|  Harry Potter	|
		 * 		|Game of Thrones|	<- bottom
		 * There are more things we can do with the stack like:
		 */
		//Check the number of elements:
		System.out.println("1. #elements: " + pileOfBooks.size());
		//Check, whether the stack is empty:
		System.out.println("is empty: " + pileOfBooks.isEmpty());
		//Check the element at the top (without removing it)
		System.out.println("top element: " + pileOfBooks.peek());
		//If we want to get an element from the stack we start at the top:
		System.out.println("book at the top: " + pileOfBooks.pop());
		System.out.println("book at the top: " + pileOfBooks.pop());
		//Now, the stack is shrinking because we removed the element at the top:
		System.out.println("2. #elements: " + pileOfBooks.size());
		/*
		 * There are many more methods you can try out yourself. Just play
		 * around with this data structure.
		 */
	}
	/**
	 * This method explains queues and shows how and when to use this kind of
	 * data structure. 
	 */
	public static void explainQueues()
	{
		System.out.println("+++++QUEUES+++++");
		/*
		 * Queues are based on the 'first in first out' principle.
		 * In contrast to stacks, there is not a single implementation of this
		 * data structure but at least two (ArrayDeque, LinkedList). Queue itself
		 * is not a class but an interface. Interfaces will be explained in a 
		 * later session.
		 * In this example, we are making use of the ArrayDeque.java class (again
		 * written by a different programmer), which has to be imported first (see
		 * the very top of this file (above the class declaration)).
		 * 		import java.util.ArrayDeque;
		 * 		import java.util.Queue;
		 * 
		 * Since queues work in a fifo way, the first element added to this data
		 * structure is retrieved first.
		 * Imagine three elements have been added to the queue data structure. The
		 * result would look like this:
		 * 		|3|	this is the last element offered to the queue
		 * 		|2|	this is the second element, which was offered to the queue
		 * 		|1|	this element was offered first on the queue
		 * When we want to get an element from this queue, we would get the element
		 * 1 first, then 2 and finally 3.
		 * 
		 * In our example, we are adding Strings to the queue. In theory, you can add
		 * whatever object you like to the queue. The objects just have to be of 
		 * the same type e.g., all elements being Strings, or Bicycles. You are not
		 * allowed to offer objects of different type to the queue e.g., a Double and 
		 * a String.
		 * To indicate what type is offered to the queue you have to use angle brackets:
		 * 			Queue<Bicycle> bikes = new ArrayDeque<Bicycle>();
		 * This means your queue expects objects of type Bicycle. We will have a more
		 * detailed look at these angle brackets when we introduce Generics. Just
		 * copy them as they are.
		 * You can also see that on the left of the statement 'Queue' is written, whereas
		 * on the right 'ArrayDeque' is written. This simply means that the reference to
		 * the object in memory is of type Queue, whereas the element itself is of type
		 * ArrayDeque. Do not think to much about this line of code. It will be explained
		 * later when introducing inheritance.
		 * 
		 * In our example, we are building a queue of Strings:
		 */
		Queue<String> queue = new ArrayDeque<String>();
		/*
		 * After initializing our ArrayDeque you can see that the queue has a 
		 * lot of properties and capabilities. E.g., a programmer wrote a method 
		 * to add elements to this queue: 
		 */
		queue.offer("Game of Thrones"); //1. element
		queue.offer("Harry Potter");	//2. element
		queue.offer("1984");			//3. element
		/*
		 * Our queue now looks like this:
		 * 		|     1984		|	<- back
		 * 		|  Harry Potter	|
		 * 		|Game of Thrones|	<- front
		 * There are more things we can do with the queue like:
		 */
		//Check the number of elements:
		System.out.println("1. #elements: " + queue.size());
		//Check, whether the queue is empty:
		System.out.println("is empty: " + queue.isEmpty());
		//Check the element at the front (without removing it)
		System.out.println("front element: " + queue.peek());
		//If we want to get an element from the queue we start at the front:
		System.out.println("book at the front: " + queue.poll());
		System.out.println("book at the front: " + queue.poll());
		//Now, the stack is shrinking because we removed the element at the top:
		System.out.println("2. #elements: " + queue.size());
		/*
		 * There are many more methods you can try out yourself. Just play
		 * around with this data structure.
		 */
	}
	/**
	 * This method compares stacks and queues and shows different outcomes
	 * when feeding and extracting data.
	 */
	public static void comparisonStackQueue()
	{
		System.out.println("+++++Comparison+++++");
		/*
		 * To compare both data structures, we simply fill them with the
		 * same elements and try to get the elements again. To better indicate
		 * the sequence of elements we store ordered integer values in our
		 * data structures. Please, note that Integer is written in capital
		 * letters. We cannot store primitive data types e.g., int, double,...
		 * in those data structures. Luckily there is a class for each of 
		 * the primitive data types. E.g., double -> Double; int -> Integer 
		 */
		Stack<Integer> stack = new Stack<Integer>();
		Queue<Integer> queue = new ArrayDeque<Integer>();
		//We will both data structures with the same elements:
		for(int i = 1; i < 10; i++)
		{
			//add elements to the data structures: 1, 2, 3, 4, 5, 6, 7, 8, 9
			stack.push(i);
			queue.offer(i);
		}
		//Elements are printed to the console in the retrieved order:
		while(!stack.isEmpty()) //while the stack is not empty pop elements
		{
			System.out.println("Stack: " + stack.pop() + " \t Queue: " + queue.poll());
		}
	}
	
	/**
	 * 
	 * BinaryTree.java is the data structure you are using, which has to provide
	 * functionalities like initializing a new binary tree, or retrieving
	 * the left and right child.
	 * 
	 */
	public static void explainBinaryTree()
	{
		/*
		 * Our binary tree is defined as follows:
		 * 1. A binary tree consists of a root and up to two children (left, right).
		 * 2. A binary tree without children is called in leaf.
		 * 3. The children are binary trees themselves.
		 * 4. The root contains data (Generics)
		 * 5. Programmers should be able to use our data structure to:
		 * 	5.1 retrieve data stored in the root
		 *  5.2 traverse the binary tree using different approaches (pre-, post-, inorder).
		 *  
		 *  Representation of a binary tree:
		 *  		root
		 *  	   /	\
		 *   leftRoot   rightRoot
		 *  
		 *  leftRoot and rightRoot are also binary trees.
		 *  
		 * To implement this functionality, we start by constructing a binary tree
		 * showing the different characteristics first:
		 */
		//An empty binary tree. Does not contain data and has no children.
		BinaryTree<String> empty = new BinaryTree<String>();
		//A binary tree, which contains data but has no children => leaf
		BinaryTree<String> treeA = new BinaryTree<String>("Tree a");
		//A binary tree, which contains data and has two children (binary trees)
		BinaryTree<String> treeB = new BinaryTree<String>(treeA, "Tree b", empty);
		/*
		 * The respective binary tree would look like this:
		 * 			Tree b
		 * 		   /
		 * 		Tree a
		 * 
		 * Let's see, how the constructors are defined
		 * -> switch to BinaryTree.java (*2*)
		 */
		/*
		 * (*3*)
		 * As you have seen while checking BinaryTree.java, we have some 
		 * functionality we can use on our binary trees. Let's try them out:
		 */
		//Check, whether the tree is empty:
		System.out.println("Tree a is empty: " + treeA.isEmpty());
		System.out.println("Tree empty is empty: " + empty.isEmpty());
		//Get the content of a tree
		System.out.println("Content of treeB: " + treeB.getContent());
		System.out.println("Content of empty tree: " + empty.getContent());
		//Get the left child:
		System.out.println("Left child of treeB: " + treeB.getLeft().getContent());
		System.out.println("Left child of treeA: " + treeA.getLeft());
		
		/*
		 * As you can see, when retrieving the left child, we get an object of 
		 * type BinaryTree: 
		 * 			treeA.getLeft() -> BinaryTree
		 * on the BinaryTree we are then asking for the content:
		 * 			treeA.getLeft().getContent() -> String
		 * 
		 * Since the left child and the right child are of type BinaryTree, we
		 * can write a method traversing the tree recursively. Therefore, we
		 * are initializing a bigger tree, which looks like this:
		 * 				Tree D
		 * 			   /	  \
		 * 			Tree B	 Tree C
		 * 			/
		 * 		  Tree A
		 */
		//another leaf
		BinaryTree<String> treeC = new BinaryTree<String>(empty, "Tree c", empty);
		//the root of the entire binary tree
		BinaryTree<String> treeD = new BinaryTree<String>(treeB, "Tree d", treeC);
		/*
		 * We are now traversing this tree using different strategies.
		 * As a starting point, we are using the root of the entire
		 * tree, which is in our case treeD.
		 */
		treeTraversal(treeD);
	}
	
	/**
	 * This recursive method is traversing a binary tree. The standard
	 * procedure implemented is pre order. This means that you output 
	 * the current root and then descend to the left and then to the right.
	 * However, you can easily change the traversal behavior. Just change
	 * the order of recursive calls.
	 * 
	 * @param a - the binary tree you are currently looking at.
	 */
	public static void treeTraversal(BinaryTree<String> a)
	{
		//if the binary tree is empty, there is nothing to print.
		if(a == null)
		{
			return;
		}
		//pre order behavior
		if(a.getContent() != null)
		{
			System.out.println(a.getContent());
		}
		treeTraversal(a.getLeft());
		treeTraversal(a.getRight());
		//change to in order
				/*
					treeTraversal(a.getLeft());
				  	if(a.getContent() != null)
					{
						System.out.println(a.getContent());
					}
				 	treeTraversal(a.getRight()); 
				 */
		//or post order
				/*
				 	treeTraversal(a.getLeft());
				 	treeTraversal(a.getRight());
				  	if(a.getContent() != null)
					{
						System.out.println(a.getContent());
					}
				 */
	}
	/*
	 * Summary:
	 * Lists are a really flexible data structure. If you expect changes in the
	 * data structure during traversal make sure to use an iterator. 
	 * Stacks process elements in a last in first out manner
	 * Queues process elements in a first in first out manner
	 * Tree data structures can be implemented using relationships between
	 * roots.   
	 */
	//->DONE
}
