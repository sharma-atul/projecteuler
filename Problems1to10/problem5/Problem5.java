package Problems1to10.problem5;

import java.math.BigInteger;

public class Problem5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BigInteger big = new BigInteger("1000000000000");
		for(long i = 1; i < big.longValue(); i++){
			if(i % 10 == 0 &&
					i % 11 == 0 &&
					i % 12 == 0 &&
					i % 13 == 0 &&
					i % 14 == 0 &&
					i % 16 == 0 &&
					i % 17 == 0 &&
					i % 18 == 0 &&
					i % 19 == 0 ){
				System.out.println(i);
				break;
			}
		}
	}

}
