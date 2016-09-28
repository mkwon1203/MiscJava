// implementing various sorting algorithms

public class Sort
{
	public static int[] InsertionSort(int[] a)
	{
		for (int i = 1; i < a.length; i ++)
		{
			int key = a[i];
			
			int j = i-1;
			
			while (j >= 0 && a[j] > key)
			{
				a[j+1] = a[j];
				j --;
			}
			a[j+1] = key;
		}
		
		return a;
	}
	
	public static int[] MergeSort(int[] a)
	{
		if (a.length <= 1)
		{
			return a;
		}
		
		int[] left = new int[a.length/2];
		int[] right = new int[a.length/2 + (a.length%2)];
		
		for (int i = 0; i < a.length/2; i ++)
		{
			left[i] = a[i];
		}
		for (int i = a.length/2; i < a.length; i ++)
		{
			right[i-a.length/2] = a[i];
		}
		
		int[] leftSorted = MergeSort(left);
		int[] rightSorted = MergeSort(right);
		return MSMerge(leftSorted, rightSorted);
	}
	
	public static int[] MSMerge(int[] left, int[] right)
	{
		int[] result = new int[left.length + right.length];
		
		int leftIdx = 0;
		int rightIdx = 0;
		boolean leftEmpty = false;
		boolean rightEmpty = false;
		
		for (int i = 0; i < result.length; i ++)
		{
			if (!leftEmpty && left[leftIdx] < right[rightIdx])
			{
				result[i] = left[leftIdx++];
				if (leftIdx >= left.length)
				{
					leftEmpty = true;
				}
			}
			else if (!rightEmpty)
			{
				result[i] = right[rightIdx++];
				if (rightIdx >= right.length)
				{
					rightEmpty = true;
				}
			}
		}
		
		return result;
	}
	
	public static int[] QuickSort(int[] a)
	{
		
		
		return a;
	}
}
