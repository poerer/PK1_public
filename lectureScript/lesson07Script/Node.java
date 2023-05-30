package lesson07Script;

/**
 * (*16*)
 * Nodes are responsible for storing content in lists. In our case, the Node can
 * just store Strings. That is why it has a object variable (field) String content.
 * Additionally, we have to implement a unidirectional relationship between nodes.
 * That is why another object variable (field) is the next node in the list.
 *  
 * @author fuchs
 *
 */
public class Node 
{
	/*
	 * We are using a unidirectional relationship. Therefore, the current node
	 * just knows the next node but the next node does not know the current node.
	 */
	private Node next;
	/*
	 * In our data structure we can just store objects of type String. This is 
	 * a huge limitations. Later, when we introduce Generics, you will see how
	 * we can improve this to be more flexible.
	 */
	private String content;
	
	/**
	 * There is only a constructor taking the content of 
	 * the node.
	 * 
	 * @param content
	 */
	public Node(String content)
	{
		this.content = content;
	}
	
	/**
	 * Set the reference to the next node (unidirectional relationship).
	 * 
	 * @param next - the next node in the data structure
	 */
	public void setNext(Node next)
	{
		this.next = next;
	}
	
	/**
	 * Get the next node
	 * 
	 * @return - the next node in the data structure
	 */
	public Node getNext()
	{
		return this.next;
	}
	
	/**
	 * Get the content of the node, which is in our case a String.
	 * 
	 * @return - the content stored in this node.
	 */
	public String getContent()
	{
		return this.content;
	}
	//-> switch to MyList.java (*17*)
}
