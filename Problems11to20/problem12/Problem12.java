package Problems11to20.problem12;
import java.math.BigInteger;

import util.Util;

public class Problem12 {

	public static void main(String[] args) {
		int max = 0;
		long start = System.currentTimeMillis();
		BigInteger i = BigInteger.ONE.add(BigInteger.ONE);
		boolean found = false;
		while(!found){
			max = Math.max(max, (Util.findAllDivisors(Util.nthTriangleNumber(i))).size());
			if(max > 500)
			{
				System.out.println("Triangle Number with > 500 divisors : " + (Util.nthTriangleNumber(i)).toString());
				found = true;
			}
			i = i.add(BigInteger.ONE);
		}
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	

	}

}
