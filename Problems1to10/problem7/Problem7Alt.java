package Problems1to10.problem7;

import java.math.BigInteger;

import util.Util;

public class Problem7Alt {

	public static void main(String[] args) {
		//PRE
		//Get correct input for program
		int targetNumberOfPrimes = 0;
		if(args.length != 2)
		{
			System.out.println("Incorrect number of arguements provided.");
			return;
		}
		
		try{
			targetNumberOfPrimes = Integer.parseInt(args[0]);
		}catch(NumberFormatException e)
		{
			System.out.println("Invalid arguement provided.");
		}
		
		//START
		
		int numPrimes = 0;
		BigInteger n = BigInteger.ONE;
		long start = System.currentTimeMillis();
		while(numPrimes < targetNumberOfPrimes)
		{
			if(Util.isPrime(n,Integer.parseInt(args[1])))
			{
				++numPrimes;
			}

			if(numPrimes == 10001){
				System.out.println(n.toString() + " is the "+ numPrimes + " prime.");
				break;
			}
			n = n.add(BigInteger.ONE);
		}
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");
		//END
	}//end main

}//end class
