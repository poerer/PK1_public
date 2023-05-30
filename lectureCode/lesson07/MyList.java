package lesson07;

public class MyList
{
	private Node first;
	private Node current;
	private int size = 0;
	
	/**
	 * empty constructor, root is not initialized
	 */
	public MyList()
	{
		
	}
	
	/**
	 * constructor with a first element. Initialize root
	 * 
	 * @param root
	 */
	public MyList(int value)
	{
		Node root = new Node(value);
		// the starting node is the first and the last node in the list
		this.first = root;
		this.current = root;
		this.size++;
	}
	
	/**
	 * add a new element to the list
	 * 
	 * @param element
	 */
	public void add(int value)
	{
		Node newNode = new Node(value);
		
		this.size++;
		
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
	 * return the value at the position i. i has to be positive or equals 0
	 * @param i index of node
	 * @return value or -1 if not available
	 */
	public int get(int i)
	{
		if(i >= 0 && i < this.size)
		{
			Node tmp = first;	
			while(i > 0)
			{
				tmp = tmp.getNext();
				i--;
			}
			return tmp.getContent();
			
		}
		else
		{
			System.out.println("index is out of range");
			return -1;
		}
	}
	
	/**
	 * Get the length of the list.
	 * 
	 * @return
	 */
	public int getSize()
	{
		return this.size;
	}
}
