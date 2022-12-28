package Assignment;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class PairsWithDifference_K {

	public static int getPairsWithDifferenceK(int arr[], int k) {
		int count =0;
	      HashMap<Integer,Integer> s = new HashMap<>();
	      for(int i=0;i<arr.length;i++) {
	    	  if(s.containsKey(arr[i])) {
	    		  s.put(arr[i], s.get(arr[i])+1);
	    	  }
	    	  else {
	    			s.put(arr[i], 1);
	    		}
	      }
	      if(k==0) {
	    	  for(int i=0;i<arr.length;i++) {
	    	  int freq=s.get(arr[i]);
		    	if(freq>1) {
		    		for(int j=0;j<(freq*(freq-1))/2;j++) {
		    			count++;
		    		}
		    	}
		    	 s.put(arr[i],0);
		      }
	    	  return count;
	      }
	      else {
	    	  for(int i=0;i<arr.length;i++){
	    	  if(s.containsKey(arr[i]+k)) {
	    	       int freq1 = s.get(arr[i]);
	    	       int freq2 = s.get(arr[i]+k);
	    	       for(int j=0;j<freq1*freq2;j++) {
	    	    	    count++;
	    	    	}
	    	  }
	    	  if(s.containsKey(arr[i]-k)) {
	    	       int freq1 = s.get(arr[i]);
	    	       int freq2 = s.get(arr[i]-k);
	    	       for(int j=0;j<freq1*freq2;j++) {
	    	    	    count++;
	    	    	}
	    	  }
	    	  s.put(arr[i],0);
	    	  }
	    	  }
	      return count;
	}
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int a [] = new int[n];
			for(int i =0;i<a.length;i++) {
				a[i] = s.nextInt();
			}
			int k =s.nextInt();
			int res = getPairsWithDifferenceK(a,k);	
			System.out.println(res);
	 }		
}      
