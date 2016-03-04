package Problems21to30.problem21;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

import util.Util;

public class Problem21 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = Integer.parseInt(args[0]);
        if(!Util.validArgsLength(args,1)) System.exit(0);
        
		List<Integer> candidates = new ArrayList<Integer>();
		//Map<Integer,Integer> dict = new HashMap<Integer,Integer>();
		int dOfI = 0;
		int amicable = 0;
		int total = 0;

		for(int j = 1; j<=n; j++){
			candidates.add(j);
		}
		Collections.sort(candidates);
		
		long start = System.currentTimeMillis();
		PriorityQueue<Integer> alreadyAdded = new PriorityQueue<Integer>();
		
		for(int i : candidates)
		{
			if(alreadyAdded.contains(i)) continue;
			
			dOfI = Util.findSumOfDivisors(i);
			amicable = Util.findSumOfDivisors(dOfI);
			if(i == amicable && i != dOfI){
				total = total + (i + dOfI);
				alreadyAdded.add(dOfI);
			}

			
		}
		long end = System.currentTimeMillis();
				
		System.out.println("Sum of amicable numbers upto " + n);
		System.out.println(total);
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
	}

}
