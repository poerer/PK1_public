package lesson10;

import java.util.LinkedList;
import java.util.Queue;

public class Application7BinaryTree
{
	//some input taken from the slides in KdI 
	private static String[] input = {"-","-","-","12","*","9","3","^2","-","7","5"};
	
	public static void main(String[] args)
	{
		System.out.println("--Tree Structure--");
		//Initialize the tree with some input
		initTree();
	}
	/**
	 * Initialize the tree manually.
	 * In a next step use the root node to start
	 * traversing the tree in different ways.
	 * (preorder, postorder, etc.)
	 */
	public static void initTree()
	{
		
		BinaryTree<String> w = new BinaryTree<String>(input[9]);
		BinaryTree<String> x = new BinaryTree<String>(input[10]);
		BinaryTree<String> y = new BinaryTree<String>(w, input[8], x);
		BinaryTree<String> z = new BinaryTree<String>(y, input[7], null);
		BinaryTree<String> d = new BinaryTree<String>(input[5]);
		BinaryTree<String> b = new BinaryTree<String>(input[6]);
		BinaryTree<String> c = new BinaryTree<String>(b, input[4], z);
		BinaryTree<String> e = new BinaryTree<String>(c, input[2], d);
		BinaryTree<String> a = new BinaryTree<String>(input[3]);
		BinaryTree<String> f = new BinaryTree<String>(a, input[1], null);
		//this is the root node at the very top of the tree
		BinaryTree<String> root = new BinaryTree<String>(f, input[0], e);
		
		//Start the traversal of the tree
		System.out.println("Preorder: ");
		preOrder(root);
		System.out.println();
		System.out.println("Postorder: ");
		postOrder(root);
		System.out.println();
		System.out.println("Inorder: ");
		inOrder(root);
		System.out.println();
		System.out.println("Levelorder: ");
		levelOrder(root);
	}
	/**
	 * Traverse the tree in preorder fashion.
	 * Print - Left - Right
	 * @param root
	 */
	public static void preOrder(BinaryTree<String> root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			System.out.print(root.getContent());
			preOrder(root.getLeft());
			preOrder(root.getRight());
		}
	}
	/**
	 * Traverse the tree in postorder fashion.
	 * Left - Right - Print
	 * @param root
	 */
	public static void postOrder(BinaryTree<String> root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			postOrder(root.getLeft());
			postOrder(root.getRight());
			System.out.print(root.getContent());		
		}
	}
	/**
	 * traverse the tree in inorder fashion.
	 * Left - Print - Right
	 * @param root
	 */
	public static void inOrder(BinaryTree<String> root)
	{
		if(root == null)
		{
			return;
		}
		else
		{
			inOrder(root.getLeft());
			System.out.print(root.getContent());
			inOrder(root.getRight());			
		}
	}
	/**
	 * traverse the tree in levelorder fashion.
	 * Level by level
	 * @param root
	 */
	public static void levelOrder(BinaryTree<String> root)
	{
		Queue<BinaryTree<String>> list = new LinkedList<BinaryTree<String>>();
		list.offer(root);
		//easier to traverse the tree using a loop.
		while(!list.isEmpty())
		{
			BinaryTree<String> tmp = list.poll();
			if(tmp != null)
			{
				System.out.print(tmp.getContent());
				list.offer(tmp.getLeft());
				list.offer(tmp.getRight());
			}
		}
	}
}
