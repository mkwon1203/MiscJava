import java.util.*;

// can only insert lowercase words
public class Trie
{
	Node root;
	
	public static void main(String[]args)
	{
		Trie t = new Trie();
		t.insert("hello");
		t.insert("ohai");
		t.insert("apple");
		
		System.out.println(t.root);
		t.delete("hello");
		System.out.println(t.find("hello"));
		System.out.println(t.find("apple"));
		System.out.println(t.find("applee"));
	}
	
	public Trie()
	{
		root = new Node();
	}
	
	public String toString()
	{
		Queue<Node> queue = new LinkedList<Node>();
		
		queue.add(root);
		
		toStringHelper(queue, root.ar[0]);
		
		return "";
	}
	
	public void toStringHelper(Queue<Node> queue, Node curr)
	{
		
	}
	
	public void insert(String word)
	{
		Node curr = root;
		
		for (int i = 0; i < word.length(); i ++)
		{
			int c = word.charAt(i) - 97;
			
			if (curr.ar[c] == null)
			{
				curr.ar[c] = new Node();
				curr.ar[c].parent = curr;
			}
			
			curr = curr.ar[c];
		}
		
		curr.flag = true;
	}
	
	public void delete(String word)
	{
		Node curr = root;
		
		for (int i = 0; i < word.length(); i ++)
		{
			int c = word.charAt(i) - 97;
			
			if (curr.ar[c] == null)
			{
				return; // word doesn't exist
			}
			else
			{
				curr = curr.ar[c];
			}
		}
		
		curr.flag = false;
	}
	
	public boolean find(String word)
	{
		Node curr = root;
		
		for (int i = 0; i < word.length(); i ++)
		{
			int c = word.charAt(i) - 97;
			
			if (curr.ar[c] == null)
			{
				return false;
			}
			else
			{
				curr = curr.ar[c];
			}
		}
		
		return curr.flag;
	}
	
	public class Node
	{
		Node[] ar; // 0=a, 1=b, ... 25=z alphabet is just a-z
		boolean flag; // 1 if word ends at this node
		Node parent;
		
		public Node()
		{
			ar = new Node[26];
			flag = false;
			parent = null;
		}
		
		public String toString()
		{
			String ret = "";
			
			for (int i = 0; i < ar.length; i ++)
			{
				ret += ar[i] == null ? "[ ]" : "[" + (char)(i+97) + "]";
			}
			
			return ret;
		}
	}
}
