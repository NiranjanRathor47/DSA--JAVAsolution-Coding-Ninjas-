package Assignment;

import java.util.Scanner;

public class MatrixChainMultiplication_DP {

	public static int mcm(int[] p){
	  int n = p.length;
	  int storage[][] = new int [n][n];
	  for(int L =2;L<n;L++) {
		  for(int start =1;start<n-L+1;start++) {
			  int end = start+L-1;
			  if(end==n)
				  break ; 
			  storage[start][end] = Integer.MAX_VALUE;
			  for(int k=start;k<=end-1;k++) {
				  int cost = storage[start][k] + storage[k+1][end] + p[start-1]*p[k]*p[end];
				  if(storage[start][end]>cost) {
					  storage[start][end] = cost;
				  }
			  }
		  }
	  }
	  return storage[1][n-1];
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
/*
  int  n = p.length;
	    int[][] storage = new int[p.length][p.length];
	    for(int i =n-1;i>=0;i--) {
	        for(int j=0;j<n;j++) {
	            if( i +1 < j ) {
	                int min = Integer.MAX_VALUE;
	                int minIndex = 0;
	                for(int k=i+1;k<j;k++) {
	                    int c = storage[i][k] + storage[k][j] + p[i] * p[k] * p[j] ;
	                    if(c < min) {
	                        min = c;
	                        minIndex = k;
	                    }
	                }
	                storage[i][j] = min ;
	            }
	        }
	    }
	    return storage[0][n-1];
*/