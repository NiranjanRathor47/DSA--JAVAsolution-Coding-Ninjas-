package Assignment;

import java.util.Scanner;

public class CheckArrayRotation {
	 public static int arrayRotateCheck(int[] arr){
	    	int max = Integer.MIN_VALUE;
	    	int count=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]>max) {
					max = arr[i];
					count++;
				}
			}
			if(count!=arr.length) {
			
				return count;
			}
		return 0;
	    }
	    public static int[] takeinput() {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt(); 
			int arr[]= new int [n];
			for(int i=0;i<n;i++) {
				arr[i]= s.nextInt();
			}
			return arr;
		}	
		public static void main(String[] args) {
			 Scanner s = new Scanner(System.in);
				int t = s.nextInt(); 
				while(t>0) {
					int a[] = takeinput();
					int res = arrayRotateCheck(a);
					System.out.println(res);
					t--;		
				}
		} 
}
