package Problems1to10.problem1;

public class Problem1 {
	
	private static int isDivisible3or5(int a){
		if ((a % 3 == 0) || (a % 5 == 0))
		{
			return a;
		}
		return 0;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int solution = 0;
		for(int i = 1; i < 1000; i++){
			solution += isDivisible3or5(i);
		}
		System.out.println(solution);
	}
}
