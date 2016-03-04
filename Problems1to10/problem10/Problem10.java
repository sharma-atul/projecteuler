package Problems1to10.problem10;

import java.math.BigInteger;

import util.Util;

public class Problem10 {


    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(!Util.validArgsLength(args,1)) System.exit(0);
        
        int limit =  Integer.parseInt(args[0]);
        BigInteger sumPrimes = BigInteger.ZERO;
        sumPrimes = sumPrimes.add(new BigInteger("2"));
        sumPrimes = sumPrimes.add(new BigInteger("3"));
        
		long start = System.currentTimeMillis();
        
		for(int k = 1; k < limit; k++)
        {
            
            int minus1 = (6*k) -1;
            int plus1 = (6*k) + 1;
            
            if(minus1 > limit || plus1 > limit) break;
            
            if(Util.isPrime(minus1)) sumPrimes = sumPrimes.add(new BigInteger(Integer.toString(minus1)));
            if(Util.isPrime(plus1)) sumPrimes = sumPrimes.add(new BigInteger(Integer.toString(plus1)));
            
        }
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
        System.out.println("Sum of primes below  " + limit + " is " + sumPrimes);
    }

}