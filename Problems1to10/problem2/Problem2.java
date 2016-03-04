package Problems1to10.problem2;

public class Problem2 {

	static long fib (int n) {
        if(n == 1 || n == 2){
            return 1;
        }
        long fibo1=1, fibo2=1, fibonacci=1;
        for(int i= 3; i<= n; i++){
           
            //Fibonacci number is sum of previous two Fibonacci number
            fibonacci = fibo1 + fibo2;             
            fibo1 = fibo2;
            fibo2 = fibonacci;
          
        }
        return fibonacci; //Fibonacci number        
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 2;
		long solution = 0;
		long result = 0;
		do{
			result = fib(i);
			if(result % 2 == 0){
				solution += result;
			}
			result = fib(++i);
		}while (result < 4000000);
		
		System.out.println(solution);
	}

}
