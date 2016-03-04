package Problems11to20.problem17;

import java.util.ArrayList;
import java.util.List;

public class Problem17{
	
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = null;
        int sum = 0;
        for(int i = 1; i <= 1000; i ++){
         s = wordify(i);
         sum += s.length();
         System.out.println(s);
        }
        System.out.println("Length of words : " + sum);
    }
	
    private static String wordify (int n){
        StringBuffer result = new StringBuffer();;
        boolean and = (n>100);
        String number = Integer.toString(n);
        List<Integer> digits = new ArrayList<Integer>();
        for(int i = number.length() -1; i >= 0; i--){
            char c= number.charAt(i); 
            int value = Character.getNumericValue(c);
            digits.add(value);
        }
        
        int decimalspot = 0;
        int firstDig = 0;
        for(int dig : digits){
            if(decimalspot == 0)
            {
                result.append(wordifyOne(dig));
                firstDig = dig;
            }
            else if( decimalspot == 1){
                if(dig == 1){
                    result.delete(0, result.length());
                    result.append(wordifyTeen(firstDig));
                }
                else{
                    result.append(wordifyTen(dig));                    
                }
            }
            else if(decimalspot == 2){
                result.append(wordifyHundred(dig));
            }
            else if(decimalspot == 3){
                result.append("onethousand");
            }
            decimalspot++;
        }
        if(and && (n%100 != 0)) {
            result.append("and");
        }
        return result.toString();
    }
 
    private static String wordifyOne(int dig) {
        switch(dig)
        {
            case 0:
                return "";
        case 1:
            return "one";
        case 2:
            return "two";
        case  3:
            return "three";
        
        case 4:
            return "four";
        
        case 5:
            return "five";
        
        case 6:
            return "six";
        
        case 7:
            return "seven";
        
        case 8:
            return "eight";
        
        case 9:
            return "nine";
        }
         return null;
     }
    
    private static String wordifyTeen(int dig) {
        switch(dig)
        {
        case 0:
            return "ten";
        case 1:
            return "eleven";
        case 2:
            return "twelve";
        case 3:
            return "thirteen";
        case 4:
            return "fourteen";
        case 5:
            return "fifteen";
        
        case 6:
            return "sixteen";
        
        case 7:
            return "seventeen";
        
        case 8:
            return "eighteen";
        
        case 9:
            return "nineteen";
        }

        return null;
    }

    private static Object wordifyTen(int dig) {
        switch(dig)
        {
        case 0: return "";
        case 2:
            return "twenty";
                   
        case  3:
            return "thirty";
        
        case 4:
            return "forty";
        
        case 5:
            return "fifty";
        
        case 6:
            return "sixty";
        
        case 7:
            return "seventy";
        
        case 8:
            return "eighty";
        
        case 9:
            return "ninety";
        }

        return null;
    }

    private static Object wordifyHundred(int dig) {
        switch(dig)
        {
            case 0: return "";
        case 1:
            return "onehundred";
        
        case 2:
            return "twohundred";
                   
        case  3:
            return "threehundred";
        
        case 4:
            return "fourhundred";
        
        case 5:
            return "fivehundred";
        
        case 6:
            return "sixhundred";
        
        case 7:
            return "sevenhundred";
        
        case 8:
            return "eighthundred";
        
        case 9:
            return "ninehundred";
        }

        return null;
    }



}
