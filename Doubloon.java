public class Doubloon{
	
	public static String toLowerCase (String str) {
	String a ="", alpha = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
	int b = 0;
	for (int i = 0; i < str.length(); i++){
		b = alpha.indexOf(str.charAt(i));
		if (b<=26){
			 a = a+(alpha.charAt(b+26));
		}
		else a = a+str.charAt(i); 
	}
	return a;
	}
	
	public static boolean toDoubloon (String str) {
	String superem = "";
	int a = 0;
	for (int i = 0; i < str.length(); i++){

			if (superem.contains(""+str.charAt(i))){
				a = superem.indexOf(str.charAt(i));
				superem = superem.substring(0,a)+superem.substring(a+1);
			}
			else superem = superem + str.charAt(i); 
		}
		if (superem.equals("")) return true; 
		else return false;
	}
	
	public static void main(String[] args) {
		String doubloon = toLowerCase("HorseShoEr");
		System.out.println(doubloon);
		boolean isdoubloon = toDoubloon("horseshoer");
		System.out.println(isdoubloon);
	}
	
}
