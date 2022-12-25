import java.util.Scanner;
import java.util.*;

public class PairSumTo0 {

   public static int PairSum(int[] input, int size) {
	   if(size==0) {
		   return 0;
	   }
		int sum =0;
		HashMap<Integer,Integer> s = new HashMap<>();
		for(int i=0;i<size;i++) {
			if(s.containsKey(-input[i]) && s.get(-input[i])!=0) {
		          sum = sum + s.get(-input[i]);
				}
			if(s.containsKey(input[i])) {
				s.put(input[i], s.get(input[i])+1);
			}
			else {
				s.put(input[i], 1);
//				if(s.containsKey(-input[i])) {
//		          sum = sum + s.get(-input[i]);
//				}
			}
		}
		return sum;
	}

	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int a [] = new int[n];
			for(int i =0;i<a.length;i++) {
				a[i] = s.nextInt();
			}
			int res = PairSum(a,n);	
			System.out.println(res);
	 }		
}
