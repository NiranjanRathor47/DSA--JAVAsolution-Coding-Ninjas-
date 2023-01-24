import java.util.Arrays;
import java.util.Scanner;

public class Knapsack_Memoization {

	public static int knapsackM(int[] weight, int[] value, int n, int maxWeight) {
          int storage[][] = new int [n+1][maxWeight+1];
          for(int []i : storage) {
        	  Arrays.fill(i, -1);;
          }
          return knapsackM(weight,value,n,maxWeight,storage);
    }
	 private static int knapsackM(int[] weight, int[] value, int n, int maxWeight, int[][] storage) {
		 if(maxWeight==0 || n==0) {
			 storage[n][maxWeight] = 0;
			 return storage[n][maxWeight];
		  }
		 if(storage[n][maxWeight]!=-1) {
				return storage[n][maxWeight];
			}
		  if(weight[n-1]>maxWeight) {
			 storage[n][maxWeight] = knapsackM(weight,value,n-1,maxWeight,storage);
			 return storage[n][maxWeight];
		  }
		  else {
			  int otp1 = knapsackM(weight,value,n-1,maxWeight,storage);
			  int otp2 = value[n-1] + knapsackM(weight,value,n-1,maxWeight-weight[n-1],storage);
		     storage[n][maxWeight] = Math.max(otp1, otp2);
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
