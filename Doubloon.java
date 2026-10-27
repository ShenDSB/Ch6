public class Doubloon{
	
	public static String toLowerCase (String str) {
	String a ="";
	for (int i = 0; i < str.length(); i++){
		if (str.charAt(i)<26){
			 a = a+((char) i+26);
		}
		else a = a+str.charAt(i); 
	}
	return a;
	}
	
	public static void main(String[] args) {
	
		System.out.println(toLowerCase("ABCD"));
	
	}
	
}

