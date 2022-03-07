package Assignment;

import java.util.Scanner;

public class DuplicateArray {

	public static int findDuplicate(int[] arr) {
//		int count = 0 ;
//		for(int i=0;i<arr.length;i++) {
//			for(int j=i;j<arr.length-1;j++) {
//				if(arr[i]==arr[j+1]) {
//					count++;
//				}
//			}
//			if(count==1) {
//				return arr[i];
//			}
//			count=0;
//		}
//		return -1 ; // O(n^2)
		 int n = arr.length;
	        int sum = 0;
	        for(int i =0; i<arr.length; i++){
	            sum += arr[i];
	        }
	        return (sum - (n-2)*(n-1)/2);
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
				int res = findDuplicate(input);
				System.out.println(res);
				t--;
			}
			

		}

}
