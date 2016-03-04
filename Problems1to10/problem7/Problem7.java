package Problems1to10.problem7;

import util.Util;

public class Problem7 {


	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int targetPrimes = 10001;
		int numPrimes = 1;
		int n = 1;
		long start = System.currentTimeMillis();
		while(numPrimes < targetPrimes)
		{
			n += 2;
			if(Util.isPrime(n))
			{
				++numPrimes;
			}
			if(numPrimes == targetPrimes){
				System.out.println(n + " is the "+ numPrimes + " prime.");
				break;
			}

		}
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
		
	}

}
