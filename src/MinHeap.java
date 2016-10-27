
public class MinHeap
{
	int[] array;
	int heapSize;
	
	public static void main(String[] args)
	{
		MinHeap m = new MinHeap();
		m.array[0] = 1;
		m.array[1] = 2;
		m.array[2] = 3;
		m.array[3] = 4;
		m.array[4] = 99;
		
		m.heapSize = 5;
		
		System.out.println(m);
		
		m.minExtract();
		
		
		System.out.println(m);
		
		
	}
	
	public static int[] heapSort(int[] a)
	{
		// build heap
		MinHeap heap = new MinHeap(a.length);
		for (int i : a)
		{
			heap.add(i);
		}
		
		int[] ret = new int[a.length];
		for (int i = 0; i < ret.length; i ++)
		{
			ret[i] = heap.minExtract();
		}
		
		return ret;
	}
	
	public String toString()
	{
		String toReturn = "";
		
		for (int i = 0; i < heapSize; i ++)
		{
			if (array[i] < 10)
			{
				toReturn += " " + array[i];
			}
			else if (array[i] < 100)
			{
				toReturn += array[i];
			}
			toReturn += " ";
		}
		
		return toReturn;
	}

	public MinHeap()
	{
		heapSize = 0;
		array = new int[50];
	}
	
	public MinHeap(int n)
	{
		heapSize = 0;
		array = new int[n];
	}
	
	// since java is 0-based index, we gotta account for that
	private int parent(int i)
	{
		return (i-1)/2;
	}
	
	// in doing minExtract, we need to see if left/right children exist
	// if indexes are out of bounds, just return parent idx for minextract loop to finish
	private int leftChild(int i)
	{
		return (i*2 + 1) < heapSize ? (i*2 + 1) : i;
	}
	
	private int rightChild (int i)
	{
		return (i*2 + 2) < heapSize ? (i*2 + 2) : i;
	}
	
	public void add(int key)
	{
		if (heapSize >= array.length)
		{
			// heap is full
			return;
		}
		
		array[heapSize] = key;
		
		int curr = heapSize;
		while (curr > 0)
		{
			if (array[curr] < array[parent(curr)])
			{
				int temp = array[parent(curr)];
				array[parent(curr)] = array[curr];
				array[curr] = temp;
				curr = parent(curr);
			}
			else
			{
				curr = parent(curr);
			}
		}
		
		heapSize ++;
	}
	
	// -1 if our heap is empty
	public int min()
	{
		return heapSize > 0 ? array[0] : -1;
	}
	
	public int minExtract()
	{
		if (heapSize <= 0)
			return -1;
		
		int toReturn = array[0];
		
		heapSize --; // now points to where the last leaf is
		array[0] = array[heapSize];
		array[heapSize] = 0; // remove basically
		
		// now heapify
		int curr = 0; // start at root
		
		while (curr < heapSize)
		{
			if (array[curr] <= array[leftChild(curr)] && array[curr] <= array[rightChild(curr)])
			{
				// heap property restored!
				break;
			}
			else
			{
				// i'm bigger than one of my children, find the min
				int minVal = Math.min(array[leftChild(curr)], array[rightChild(curr)]);
				int minIdx = array[leftChild(curr)] < array[rightChild(curr)] ? leftChild(curr) : rightChild(curr);

				array[minIdx] = array[curr];
				array[curr] = minVal;
				curr = minIdx;
			}
		}
		
		return toReturn;
	}
}
