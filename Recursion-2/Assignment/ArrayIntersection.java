package Assignment;

import java.util.Scanner;
import java.util.*;
public class ArrayIntersection {

	 public static void intersection(int[] arr1, int[] arr2){
	        Arrays.sort(arr1);
	        Arrays.sort(arr2);
	        merge(arr1,arr2);

	        }
	     private static void merge(int arr1[] ,int arr2[]){
	        int i=0,j=0;

	        while(i<arr1.length && j<arr2.length){
	            if(arr1[i] == arr2[j]){
	                System.out.println(arr1[i]);
	                i++;
	                j++;
	            }else if(arr1[i] < arr2[j]){
	                i++;
	            }else{
	                j++;
	            }
	        }

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
			int[] input1 = takeInput();
			intersection(input,input1);
			t--;
		}

	}
}
