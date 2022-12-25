import java.util.ArrayList;
import java.util.Scanner;
import java.util.HashMap;

public class MaximumFrequencyNumber {

	 public static int maxFrequencyNumber(int[] arr){
			
		 HashMap<Integer,Integer> h = new HashMap<>();
		 for(int i=0;i<arr.length;i++) {
			 if(h.containsKey(arr[i])) {
				 h.put(arr[i], h.get(arr[i])+1);
			 }
			 else {
				 h.put(arr[i], 1);
			 }
		 }
		 int max = 0;
		 int maxkey =0;
		 
		 for(int i=0;i<arr.length;i++) {
			 if(h.get(arr[i])>max) {
				 max = h.get(arr[i]);
				 maxkey = arr[i];
			 }
		 }
		 
		return maxkey;	 
		 
	    }
	 public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int a [] = new int[n];
			for(int i =0;i<a.length;i++) {
				a[i] = s.nextInt();
			}
			int ans = maxFrequencyNumber(a);
				System.out.print(ans);
				
	 }		
}

