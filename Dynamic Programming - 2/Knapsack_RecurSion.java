import java.util.Scanner;

public class Knapsack_RecurSion {

	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
	  if(maxWeight==0 || n==0) {
		  return 0;
	  }
	  if(weights[n-1]>maxWeight) {
		  return knapsack(weights,values,n-1,maxWeight);
	  }
	  else {
		  int otp1 = knapsack(weights,values,n-1,maxWeight);
		  int otp2 = values[n-1] + knapsack(weights,values,n-1,maxWeight-weights[n-1]);
	     return Math.max(otp1, otp2);
	  }
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
			System.out.println(knapsack(weight, value,n, maxWeight));
		}	
}
