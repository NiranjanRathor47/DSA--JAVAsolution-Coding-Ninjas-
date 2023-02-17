package Assignment;

import java.util.Scanner;

public class Ways_ToMakeCoinChange_Recursion {

	public static int countWaysToMakeChange(int[] arr, int v) {
		return help(arr,arr.length,v);
	}
	public static int help(int [] arr,int m,int v) {
		if(v==0) {
			return 1;
		}
		if(v<0) {
			return 0;
		}
		if(m<=0 && v>=1) {
			return 0;
		}
		return help(arr,m-1,v) +  help(arr,m,v-arr[m-1]);
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		int v = s.nextInt();
		System.out.println(countWaysToMakeChange(arr,v));
 }

}

