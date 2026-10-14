public class expGrowth{
	
	public static double exp(double a,int b) {
		double c = 0, d = 1, e;
		for (int i = 1; i != b; i++){
			c = c + (a*a);
			d = d * i;
			c = c / d;
			if (i % 2 != 0){
				c/=-1;
			}
			else {
			c = c;
			}
			
		}
		
		return c;
	}
	
	public static void main(String[] args) {
	
		System.out.println(exp(3,4));
		
	}
	
}
