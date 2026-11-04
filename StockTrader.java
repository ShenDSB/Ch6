import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StockTrader {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("tiny.txt"));
        String symbol = in.next();
        int n = in.nextInt();
		
        // TODO: create the three arrays, each with n elements
		int[] years = new int[n];
		int[] months = new int[n];
		double[] prices = new double[n];
        // TODO: call loadData, then printData
        loadData(in, years, months, prices);
        printData(years, months, prices);
        System.out.println(indexOfLowest(prices));
        System.out.println(indexOfHighest(prices));
    }
    
    public static void loadData(Scanner in, int[] years, int[] months, double[] prices){
		for (int i = 0; i < years.length; i++){
			years[i]= in.nextInt();
			months[i]= in.nextInt();
			prices[i]= in.nextDouble();
		}
		
	}
	
	public static String monthName(int month){
		String[] m = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
		return m[month-1];
	}
	
	public static void printData(int[] years, int[] months, double[] prices){
		for (int i = 0; i < years.length; i++){
			System.out.println(years[i]+ ": " + monthName(months[i])+ ", " + prices[i]);
			
		}
	}
	
	public static int indexOfLowest(double[] prices) {
		double lp = prices[0];
		int index = 0;
		for (int i = 0; i<prices.length; i++){
			if(prices[i]<lp) {
				lp = prices[i];  
				index = i;
			}
		}
		return index;
	}
	
	public static int indexOfHighest(double[] prices) {
		double lp = prices[0];
		int index = 0;
		for (int i = 0; i<prices.length; i++){
			if(prices[i]>lp) {
				lp = prices[i];  
				index = i;
			}
		}
		return index;
	}
}
