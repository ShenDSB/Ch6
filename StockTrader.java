import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class StockTrader {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("sbux_2007_2016.txt"));
        String symbol = in.next();
        int n = in.nextInt();
		
        // TODO: create the three arrays, each with n elements
		int[] years = new int[n];
		int[] months = new int[n];
		double[] prices = new double[n];
        // TODO: call loadData, then printData
        loadData(in, years, months, prices);
        printData(years, months, prices);
        int ind_low = indexOfLowest(prices), ind_high = indexOfHighest(prices);
        System.out.println("");
        printlow(years, months, prices, ind_low);
        printhigh(years, months, prices, ind_high);
        System.out.println("");
        double result = simulate(years, months, prices);
		System.out.printf("Final value: $%,.2f%n", result);
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
	
	public static void printlow(int[] years, int[] months, double[] prices, int i){
		System.out.println("lowest: $" + prices[i] + " in " + monthName(months[i]) + " " + years[i]);
	}
	
	public static void printhigh(int[] years, int[] months, double[] prices, int i){
		System.out.println("highest: $" + prices[i] + " in " + monthName(months[i]) + " " + years[i]);
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
	
	public static final double START_CASH = 10000.0;
	public static final double FEE = 10.0;

	public static double simulate(int[] years, int[] months, double[] prices) {
    double cash = START_CASH;
    int shares = 0;
    double boughtAt = 0.0, lastBuy = 0.0;

    for (int i = 0; i < prices.length; i++) {
        double[] history = Arrays.copyOf(prices, i + 1);
        String action = decide(history, shares > 0, boughtAt);
        if (action.equals("BUY") && shares == 0) {
            int canBuy = (int) ((cash - FEE) / prices[i]);
            if (canBuy > 0) {
                shares = canBuy;
                cash = cash - shares * prices[i] - FEE;
                boughtAt = prices[i];
                System.out.printf("%s %d: BUY %d shares at $%.2f%n",
                        monthName(months[i]), years[i], shares, prices[i]);
            }
        } else if (action.equals("SELL") && shares > 0) {
            cash = cash + shares * prices[i] - FEE;
            System.out.printf("%s %d: SELL %d shares at $%.2f%n",
                    monthName(months[i]), years[i], shares, prices[i]);
            shares = 0;
        }
    }
    return cash + shares * prices[prices.length - 1];
}

	public static String decide(double[] his, boolean a, double boughtAt) {
		double avg = 0.0, c = 0.0, b = 0;
		int mon = his.length;
		if (mon < 12) avg = his[0];
		
		else{	
			for (int i = mon-(mon%12); i<his.length; i++){
				//System.out.print(his[i] + " ");
				c += his[i];
				b ++;
			}
			avg = c / b;
			//System.out.println(" c: " + c + " b: " + b + " avg: " + avg);
		}
		//System.out.println("--------------------------");
		//System.out.println(avg + " " + his[his.length-1]);
		
		if (his[his.length-1]<avg*0.9) return "BUY";
		if (his[his.length-1]>boughtAt*1.3) return "SELL";
		else return "Hold";
	}
}
