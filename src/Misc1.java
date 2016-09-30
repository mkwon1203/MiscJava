import java.util.*;

// for problem on geeksforgeeks.org
public class Misc1
{

	public static void main(String[] args)
	{
//		int[][] A = {{1,5,8,11,15,20,26,35},
//					 {6,10,15,20,21,23,27,39},
//					 {7,11,19,25,26,29,30,44},
//					 {10,20,22,29,30,35,39,45},
//					 {
//					};
		Scanner scan = new Scanner(System.in);
		String numOfTestCases = scan.nextLine();
		int numOfTestCase = Integer.parseInt(numOfTestCases);
		for (int testCase = 0; testCase < numOfTestCase; testCase ++)
		{
			String line1 = scan.nextLine();
			String[] mn = line1.split((" "));
			int rowN = Integer.parseInt(mn[0]);
			int colM = Integer.parseInt(mn[1]);
			String line2 = scan.nextLine();
			String[] nums = line2.split(" ");
			
			int[][] A = new int [rowN][colM];
			for (int i = 0; i < rowN; i ++)
			{
				for (int j = 0; j < colM; j ++)
				{
					A[i][j] = Integer.parseInt(nums[i*colM + j]);
				}
			}
			
			
			// begin the search
			int key = Integer.parseInt(scan.nextLine());
			int row = 0;
			int col = colM-1;
			int curr = A[row][col];
			boolean found = false;
			
			while (row < rowN && col >= 0)
			{
				curr = A[row][col];
				
				if (curr == key)
				{
					found = true;
					break;
				}
				else if (curr < key)
				{
					row ++;
				}
				else
				{
					col --;
				}
			}
			
			if (found)
			{
				System.out.println("1");
			}
			else
			{
				System.out.println("0");
			}
			
		}
		
	}

}
