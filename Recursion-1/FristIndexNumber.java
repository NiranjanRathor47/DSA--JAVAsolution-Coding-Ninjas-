import java.util.Scanner;

public class FristIndexNumber {
	
 public static int firstIndex(int input[], int x) {
		return firstIndex(input,x,0);
	}
 private static int firstIndex(int input[],int x,int i) {
	 if(i==input.length) {
		 return -1 ;
	 }
	 if(input[i]==x) {
		 return i;
	 }
	 int ans = firstIndex(input ,x,i+1);
	 if(ans>0) {
		 return ans ;
	 }
	
	 return -1 ;
 }
 public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		int x = s.nextInt(); 
		System.out.println(firstIndex(arr, x));

	}
}
