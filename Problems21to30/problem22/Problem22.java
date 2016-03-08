package Problems21to30.problem22;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.math.BigInteger;
import java.util.List;

public class Problem22 {
	
	public static List<String> readData(String filename)
	{
		List<String> names = null;  
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));

	    	String line = null;
	    	
	    	while ((line = br.readLine()) != null) {
	    		line = line.toLowerCase();
	    		names = new ArrayList<String>(Arrays.asList(line.split(",")));
	    	}
	    	br.close();
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    return names;
	}
    
	private static int getNameValue(String name) {
		int total = 0;
		for(char c : name.toCharArray())
		{
			total += (int)c - (int)'a' + 1;
		}
		return total;
	}
	
    public static void main(String[] args) {
    	long start = System.currentTimeMillis();
    	List<String> names = readData("/Users/chhibba/Documents/workspace/Project_Euler/src"+
    								"/Problems21to30/problem22/names.txt");
    	Collections.sort(names,java.text.Collator.getInstance()); //sort names
    	int i = 1;
    	BigInteger sum = BigInteger.ZERO; 
    	for(String name : names)
    	{
    		sum = sum.add(new BigInteger(Integer.toString(i*getNameValue(name))));
    		i++;
    	} //create parallel list
    	long end = System.currentTimeMillis();
    	System.out.println("Total : " + sum.toString());
    	System.out.println("Took: " + Long.toString((end-start)) + " ms");
	}



}
