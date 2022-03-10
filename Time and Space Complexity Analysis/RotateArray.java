package Assignment;

import java.util.Scanner;

public class RotateArray {
    private static void swapElements(int [] arr ,int start ,int end ) {
        int temp = arr[start];
		arr[start]=arr[end];
		arr[end]=temp;
}
private static void reverse (int [] arr ,int start ,int end) {
while(start<end) {
   swapElements(arr,start,end);
   start ++;
   end --;
}
}
public static void rotate(int[] arr, int d) {
if(arr.length==0) {
	return ;
}
if(d>=arr.length && arr.length!=0) {
	d %= arr.length;
}
reverse(arr,0,arr.length-1);
reverse(arr,0,arr.length-d-1);
reverse(arr,arr.length-d,arr.length-1);
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
public static void print(int arr[]) {
for(int i=0;i<arr.length;i++) {
	System.out.print(arr[i] + " ");
}
System.out.println();
}
public static void main(String[] args) {
 Scanner s = new Scanner(System.in);
	int t = s.nextInt(); 
	while(t>0) {
		int a[] = takeinput();
		int l = s.nextInt();
		rotate(a, l);
 		print(a);
		t--;		
	}		
}
}
