package Problems11to20.problem11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Problem11 {
	
	public static int[][] readData(String filename)
	{
		int[][] grid = new int[20][20];
	    try {
	    	BufferedReader br = new BufferedReader(new FileReader(filename));

	    	String line = null;
	    	int l = 0;
	    	while ((line = br.readLine()) != null) {
	    		String[] values = line.split(" ");
	    		int pos = 0;
	    		for (String str : values) {
	    			grid[l][pos] = Integer.parseInt(str);
	    			pos++;
	    		}
	    		l++;
	    	}
	    	br.close();
	    } catch (IOException e) {
	    	// TODO Auto-generated catch block
	    	e.printStackTrace();
	    }
	    return grid;
	}
	public static void main(String[] args) {
		int[][] grid = readData("/Users/chhibba/Documents/workspace/Project_Euler/src/Problems11to20/problem11/file.txt");
		int maxProduct = 0;
		long start = System.currentTimeMillis();
		maxProduct = Math.max(getMaxHorizontal(grid),getMaxVertical(grid));
		maxProduct = Math.max(maxProduct,getMaxDiagonalLtoRUp(grid));
		maxProduct = Math.max(maxProduct,getMaxDiagonalLtoRDown(grid));
		System.out.println("Greatest prodcut : " + maxProduct);
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
	}

	private static int getMaxDiagonalLtoRDown(int[][] grid) {
		int max = 0;
		int product = 0;
		for(int row = 16; row > 0; row--){
			for(int col = 0; col < 17; col++){
				product = grid[row][col] * grid[row+1][col+1] * grid[row+2][col+2] * grid[row+3][col+3];
				max = Math.max(product, max);
			}
		}
		return max;
	}
	
	private static int getMaxDiagonalLtoRUp(int[][] grid) {
		int max = 0;
		int product = 0;
		for(int row = 3; row < 20; row++){
			for(int col = 0; col < 17; col++){
				product = grid[row][col] * grid[row-1][col+1] * grid[row-2][col+2] * grid[row-3][col+3];
				max = Math.max(product, max);
			}
		}
		return max;
	}

	private static int getMaxHorizontal(int[][] grid) {
		int max = 0;
		int product = 0;
		for(int row = 0; row < 20; row++){
			for(int col = 0; col < 17; col++){
				if(col > 0){
					if(grid[row][col-1] > grid[row][col+3])
						continue;
				}
					
				product = grid[row][col] * grid[row][col+1] * grid[row][col+2] * grid[row][col+3];
				max = Math.max(product, max);
			}
		}
		return max;
	}
	
	private static int getMaxVertical(int[][] grid) {
		int max = 0;
		int product = 0;
		for(int col = 0; col < 20; col++){
			for(int row = 0; row < 17; row++){
				if(row > 0){
					if(grid[row-1][col] > grid[row+3][col])
						continue;
				}
				product = grid[row][col]*grid[row+1][col]*grid[row+2][col]*grid[row+3][col];
				max = Math.max(product, max);
			}
		}
		return max;
	}
}


