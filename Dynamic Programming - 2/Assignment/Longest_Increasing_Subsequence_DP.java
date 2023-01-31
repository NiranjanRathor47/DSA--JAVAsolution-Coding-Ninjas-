package Assignment;

import java.util.Scanner;

public class Longest_Increasing_Subsequence_DP {

	 public static int lis(int arr[]) {
		 int storage[] =new int [arr.length];
	      storage[0] = 1;
	      int ans =1;
	      for(int i=1;i<arr.length;i++) {
	    	  int max = 1;
	    	  for(int j=i-1;j>=0;j--) {
	    		  if(arr[j]<arr[i]) {
	    			  int possibleans = storage[j]+1;
	    			  if(possibleans>max) {
		    			  max = possibleans;
		    		  }
	    		  } 
	    	  }
	    	  storage[i] = max;
	    	  if(max>ans) {
	    		  ans = max;
	    	  }
	      }
	      return ans;	 
		 
		 
	/*	 int storage[] = new int [arr.length];
	       storage[0] = 1;
	       for(int i=1;i<arr.length;i++) {
	    	   for(int j=i-1;j>=0;j--) {
	    		   if(arr[i]>arr[j] && storage[i] < storage[j] + 1 ) {
	    			   storage[i] = storage[j] + 1;
	    		   }
	    		   else {
	    			   storage[i] = Math.max(1, storage[i]);
	    		   }
	    	   }
	       }
	
	       int max = 0;
	       for(int i=0;i<arr.length;i++) {
	    	   if(storage[i]>max) {
	    		   max = storage[i];
	    	   }
	       }
	       return max;
	  */
	    }
	 public static void main(String [] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int arr[] = new int [n];
			for(int i=0;i<n;i++) {
				arr[i] = s.nextInt();
			}
			System.out.println(lis(arr));
	 }
}
