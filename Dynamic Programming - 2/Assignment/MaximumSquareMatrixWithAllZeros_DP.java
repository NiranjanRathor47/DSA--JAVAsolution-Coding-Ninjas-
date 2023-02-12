package Assignment;

import java.util.Scanner;

public class MaximumSquareMatrixWithAllZeros_DP {

	public static int findMaxSquareWithAllZeros(int[][] input){
		 if(input.length==0 || input[0].length==0){
	            return 0;
	        }
		int m = input.length;
		int n = input[0].length;
		int storage[][] = new int [m][n];
		int max = Integer.MIN_VALUE;
		for(int i=0;i<m;i++) {
			storage[i][0] = input[i][0]==0 ? 1 : 0;
			max = Math.max(storage[i][0], max);
		}
		for(int j=0;j<n;j++) {
			storage[0][j] = input[0][j]==0 ? 1 : 0;
			max = Math.max(storage[0][j], max);
		}
		for(int i=1;i<m;i++) {
			for(int j=1;j<n;j++) {
				if(input[i][j]==1) {
					storage[i][j] = 0;
				}
				else {
					storage[i][j] = 1 + Math.min(Math.min(storage[i-1][j-1], storage[i-1][j]),storage[i][j-1]);
				}
				max = Math.max(storage[i][j], max);
			}
		}
		return max;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt();
		int n = s.nextInt();
		int arr[][] = new int [m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				arr[i][j] = s.nextInt();
			}
		}
		System.out.print(findMaxSquareWithAllZeros(arr));
	}
}
