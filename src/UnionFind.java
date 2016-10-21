
public class UnionFind
{

	public static void main(String[] args)
	{
		UnionFind x = new UnionFind();
		
		Node[] forest = new Node[10];
		for (int i = 0; i < 10; i ++){
			Node n = x.new Node(i);
			n.parent = n;
			
			forest[i] = n;
		}
		
		union(forest[0], forest[1]);
		union(forest[2], forest[3]);
		union(forest[0],forest[3]);
		
		System.out.println(find(forest[0],forest[2]));
		System.out.println(find(forest[0],forest[5]));
	}
	
	public static void union(Node i, Node j)
	{
		//easiest, most naive way
		//find_root(j).parent = i;
		
		//a better way (slightly)
		//find_root(j).parent = find_root(i);
		
		
		// this way gets you O(log n) operations
		
		Node rootI = find_root(i);
		Node rootJ = find_root(j);
		
		if (rootI.num < rootJ.num)
		{
			rootI.parent = rootJ;
			rootJ.num += rootI.num;
		}
		else // rootI actually has more or equal
		{
			rootJ.parent = rootI;
			rootI.num += rootJ.num;
		}
		
		
	}
	
	public static boolean find (Node i, Node j)
	{
		return find_root(i) == find_root(j);
	}
	
	public static Node find_root(Node i)
	{
		
		if (i.parent != i)
			i.parent = find_root(i.parent);
			
		return i.parent;
		
		// path compression gets you amortized O( m * a(n) ) for m operations with n atoms
		
	}

	
	public class Node
	{
		public int key;
		public Node parent;
		
		public int num; // roots will store number of nodes in tree
		
		public Node(int i )
		{
			parent = null;
			key = i;
			num = 1; // you start out as root to single node tree
		}
	}
}
