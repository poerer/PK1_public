package lesson07;

/**
 * A Node stored in the list. The node makes use of generics
 * @author fuchs
 *
 */
public class Node
{
	private Node next;
	private int content;
	
	/**
	 * There is only a constructor taking the content of 
	 * the node
	 * @param content
	 */
	public Node(int content)
	{
		this.content = content;
	}
	
	/**
	 * set the pointer to the next node
	 * @param next
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	/**
	 * get the next node
	 * @return
	 */
	public Node getNext()
	{
		return this.next;
	}
	
	/**
	 * Get the content of the node
	 * @return
	 */
	public int getContent()
	{
		return this.content;
	}
}
