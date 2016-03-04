package Problems11to20.problem14;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

import util.Util;

public class Problem14 {

	public static int collatzSequence(int n,Map<BigInteger,Integer> map)
	{
		//int left = n;
		BigInteger left = new BigInteger(Integer.toString(n));
		int seqLength = 1;
		BigInteger two = BigInteger.ONE.add(BigInteger.ONE);
		BigInteger three = BigInteger.ONE.add(BigInteger.ONE);
		three = two.add(BigInteger.ONE);

		while (!left.equals(BigInteger.ONE) ){
			if(!(left.mod(two)).equals(BigInteger.ONE)){
				left = left.divide(two);
			}
			else{ 
				left = (left.multiply(three)).add(BigInteger.ONE);
			}
			
			if(map.containsKey(left))
			{
				return (seqLength + map.get(left));
			}
			else
			{
				seqLength++;
			}
		}
		return seqLength;
	}
	
	public static void main(String[] args) {
        if(!Util.validArgsLength(args,1)) System.exit(0);
        
        int n =  Integer.parseInt(args[0]);
        Map<BigInteger,Integer> map = new HashMap<BigInteger,Integer>();
        map.put(new BigInteger("40"),9);
        map.put(new BigInteger("20"), 8);
        map.put(new BigInteger("160"), 11);
        map.put(new BigInteger("10"), 7);
        //Start
		long start = System.currentTimeMillis();
		int longestInt = 13;
		int longestChainLength = 10;
		int result = 0;
		for(int i = 14; i < n;i++){
			result = collatzSequence(i,map);
			if(result > longestChainLength){
				System.out.println("new length" + "("+i+")=" + result + " from"+ "("+longestInt+")=" + longestChainLength);		
				longestChainLength = result;
				longestInt = i;
			}
			else if(map.size() < 50000)
				map.put(new BigInteger(Integer.toString(i)),result);
		}		
		//End
		System.out.println("Longest Collatz : " + longestInt +" with length:" + longestChainLength);
		System.out.println("Map size : " + map.size());
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	

	}

}
