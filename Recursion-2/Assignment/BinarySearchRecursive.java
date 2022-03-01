package Assignment;

import java.util.Scanner;

public class BinarySearchRecursive {

	public static int binarySearch(int input[], int element) {
          return binarySearch(input,element,0,input.length-1);
	}
	private static int binarySearch(int input[] , int element , int s,int e) {
		if(s>e) {
			return -1;
		}
		int mid = (s+e)/2;
		if(element==input[mid]) {
			return mid ;
		}
		else if(element<input[mid]) {
			return binarySearch(input,element,s,mid-1);
		}
		return binarySearch(input,element,mid+1,e);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		int element = s.nextInt();
		int res = binarySearch(arr,element);
		System.out.println(res);
	}

}
