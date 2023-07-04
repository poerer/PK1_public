package lesson10;

/**
 * the binary tree data structure
 * @author Fuchs
 *
 */
public class BinaryTree<E>
{
	private BinaryTree<E> left;
	private BinaryTree<E> right;
	private E content;
	
	/**
	 * Creates an empty tree
	 */
	public BinaryTree()
	{
		
	}

	/**
	 * Creates a tree with a single node
	 * 
	 * @param content
	 */
	public BinaryTree(E content)
	{
		this.content = content;
	}

	/**
	 * Creates a tree consisting of two subtrees and a root
	 * 
	 * @param left
	 * @param content
	 * @param right
	 */
	public BinaryTree(BinaryTree<E> left, E content, BinaryTree<E> right)
	{
		this.left = left;
		this.content = content;
		this.right = right;
	}

	/**
	 * Return the content
	 * 
	 * @return
	 */
	public E getContent()
	{
		return this.content;
	}

	/**
	 * Get the left subtree
	 * 
	 * @return
	 */
	public BinaryTree<E> getLeft()
	{
		return this.left;
	}
	/**
	 * Get the right subtree
	 * 
	 * @return
	 */
	public BinaryTree<E> getRight()
	{
		return this.right;
	}
	/**
	 * Checks whether this tree is empty
	 * @return
	 */
	public boolean isEmpty()
	{
		return this.content == null;
	}
}
