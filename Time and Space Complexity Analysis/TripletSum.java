package Assignment;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
public class TripletSum {

	public static int tripletSum(int[] arr, int num) {
		 Arrays.sort(arr);
		int count =0 ;
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
				if(num==arr[i]+arr[j]+arr[k]) {
					count++;
				}
			} } }
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
			int res = tripletSum(input,num);
			System.out.print(res);
			t--;
		}

	}
}
