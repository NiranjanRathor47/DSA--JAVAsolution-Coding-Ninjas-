import java.util.Scanner;

public class MinimumCostPath_Recursion {

	public static int minCostPath(int [][] input,int x,int y) {
		int m =input.length;
		int n = input[0].length;
		if(x==m-1 && y==n-1) {
			return input[x][y];
		}
		if(x>=m || y>=n) {
			return Integer.MAX_VALUE;
		}
		int count1 = minCostPath(input,x+1,y);
		int count2 = minCostPath(input,x+1,y+1);
		int count3 = minCostPath(input,x,y+1);
		
		return input[x][y] + Math.min(Math.min(count1, count2),count3); 
	}
    public static int minCostPath(int[][] input) {
		return minCostPath(input,0,0);
	}

    public static void main(String []args) {
    	Scanner s = new Scanner (System.in);
    	int m = s.nextInt();
    	int n = s.nextInt();
    	int arr[][] = new int [m][n];
    	for(int i=0;i<m;i++) {
    		for(int j=0;j<n;j++) {
    			arr[i][j] = s.nextInt();
    		}
    	}
    	System.out.println(minCostPath(arr));
    }
}
