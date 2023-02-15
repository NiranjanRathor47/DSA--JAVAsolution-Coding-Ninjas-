package Assignment;

import java.util.Scanner;

public class Shortest_Subsequence_Recursion {

   public static int solve(String S,String V){
		
		if(S.length() == 0) {
			return Integer.MAX_VALUE;
		}
		if(V.length()==0)
			return 1;
		int k=Integer.MAX_VALUE;
		for(int i=0;i<V.length();i++) {
			if( V.charAt(i) == S.charAt(0) ) {
				k = i;
				break;
			}
		}
		if(k==Integer.MAX_VALUE) {
			return 1;
		}
		
		int count1 = solve(S.substring(1), V);
		int count2 = solve(S.substring(1), V.substring(k+ 1));
		if(count2!=Integer.MAX_VALUE) {
			count2++;
		}
		return Math.min(count1, count2);
		
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String v = sc.next();
		System.out.println( solve(s,v));
	}
}
