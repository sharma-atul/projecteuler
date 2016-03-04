package Problems1to10.problem6;

public class Problem6 {

	private static int squareOfSum(int n)
	{
		int sumOfN = (n*(n+1))/2;
		return (sumOfN)*(sumOfN);
	}
	
	private static int sumOfSquares(int n)
	{
		return (int) ((n/6)*(2*n + 1)*(n+1));
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(squareOfSum(100)-sumOfSquares(100));
	}

}
