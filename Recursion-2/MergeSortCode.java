import java.util.Scanner;

public class MergeSortCode {

	public static void mergeSort(int[] input){
		mergesort(input,0,input.length-1);
	}
	private static void mergesort(int[] input ,int si,int ei) {
		if(si>=ei) {
			return ;
		}
		int mid = (si + ei )/2;
		mergesort(input,si,mid);
		mergesort(input,mid+1,ei);
		merge(input,si,ei);
	}
	private static void merge(int[] input ,int si,int ei) {
		int mid = (si + ei )/2;
		
		int [] ans = new int [ei-si+1];
		int i = si;
		int j = mid +1 ;
		int k =0;
		while (i<=mid && j<=ei) {
			if(input[i]<input[j]){
				ans[k]=input[i];
				i++;
				k++;
			}
			else {
				ans[k]=input[j];
				k++;
				j++;
			}
		}
		while(i<=mid) {
			ans[k] = input[i];
			i++;
			k++;
		}
		while(j<=ei) {
			ans[k] = input[j];
			k++;
			j++;
		}
		for(int q=0;q<ans.length;q++) {
			input[si+ q] = ans[q];
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		mergeSort(arr);
		for(int i=0;i<n;i++) {
			System.out.print(arr[i] + " ");
		}
		 System.out.println();
	}

}
