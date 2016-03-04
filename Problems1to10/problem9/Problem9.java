package Problems1to10.problem9;

public class Problem9 {
	
	public static boolean isPythagoreanTriplet(int a, int b, int c)
	{
		if((a*a + b*b) == (c*c))
		{
			return true;
		}

		return false;
	}
	
	public static void main(String[] args) {
		long start = System.currentTimeMillis();
		boolean found = false;
		for(int a = 1; a <= 500 && !found; a++){
			for(int b = a + 1; b <= 500 && !found; b++){
				for(int c = b+1; c <= 500 && !found; c++){
					if(isPythagoreanTriplet(a,b,c))
					{	
						if((a+b+c) == 1000)
						{	
							System.out.println("a=" + a + ",b=" + b + ",c=" + c);
							System.out.println("Product is : " + a*b*c);
							found = true;
						}
					}
				}
			}
		}
		long end = System.currentTimeMillis();
		System.out.println("Took: " + Long.toString(end-start) + "ms");	
	}

}
