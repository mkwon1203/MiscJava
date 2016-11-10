import java.util.ArrayList;
import java.util.*;

public class Graph
{

	public static void main(String[]args)
	{
		Graph g = new Graph();
		Node[] arr = new Node[5];
		for (int i=0; i < arr.length; i++)
		{
			arr[i] = g.new Node(i, "Node " + i);
		}
		
		arr[0].addNeighbor(arr[1]);
		arr[0].addNeighbor(arr[2]);
		arr[1].addNeighbor(arr[0]);
		arr[1].addNeighbor(arr[2]);
		arr[1].addNeighbor(arr[3]);
		arr[2].addNeighbor(arr[0]);
		arr[2].addNeighbor(arr[1]);
		arr[3].addNeighbor(arr[1]);
		arr[3].addNeighbor(arr[4]);
		arr[4].addNeighbor(arr[3]);
		/*
		 *             0
		 *           /   \
		 *          1     2
		 *          |
		 *          3  -  4
		 *          
		 */
		
		// implement Dijkstra, BFS and DFS
		bfs_print(arr[0]);
	}
	
	public static String generateDot(Node root)
	{
		String toReturn = "";
		
		return toReturn;
	}
	
	public static void dfs_print(Node root)
	{
		
	}
	
	public static void bfs_print(Node root)
	{
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while (!q.isEmpty())
		{
			Node curr = q.remove();
			
			if (!curr.visited)
				System.out.println(curr.value);
			
			curr.visited = true;
			
			ArrayList<Node> adj = curr.adj;
			
			for (Node n : adj)
			{
				if (!n.visited)
					q.add(n);
			}
		}
	}
	
	public class Node
	{
		int key;
		String value;
		ArrayList<Node> adj;
		boolean visited;
		
		public Node()
		{
			key = 0;
			value = "";
			adj = new ArrayList<Node>();
			visited = false;
		}
		
		public Node(int key)
		{
			this.key = key;
			value = "";
			adj = new ArrayList<Node>();
			visited = false;
		}
		
		public Node(int key, String val)
		{
			this.key = key;
			this.value = val;
			adj = new ArrayList<Node>();
			visited = false;
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
