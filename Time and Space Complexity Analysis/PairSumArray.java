package Assignment;

import java.util.Scanner;

public class PairSumArray {

	public static int pairSum(int[] arr, int num) {
		int count =0 ;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				if(num==arr[i]+arr[j]) {
					count++;
				}
			} }
		return count ;
	}
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		while(t>0) {
			int[] input = takeInput();
			int num  = s.nextInt();
			int res = pairSum(input,num);
			System.out.print(res);
			t--;
		}

	}
}
