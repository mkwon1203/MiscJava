
public class Tester
{

	public static void main(String[] args)
	{
		int[] a1 = {5,3,8,6,9,10,1,2,4,7,11};
		printArray(a1);
		printArray(Sort.InsertionSort(a1));
		printArray(Sort.MergeSort(a1));
		printArray(Sort.QuickSort(a1));
	}

	public static void printArray(int[] arr)
	{
		for (int o : arr)
		{
			System.out.print("[" + o + "] ");
		}
		System.out.println();
	}
}
