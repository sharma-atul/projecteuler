package Problems11to20.problem16;

import java.math.BigInteger;
public class Problem16{
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        BigInteger n = new BigInteger("2").pow(1000);
        BigInteger sum = new BigInteger("0");
        String str = n.toString();
        for(int i=0; i<str.length(); i++)
        {
          char c= str.charAt(i); 

          int value = Character.getNumericValue(c);
          BigInteger value2 = new BigInteger(Integer.toString(value));
           sum =sum.add(value2) ; 
        }
      System.out.println(sum);
    }
}
