import java.time.Clock;
import java.time.Instant;

public class Math_MK
{
	public static void main(String[]args)
	{
		Math_MK m = new Math_MK();
		Instant start = Instant.now();
		double d1 = sqrt_mk(31829857999999.0);
		Instant afterd1 = Instant.now();
		double d2 = sqrt_mk2(31829857999999.0);
		Instant afterd2 = Instant.now();
		
		System.out.println("d1: " + d1 + "  ms: " + afterd1.minusMillis(start.toEpochMilli()).toEpochMilli());
		System.out.println("d2: " + d2 + "  ms: " + afterd2.minusMillis(afterd1.toEpochMilli()).toEpochMilli());
	}
	

	// "naive" search
	public static double sqrt_mk(double d)
	{
		double low = 0.0;
		double high = d;
		double mid = (low + high)/2;
		
		while ( abs_mk(mid*mid - d) >= 0.00001 )
		{	
			if (mid*mid > d)
			{
				high = mid;
			}
			else
			{
				low = mid;
			}
			
			mid = (low+high)/2;
		}
		
		return mid;
	}
	
	// newton method
	public static double sqrt_mk2(double d)
	{
		double guess = d/2.0;
		
		while (abs_mk(guess*guess - d) > 0.00001)
		{
			guess = (guess+d/guess)/2.0;
		}
		
		return guess;
	}


	private static double abs_mk(double d)
	{
		return d >= 0.0 ? d : d*-1;
	}
}
