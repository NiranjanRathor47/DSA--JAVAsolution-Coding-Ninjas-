import java.util.Scanner;

public class CheckSort_2 {

	public static boolean checksortBetter (int input [] ,int n) {
		if(n>=input.length) {
			return true ;
		}
		if(input[n]>input[n+1]) {
			return false;
		}
		boolean smallans = checksortBetter(input , n+1);
		return smallans ;
	}
  
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
  		System.out.println(checksortBetter(arr,n));

  	}
}
