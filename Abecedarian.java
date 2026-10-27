public class Abecedarian{
	
	public static boolean isAbecedarian (String str) {
	if (str.length()<=1) return true;
	for (int i = 1; i < str.length(); i++){
		if (str.charAt(i)<str.charAt(i-1)) return false;
	}
	return true;
	}
	
	public static void main(String[] args) {
	
		System.out.println(isAbecedarian("dehort"));
	
	}
	
}

