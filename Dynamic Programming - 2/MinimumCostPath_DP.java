import java.util.Scanner;

public class MinimumCostPath_DP {
	
	public  static int minCostPathDP(int arr[][]){
		int m = arr.length;
		int n = arr[0].length;
		int storage[][] = new int[m][n];
		
		storage[m - 1][n - 1] = arr[m - 1][n - 1];
		// Last Row
		for(int j = n - 2; j >= 0; j--){
			storage[m - 1][j] = storage[m - 1][j + 1] + arr[m - 1][j];
		}
		// Last Column
		for(int i = m - 2; i >= 0; i--){
			storage[i][n - 1] = storage[i + 1][n - 1] + arr[i][n - 1];
		}
		
		for(int i = m - 2; i >= 0; i--){
			for(int j = n - 2; j >= 0; j--){
				storage[i][j] = arr[i][j] +  Math.min(storage[i][j + 1], 
						Math.min(storage[i + 1][j + 1], storage[i + 1][j]));
			}
		}
		return storage[0][0];
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
		    	System.out.println(minCostPathDP(arr));
		    }
}
