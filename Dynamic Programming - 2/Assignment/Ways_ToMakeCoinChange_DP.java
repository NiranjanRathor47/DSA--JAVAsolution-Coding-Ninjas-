package Assignment;

import java.util.Scanner;

public class Ways_ToMakeCoinChange_DP {

	public static int countWaysToMakeChangeDP(int denominations[], int value){
         int n = denominations.length;
         int storage[][] = new int [n+1][value+1];
         for(int i=1;i<n;i++) {
        	 storage[i][0] = 1; 
         }
         for(int i=1;i<storage.length;i++) {
        	 for(int j=1;j<storage[0].length;j++) {
        		 if(denominations[i-1]<=j) {
        			 storage[i][j] = storage[i-1][j] + storage[i][j-denominations[i-1]];
        		 }
        		 else {
        			 storage[i][j] = storage[i-1][j];
        		 }
        	 }
         }
         return storage[n][value];
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		int v = s.nextInt();
		System.out.println(countWaysToMakeChangeDP(arr,v));
 }
}