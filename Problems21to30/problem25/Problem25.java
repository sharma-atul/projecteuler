package Problems21to30.problem25;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import util.Util;

public class Problem25 {

	public static void main(String[] args) {

        if(!Util.validArgsLength(args,1)) System.exit(0);
        
        int n =  Integer.parseInt(args[0]);
		int length = 0;
		
		//start dictionary
		long start = System.currentTimeMillis();

		for(int i = 0; i < n; i++)
		{
			length = (Util.fastFibonacci(i).toString()).length();
			
			if(length == 2500){
				System.out.println("Number: " + i);
				break;
			}
		}
 
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
	}

}
