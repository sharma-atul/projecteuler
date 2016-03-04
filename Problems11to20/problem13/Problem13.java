package Problems11to20.problem13;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Problem13 {

	public static void main(String[] args) {
		// Open the file
		FileInputStream fstream;
		BigInteger sum = BigInteger.ZERO;
		try {
			fstream = new FileInputStream("/Users/chhibba/Documents/workspace/Project_Euler/src/Problems11to20/problem13/numbers.txt");

		BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

		String strLine;
		BigInteger next = null;

		//Read File Line By Line
		long start = System.currentTimeMillis();
		while ((strLine = br.readLine()) != null)   {
		  // Print the content on the console
		  System.out.println (strLine);
		  next = new BigInteger(strLine);
		  sum = sum.add(next);
		}
		
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
		//Close the input stream
		br.close();
		System.out.println("First 10 digits:");
		System.out.println(sum.toString().substring(0,10));
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
