package Problems1to10.problem4;

public class Problem4 {

	private static boolean isPalindrome(int number)
	{
		int palindrome = number;
        int reverse = 0;

        while (palindrome != 0) {
            int remainder = palindrome % 10;
            reverse = reverse * 10 + remainder;
            palindrome = palindrome / 10;
        }

        if (number == reverse) {
            return true;
        }
        return false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int solution = 0;
		int product = 0;
		for(int x = 999; x >=100; x--){
			for(int y = x; y>= 100; y--){
				product = x*y;
				if(product < solution) break;
				if(isPalindrome(product))
				{
					if(product > solution) solution = product;
				}
			}
		}
		System.out.println(solution);
	}

}
