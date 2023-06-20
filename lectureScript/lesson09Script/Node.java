package lesson09Script;

/**
 * (*11*)
 * We do the same modifications as in the MyList class. We are simply replacing
 * all Strings with the type variable E. Since we do not want to work with raw
 * types we are adding the type variable to each reference of Node. 
 *  
 * @author fuchs
 *
 */
public class Node<E> 
{
	private Node<E> next;
	private E content;
	
	/**
	 * There is only a constructor taking the content of 
	 * the node.
	 * 
	 * @param content
	 */
	public Node(E content)
	{
		this.content = content;
	}
	
	/**
	 * Set the reference to the next node (unidirectional relationship).
	 * 
	 * @param next - the next node in the data structure
	 */
	public void setNext(Node<E> next)
	{
		this.next = next;
	}
	
	/**
	 * Get the next node
	 * 
	 * @return - the next node in the data structure
	 */
	public Node<E> getNext()
	{
		return this.next;
	}
	
	/**
	 * Get the content of the node, which is in our case a String.
	 * 
	 * @return - the content stored in this node.
	 */
	public E getContent()
	{
		return this.content;
	}
	//->switch to MyList.java (*12*)
}
