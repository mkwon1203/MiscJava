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
		return QuickSort_rec(a, 0, a.length-1);
	}
	
	public static int[] QuickSort_rec(int[]a, int low, int high)
	{
		 if (low >= high)
			 return a;
		
		// pick pivot
		// rand * high-low+1 gets us value 0 ~ high-low cuz int cast drops decimal, then we shift up by the low
		// now our index is between range low ~ high
		int pivotIndex = (int)(Math.random() * (high-low+1)) + low;
		int pivot = a[pivotIndex];
		
		// move pivot to end
		int temp = a[high];
		a[high] = a[pivotIndex];
		a[pivotIndex] = temp;
		
		// partition
		// pivot is at high index
		int lessIndex = low;
		for (int i = low; i < high; i ++)
		{
			if (a[i] < pivot)
			{
				// we need to move it to lessIndex!
				temp = a[lessIndex];
				a[lessIndex] = a[i];
				a[i] = temp;
				lessIndex ++;
			}
			// else we're good, keep going
		}
		// finally move pivot into place
		temp = a[high];
		a[high] = a[lessIndex];
		a[lessIndex] = temp;
		
		// recurse on left/right side of the pivot
		// note, lessIndex is where we finally stored our pivot
		int[] aLeft = QuickSort_rec(a, low, lessIndex-1);
		int[] aRight = QuickSort_rec(a, lessIndex+1, high);
		
		// this is inefficient... should've probably had one instance field array that methods access..
		for (int i = low; i <= lessIndex-1; i ++)
		{
			a[i] = aLeft[i];
		}
		for (int i = lessIndex+1; i<= high; i ++)
		{
			a[i] = aRight[i];
		}
		
		return a;
	}
}
