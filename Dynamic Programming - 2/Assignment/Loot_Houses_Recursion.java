package Assignment;

import java.util.Scanner;

public class Loot_Houses_Recursion {

 // Recursion
  public static int getMaxMoney(int arr[], int i){	
	      if(i>=arr.length) {
			 return 0; 
		  }
		  return Math.max(arr[i] + getMaxMoney(arr,i+2), getMaxMoney(arr,i+1));
	}
	public static int maxMoneyLooted(int[] houses) {
		return getMaxMoney(houses,0);
	}  
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.print(maxMoneyLooted(arr));
	}
}
