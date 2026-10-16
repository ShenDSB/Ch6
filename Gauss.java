public class Gauss{
	
	public static double exp(double a,int b) {
		double c = 1, dev = 1, minu = 1;
		b++;
		for (int i = 1; i != b; i++){
			minu = minu * (a * a);
			dev = dev * i;
			minu = minu / dev;
			if (i % 2 != 0){
				minu = minu * -1;
			}
			else {
			c = c;
			}
			c = c + minu;
		}
		
		return c;
	}
	
	public static void main(String[] args) {
	
		System.out.println(exp(2,2));
		System.out.println(Math.exp(-2*2));
	}
	
}
