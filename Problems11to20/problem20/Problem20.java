package Problems11to20.problem20;

import util.Util;
import java.math.BigInteger;

public class Problem20 {

	public static void main(String[] args) {
        // TODO Auto-generated method stub
        if(!Util.validArgsLength(args,1)) System.exit(0);
        
        int n =  Integer.parseInt(args[0]);
        //Start
		long start = System.currentTimeMillis();
        
		BigInteger factorial = Util.factorial(n);
        String s = factorial.toString();
        BigInteger factorialSum = BigInteger.ZERO;
        
		for(int j = 0; j < s.length(); j++){
			factorialSum = factorialSum.add(new BigInteger(s.substring(j,j+1)));
		}
		//End
		long end = System.currentTimeMillis();
		
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
		System.out.println("Sum of factorial("+n+") is :" + factorialSum.toString());
	}

}
