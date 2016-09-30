import java.util.ArrayList;
import java.util.Scanner;

// for geeksforgeeks.org againn
public class Misc2
{

	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		
		int T = Integer.parseInt(scan.nextLine());
		
		for (int t = 0; t < T; t++)
		{
			String intN = scan.nextLine();
			
			Object[] perms = permute(intN);
			
			boolean divisible = false;
			
			for (Object pi : perms)
			{
				if (Integer.parseInt(pi.toString()) % 8 == 0)
				{
					divisible = true;
					break;
				}
			}
			
			System.out.println(divisible?"Yes" : "No");
		}
	}

	public static Object[] permute(String s)
	{
		if (s.length() == 1)
		{
			String[] ret = {s};
			return ret;
		}
		
		ArrayList<String> toReturn = new ArrayList<String>();
		
		for (int i = 0; i < s.length(); i ++)
		{
			char c = s.charAt(i);
			Object[] perms = permute(s.substring(0, i) + s.substring(i+1,s.length()));
			
			for (Object pi : perms)
			{
				toReturn.add(c + pi.toString());
			}
		}
		
		return toReturn.toArray();
	}
}
