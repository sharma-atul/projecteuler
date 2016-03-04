package util;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Util {

    public static boolean isPrime(BigInteger i, int likeliness) 
    {
    	return i.isProbablePrime(likeliness);
    }

	public static boolean isPrime(int n)
	{
		if(n==1) 
			return false;
		if(n%2 == 0)
			return false;
		if(n<4)
			return true;
		if(n< 9) 
			return true;
		
		if(n % 3==0) //all primes > 3 are of form 6K +/- 1
			return false;
		
		int x = (int) Math.floor(Math.sqrt(n));
		int i = 5;
		while(i <= x){
			if(n % i == 0) 
				return false;
			if(n % (i+2) == 0) 
				return false;
			i += 6;
		}
		return true;
	}
    
    public static BigInteger squareRoot(BigInteger x) {
        BigInteger div = BigInteger.ZERO.setBit(x.bitLength()/2);
        BigInteger div2 = div;
        // Loop until we hit the same value twice in a row, or wind
        // up alternating.
        for(;;) {
            BigInteger y = div.add(x.divide(div)).shiftRight(1);
            if (y.equals(div) || y.equals(div2))
                return y;
            div2 = div;
            div = y;
        }
    }
    
    public static boolean validArgsLength(String[] args, int expectedLen)
    {
        if(args.length != expectedLen){
            System.out.println("Expected : " + expectedLen + "  but received only " + args.length + " arguements");
            return false;
        }
        return true;
    }
    
    public static BigInteger factorial(int n)
    {
    	BigInteger result = BigInteger.ONE;
    	for(int i = n; i > 0; i--)
    	{
    		result = result.multiply(new BigInteger(Integer.toString(i)));
    	}
    	return result;
    }
    
    //Iteration method
    public static BigInteger fibonacci(int n) {
        BigInteger x = BigInteger.ZERO;
        BigInteger y = BigInteger.ONE;
		BigInteger z = BigInteger.ONE;
		
        for (int i = 0; i < n; i++) {
            x = y;
            y = z;
            z = x.add(y);
        }
        return x;
    }
    
    
    /**
     * fibonacci using a dictionary
     * 
     * @param n - fibonacci number requested
     * @param dict - dictionary that has F(100) and F(101) computed.
     * @return  nth fibonacci number
     */
	public static BigInteger fibonacciDictionary(int n,Map<Integer, BigInteger> dict) {

		if(n == 0)
			return dict.get(0);
		if(n == 1)
			return dict.get(1);
					
        for (int i = 2; i <=n; i++) {
        	if(!dict.containsKey(i))
        		dict.put(i,(dict.get(i-2)).add(dict.get(i-1)));
        }
        return dict.get(n);
	}
    
    public static BigInteger fastFibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("The fibo value cannot be negative");
        }

        if (n <= 1) return BigInteger.valueOf(n);
 
        BigInteger[][] result = {{BigInteger.ONE, BigInteger.ZERO}, {BigInteger.ZERO, BigInteger.ONE}}; // identity matrix.
        BigInteger[][] fiboM = {{BigInteger.ONE, BigInteger.ONE}, {BigInteger.ONE, BigInteger.ZERO}};

        while (n > 0) {
            if (n%2 == 1) {
                multMatrix(result, fiboM);
            }
            n = n / 2;
            multMatrix(fiboM, fiboM);
        }

        return result[1][0];
    }

    private static void multMatrix(BigInteger[][] m, BigInteger [][] n) {

    	BigInteger a = (m[0][0].multiply(n[0][0])).add(m[0][1].multiply(n[1][0]));
    	BigInteger b = (m[0][0].multiply(n[0][1])).add(m[0][1].multiply(n[1][1]));
    	BigInteger c = (m[1][0].multiply(n[0][0])).add(m[1][1].multiply(n[0][1]));
    	BigInteger d = (m[1][0].multiply(n[0][1])).add(m[1][1].multiply(n[1][1]));

        m[0][0] = a;
        m[0][1] = b;
        m[1][0] = c; 
        m[1][1] = d; 
    }
    
    public static List<Integer> findDivisors(int n)
    {
    	List<Integer> result = new ArrayList<Integer>();
    	int sqrt = (int)Math.ceil(Math.sqrt(n));
    	
    	result.add(1);
    	for(int i = 2; i <= sqrt; i++){
    		//if find divisor
    		if(n%i == 0){
				//add the divisor
    			if(!result.contains(i)){
    				result.add(i);
    			//if don't contain the quotient add that
    				if(n/i != n)
    				result.add(n/i);
    			}
    		}	
    	}

    	return result;
    }
    
    public static int findSumOfDivisors(int n)
    {
    	int result = 0;
    	List<Integer> list = findDivisors(n);
    	for(int x : list)
    	{
    		result += x;
    	}
    	return result;
    }
    
    public static List<BigInteger> findAllDivisors(BigInteger n)
    {
    	List<BigInteger> result = new ArrayList<BigInteger>();
    	BigInteger sqrt = squareRoot(n);
    	BigInteger i = BigInteger.ONE;

    	while(!(sqrt.subtract(i)).equals(BigInteger.ZERO)){
    		if(n.mod(i).equals(BigInteger.ZERO)){
    			if(!result.contains(i))
    				result.add(i);
    			if(!result.contains(n.divide(i)))
    				result.add(n.divide(i));
    		}
    		i = i.add(BigInteger.ONE);

    	}
    	return result;
    }

    public static BigInteger nthTriangleNumber(BigInteger n)
    {
    	BigInteger nplusone = n.add(BigInteger.ONE);
    	BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
    	return (n.multiply(nplusone)).divide(two);
    }
}
