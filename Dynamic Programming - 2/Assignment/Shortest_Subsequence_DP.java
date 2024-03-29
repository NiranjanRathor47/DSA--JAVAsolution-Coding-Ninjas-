package Assignment;

import java.util.Scanner;

public class Shortest_Subsequence_DP {

	public static int solve(String S,String V){

		int  m = S.length();
		int n = V.length();
		int[][] storage = new int[m+1][n+1];
		for(int i=0;i<=n;i++) {
			storage[0][i] = Integer.MAX_VALUE; 
		}
		for(int i=0;i<=m;i++) {
			storage[i][0] = 1;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {

				int k = Integer.MAX_VALUE;
				for(int l=j-1;l>=0;l--) {
					if( S.charAt(m-i) == V.charAt(l)) {
						k = l;
						break;
					}
				}
				if(k==Integer.MAX_VALUE) {
					storage[i][j] = 1;
					continue;
				}
				int count1 = storage[i-1][j];
				int count2 = Integer.MAX_VALUE;
				count2 = storage[i-1][k];
				if(count2!=Integer.MAX_VALUE) {
					count2++;
				}
				storage[i][j] = Math.min(count1, count2);

			}
		}
		return storage[m][n];

	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String s = sc.next();
		String v = sc.next();
		System.out.println(solve(s,v));
	}
}
