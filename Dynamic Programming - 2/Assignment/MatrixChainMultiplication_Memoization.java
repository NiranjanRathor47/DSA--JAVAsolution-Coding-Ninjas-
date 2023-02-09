package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class MatrixChainMultiplication_Memoization {

	public static int mcm(int []arr) {
		int storage[][] = new int [arr.length+1][arr.length+1];
		for(int[] i : storage) {
			Arrays.fill(i, -1);
		}
		return mcmM(arr,0,arr.length-1,storage);
	}
	public static int mcmM(int[] arr, int si, int ei, int[][] storage) {
		 if(si==ei ||si==ei-1) {
			 storage[si][ei] = 0;
			 return storage[si][ei];
		 }
		 if(storage[si][ei]!=-1) {
			 return storage[si][ei];
		 }
		 int min = Integer.MAX_VALUE;
		 int minIndex = 0;
		 for(int i=si+1;i<ei;i++) {
			 int c = mcmM(arr,si,i,storage) + mcmM(arr,i,ei,storage);
			 if(min>c) {
				 min = c;
				 minIndex = i;
			 }
		 }
		 storage[si][ei] = arr[si]*arr[minIndex]*arr[ei] + min;
		 return  storage[si][ei];
	}
	public static void main(String[] args) {
	   Scanner s = new Scanner (System.in);
	   int n = s.nextInt();
	   int arr[] = new int [n+1];
	   for(int i=0;i<=n;i++) {
		   arr[i] = s.nextInt();
	   }
	   System.out.print(mcm(arr));
	}
}
