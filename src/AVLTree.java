
public class AVLTree
{

	public static void main(String[] args)
	{
		AVLTree t = new AVLTree(10);
	}
	
	public Node root;
	
	public AVLTree(int i)
	{
		root = new Node(i);
	}
	
	public void insert(int i)
	{
		
	}
	
	public void delete(int i)
	{
		
	}
	
	public boolean find(int i)
	{
		return false;
	}

	public class Node
	{
		int key;
		int height;
		Node left;
		Node right;
		
		public Node(int k)
		{
			key = k;
			height = 0;
			left = null;
			right = null;
		}
	}
}

