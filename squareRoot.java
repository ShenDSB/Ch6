public class squareRoot{
	
	public static double root(double a) {
		double i = a/2;
		while (a != i*i){
			i = (i+(a/i))/2;
		}
		return i;
		
		
	}
	
	public static void main(String[] args) {
	
		System.out.println(root(9.0));
		
	}
	
}
