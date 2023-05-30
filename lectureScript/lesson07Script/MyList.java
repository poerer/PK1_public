package lesson07Script;

/**
 * (*15*)
 * My own list data structure. The data structure is implemented with unidirectional
 * relations between the nodes (elements). MyList offers some basic functionality
 * like adding or getting elements. The design looks like this:
 * 
 * 	MyList:
 * 		 ____________________________________
 *  	|							 		 |
 *  guard-> node1 -> node2 -> ... -> nodeN <-guard
 *  	|____________________________________|
 *  	
 * Therefore, we need to different classes: MyList.java is the interface for the 
 * programmer who wants to use my data structure. Node.java is responsible for
 * storing elements. Guards are nothing more than just references to the first
 * and last element (object of type Node). Relationships between elements are, 
 * therefore, implemented in Node.java.
 * 
 * @author fuchs
 *
 */
public class MyList
{
	/*
	 * Guards are providing access to the nodes.
	 * They can be seen as the status of the MyList. Where is the starting 
	 * point, where is the end point. This is different for different lists
	 * and is, therefore, an object variable (field). Since they are referencing
	 * nodes, they have to be of the same type (Node).
	 * ->switch to Node.java (*16*)
	 */
	
	//(*17*)
	//This is the first guard it grants access to the first element.
	private Node first;
	//This is the last guard it grants access to the last element.
	private Node current;
	/*
	 * The size of the list in terms of number of elements also defines 
	 * the status of the list.
	 */
	private int size = 0;
	
	/**
	 * Empty constructor = default constructor.
	 * The list is empty, no elements are stored in the data structure.
	 * We could also just remove this constructor since nothing happens here.
	 */
	public MyList()
	{
		
	}
	
	/**
	 * This method adds elements to our MyList data structure. 
	 * Elements are in our case Strings. We make use of our nodes to add the 
	 * content. 
	 * 
	 * @param content - String to be added to the MyList data structure.
	 */
	public void add(String content)
	{
		//Since a new element is added, we can increase the size of the MyList.
		this.size++;
		//In order to add an element, we have to create a new node, which can store Strings. 
		Node newNode = new Node(content);
		/*
		 * In case it is the first node, which is added to the data structure, 
		 * we simply use both guards to reference this new node. It is, therefore,
		 * the first element and the last element in the data structure.
		 * 			guard -> node1 <- guard
		 * 			first -> newNode <- current
		 */
		if (this.first == null)
		{
			this.first = newNode;
			this.current = newNode;
		}
		/*
		 * Nodes are added to the end of the list (see sketch at the top).
		 * Therefore, the current last node e.g., node3 needs to know this new node
		 * (node4). The last guard is referencing the last node. We take this reference
		 * to get the last node. Since nodes know the next node we just have to tell
		 * our current last node that the new node is the next node. As a last step,
		 * we have to set our guard reference (current) to the new node because it is 
		 * now the last node.
		 * 								    .setNext(newNode)
		 * 			first -> ... -> lastNode -> newNode
		 * 								^
		 * 							 current (last guard)
		 * 			
		 * 			first -> ... -> lastNode -> newNode
		 * 										  ^
		 * 							 			current (last guard)
		 */
		else
		{
			this.current.setNext(newNode);
			this.current = newNode;
		}
	}
	
	/**
	 * Return the String, which is stored at position i. i has to be positive 
	 * or equal 0. Since we are not using an index structure, we have to make
	 * use of the unidirectional relations to retrieve the String at position i.
	 * 
	 * @param i - the position of the String.
	 * @return the String at position i.
	 */
	public String get(int i)
	{
		//First, we check whether the position exists in our MyList data structure
		if(i >= 0 && i < this.size)
		{
			//We make use of the first guard to access the first node.
			Node tmp = first;
			if(i == 0)
			{
				//if i is 0, then the first element will be returned.
				return tmp.getContent();
			}
			else
			{
				/*
				 * If i is greater than 0, we have to start from the very beginning
				 * (first node) and then use the unidirectional relationship to
				 * traverse the list till position i. With getNext() we always 
				 * get the next node in the data structure.
				 */
				while(i > 0)
				{
					tmp = tmp.getNext();
					i--;
				}
				//Now, we got the correct node and return the String, which is stored there.
				return tmp.getContent();
			}
		}
		//I case the position does not make sense, we return null as a reference.
		else
		{
			return null;
		}
	}
	
	/**
	 * Get the length of the list (the number of elements stored in the list).
	 * 
	 * @return
	 */
	public int size()
	{
		//we just return the current status of the MyList.
		return this.size;
	}
	
	/**
	 * If you want to practice, you can implement this method to be able to 
	 * remove elements from the list.
	 * 
	 * @param i - the position in the list where to remove the element.
	 */
	public void remove(int i)
	{
		//First, you should check, whether i is a regular position (not negative etc.)
		
		/*
		 * As a next step, you can remove elements by just setting the references
		 * of the nodes differently.
		 * E.g., you want to remove element2:
		 *  		element1 -> element2 -> element3
		 *  			  element1 -> element3
		 * something like: 
		 *  		node1.setNext(node3);
		 *  
		 * If the node was successfully removed, you have to decrease the size
		 * of the MyList data structure:
		 * 			this.size--;
		 */
	}
	//switch to Relations.java (*18*)
}
