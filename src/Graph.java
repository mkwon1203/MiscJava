import java.util.ArrayList;

public class Graph
{

	public static void main(String[]args)
	{
		Graph g = new Graph();
		Node[] arr = new Node[5];
		for (int i=0; i < arr.length; i++)
		{
			arr[i] = g.new Node(i);
		}
		
		arr[0].addNeighbor(arr[1]);
		arr[0].addNeighbor(arr[2]);
		
		// implement Dijkstra, BFS and DFS
	}
	
	public static String generateDot(Node root)
	{
		String toReturn = "";
		
		return toReturn;
	}
	
	public class Node
	{
		int key;
		String value;
		ArrayList<Node> adj;
		
		public Node()
		{
			key = 0;
			value = "";
			adj = new ArrayList<Node>();
		}
		
		public Node(int key)
		{
			this.key = key;
			adj = new ArrayList<Node>();
		}
		
		public Node(int key, String val)
		{
			this.key = key;
			this.value = val;
			adj = new ArrayList<Node>();
		}
		
		public void addNeighbor(Node n)
		{
			adj.add(n);
		}
		
		public void setValue(String s)
		{
			this.value = s;
		}
		
	}
}
