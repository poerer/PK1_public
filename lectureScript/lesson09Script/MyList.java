package lesson09Script;

/**
 * (*10*)
 * We will change our previous MyList data structure to something more generic.
 * Therefore, we introduce generics. Since our data structure is able to store
 * one type of object, we have to introduce one type variable <E> (E for element).
 * This type variable is written in the class description right after the class
 * identifier.
 * 				public class MyList<E>
 * As a next step, we have to simply replace all String data types with our 
 * variable E. Of course, since data is stored in the nodes (Node.java) we
 * have to do the same thing there, as well.
 * 
 * @author fuchs
 *
 */
public class MyList<E>
//					^
//				type variable
{
	/*
	 * As mentioned earlier, data is stored in the nodes. Therefore, we have
	 * to add type variables to the nodes, too. This has to be the same variable
	 * as the MyList type variable E. 
	 * ->switch to Nodes.java (*11*)
	 */
	private Node<E> first;
	private Node<E> current;
	private int size = 0;
	
	/**
	 * (*12*)
	 * We also have to modify the add method because here the parameter needs
	 * to be more flexible. We cannot just store Strings but any kind of type.
	 * Therefore, we have to replace:
	 * 					String content
	 * with
	 * 					E content
	 * 
	 * @param content - any object can be stored in our data structure
	 */
	public void add(E content)
	{
		this.size++; 
		/*
		 * Again, we have to specify what kind of type the Node expects. It is
		 * the same type as the MyList data structure.
		 */
		Node<E> newNode = new Node<E>(content);
		
		if (this.first == null)
		{
			this.first = newNode;
			this.current = newNode;
		}
		else
		{
			this.current.setNext(newNode);
			this.current = newNode;
		}
	}
	
	/**
	 * What kind of type do we get from our data structure? Previously, it was
	 * just Strings. But now, since we are more flexible it is a type variable.
	 *  
	 * @param i - the position in the data structure we are looking at
	 * @return - the object stored in the data structure
	 */
	public E get(int i)
	{
		if(i >= 0 && i < this.size)
		{
			Node<E> tmp = first;
			if(i == 0)
			{
				return tmp.getContent();
			}
			else
			{
				while(i > 0)
				{
					tmp = tmp.getNext();
					i--;
				}
				return tmp.getContent();
			}
		}
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
		return this.size;
	}
	//switch to Generics.java (*13*)
}
