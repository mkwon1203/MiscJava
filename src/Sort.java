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
		MergeSortHelper(a, 0, a.length-1);
		
		return a;
	}
	
	public static void MergeSortHelper(int[] a, int start, int end)
	{
		if (start >= end)
		{
			return;
		}
		
		MergeSortHelper(a, start, end/2);
		MergeSortHelper(a, end/2 + 1, end);
		MergeSortMerge(a, start, end);
	}
	
	public static void MergeSortMerge(int[] a, int start, int end)
	{
		
	}
	
	public static int[] QuickSort(int[] a)
	{
		
		
		return a;
	}
}
