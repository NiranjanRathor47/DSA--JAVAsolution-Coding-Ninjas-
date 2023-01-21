import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_DP {

	public static int knapsackM(int[] weight, int[] value, int n, int maxWeight) {
        int storage[][] = new int [n+1][maxWeight+1];
        for(int i=1;i<=n;i++) {
			for(int j=1;j<=maxWeight;j++) {
			    if(weight[i-1]>j) {
			    	storage[i][j] = storage[i-1][j];
			    }
			    else {
			    	storage[i][j] = Math.max(storage[i-1][j], storage[i-1][ j - weight[i-1] ] + value[i-1] );
			    }
			}
			}
        return storage[n][maxWeight];
  }
	public static void main (String [] args) {
		 Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int weight[] = new int[n];
			for(int i = 0 ; i < n; i++){
				weight[i] = s.nextInt();
			}
			int value[] = new int[n];
			for(int i = 0 ; i < n; i++){
				value[i] = s.nextInt();
			}
			int maxWeight = s.nextInt();
			System.out.println(knapsackM(weight, value,n, maxWeight));
		}	
}
