package Problems61to70.problem67;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem67 {
    
	public static String readData(String filename)
	{
		StringBuffer triangle = new StringBuffer();
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));

	    	String line = null;
	    	int l = 0;
	    	while ((line = br.readLine()) != null) {
	    		if(l == 0)
	    			triangle.append(line);
	    		else
	    			triangle.append(","+line);
	    		l++;
	    	}
	    	br.close();
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    return triangle.toString();
	}
    
    public static void main(String[] args) {
    	String triangle = readData("/Users/chhibba/Documents/workspace/Project_Euler/src"+
    								"/Problems61to70/problem67/p067_triangle.txt");
    	List<List<String>> listOfList = new ArrayList<>();
    	int[][] array = new int[100][100]; 
    	

    	List<String> rows = Arrays.asList(triangle.split(","));
    	for (String s : rows)
    	{
    		listOfList.add(Arrays.asList(s.split(" ")));
    	}
    	//take the string of triangle and put into int[][]
    	int row = 0;
    	for(List<String> listArRow: listOfList)
    	{
    		for(int col = 0; col < listArRow.size(); col++)
    		{
    			array[row][col] = Integer.parseInt(listArRow.get(col));
    		}
    		row++;
    	} 
    	
    	//start
    	long start = System.nanoTime();

    	int possibility1 = 0;  //up and above
    	int possibility2 = 0; //up and to the right
    	
    	//start at bottom and work way up
    	for (int i = array.length - 1; i >= 0; i--) {
    		for (int j = 0; j < i; j++) {

    			possibility1 = array[i][j] + array[i - 1][j];
    			possibility2 = array[i][j + 1] + array[i - 1][j];

    			if (possibility1 > possibility2) {
    				array[i - 1][j] = possibility1;

    			} else {
    				array[i - 1][j] = possibility2;
    			}
    		}
    	}
    	long end = System.nanoTime();
    	System.out.println("Maximum Path Sum : " + array[0][0]);
    	System.out.println("Took: " + Long.toString((end-start)/1000) + " microseconds");
    }
}
