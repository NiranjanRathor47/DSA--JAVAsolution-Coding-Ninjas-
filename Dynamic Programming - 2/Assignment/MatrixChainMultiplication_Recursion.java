package Assignment;

import java.util.Scanner;

public class MatrixChainMultiplication_Recursion {

    public static int mcm(int[] p) {
		return mcm(p,0,p.length-1);		
	 }
	 private static int mcm(int[] p,int si,int ei) {
		 if(si>=ei || si>=ei-1) {
				return 0;
			}
			int min = Integer.MAX_VALUE;
			int minIndex = 0;
			for(int i=si+1;i<ei;i++) {
				int c  = mcm(p, si, i) + mcm(p, i, ei);
				if(min > c) {
					min = c;
					minIndex = i;
				}
			}
			return p[si] * p[ei] * p[minIndex] + min;
	 }
    public static void main(String[] args) {	
		Scanner s = new Scanner(System.in);
	
		int n = s.nextInt();
		int p[] = new int[n + 1];
		for(int i = 0; i <= n; i++){
			p[i] = s.nextInt();
		}
		System.out.println(mcm(p));
	}
}
