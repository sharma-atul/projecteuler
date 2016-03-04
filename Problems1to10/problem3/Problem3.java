package Problems1to10.problem3;

import java.math.BigInteger;

import util.Util;

public class Problem3 {
	
	public static void main(String[] args) 
	{
		if(args.length != 1){
			System.out.println("Invalid number of arguments");
			return;
		}
			
		BigInteger i = new BigInteger(args[0]);
		int sqrt = (int) java.lang.Math.ceil(java.lang.Math.sqrt(i.doubleValue()));
		
		int solution = 0;
		BigInteger remainder;
		
		for(int j = 1; j <= sqrt; j = j + 2)
		{
			remainder = i.remainder(new BigInteger(String.valueOf(j)));
			if(remainder.intValue() == 0){
				if(Util.isPrime(j)) solution = j;
			}
			
		}
		System.out.println(solution);
	}


}
