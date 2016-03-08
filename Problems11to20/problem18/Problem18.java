package Problems11to20.problem18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem18
{
    public static void main(String ...args)
    {
    	List<List<String>> listOfList = new ArrayList<>();
    	int[][] array = new int[15][15]; 
    	String triangle ="75"
    					+",95 64"
    					+",17 47 82"
    					+",18 35 87 10"
    					+",20 04 82 47 65"
    					+",19 01 23 75 03 34"
    					+",88 02 77 73 07 63 67"
    					+",99 65 04 28 06 16 70 92"
    					+",41 41 26 56 83 40 80 70 33"
    					+",41 48 72 33 47 32 37 16 94 29"
    					+",53 71 44 65 25 43 91 52 97 51 14"
    					+",70 11 33 28 77 73 17 78 39 68 17 57"
    					+",91 71 52 38 17 14 91 43 58 50 27 29 48"
    					+",63 66 04 68 89 53 67 30 73 16 69 87 40 31"
    					+",04 62 98 27 23 09 70 98 73 93 38 53 60 04 23";

    	List<String> rows = Arrays.asList(triangle.split(","));
    	for (String s : rows)
    	{
    		listOfList.add(Arrays.asList(s.split(" ")));
    	}

    	int row = 0;
    	for(List<String> listArRow: listOfList)
    	{
    		for(int col = 0; col < listArRow.size(); col++)
    		{
    			array[row][col] = Integer.parseInt(listArRow.get(col));
    		}
    		row++;
    	} 

    	long start = System.nanoTime();

    	int pos1 = 0;
    	int pos2 = 0;

    	for (int i = array.length - 1; i >= 0; i--) {
    		for (int j = 0; j < i; j++) {

    			pos1 = array[i][j] + array[i - 1][j];
    			pos2 = array[i][j + 1] + array[i - 1][j];

    			if (pos1 > pos2) {
    				array[i - 1][j] = pos1;

    			} else {
    				array[i - 1][j] = pos2;

    			}
    		}
    	}
    	long end = System.nanoTime();
    	System.out.println("Maximum Path Sum : " + array[0][0]);
    	System.out.println("Took: " + Long.toString((end-start)/1000) + " microseconds");
    }

}
