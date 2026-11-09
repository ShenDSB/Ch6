public class Scrabble{
	public static void main (String[] args){
		String tiles = "apsjfdowegiokosndiqwas", word = "aspas";
		System.out.println(Scrab(tiles,word));
	}
	public static boolean Scrab (String tiles, String word){
		int a = 0;
		for (int i = 0; i < tiles.length(); i++){
			
			if (word.contains(""+tiles.charAt(i))){
				a = word.indexOf(tiles.charAt(i));
				word = word.substring(0,a)+word.substring(a+1);
			}
		}
		if (word.equals("")) return true; 
		else return false;
	}
}
