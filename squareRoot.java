public class squareRoot{
	
	public static double root(double a) {
		double i = a/2;
		while (!(Math.abs(i*i-a) >= -0.0001 && Math.abs(i*i-a) <= 0.0001)){
			i = (i+(a/i))/2;
		}
		return i;
		
		
	}
	
	public static void main(String[] args) {
	
		System.out.println(root(100));
		
	}
	
}
