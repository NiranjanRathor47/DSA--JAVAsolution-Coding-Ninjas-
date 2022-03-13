import java.util.*;
import java.util.Scanner;
public class MaximumProfitOnApp {
	public static int maximumProfit(int budget[]) {
		int n= budget.length;
		int [] b=new int[n];
		Arrays.sort(budget);
		int j=0;
		int m=n;
		while(j<n)
		{
		    b[j]=budget[j]*m;
		    j++;
		    m--;
		}
		Arrays.sort(b);
		 return b[n-1] ;
	}
//	public static int maximumProfit(int budget[]) {
//		int n = budget.length ;
//		Arrays.sort(budget);
//		int ans , ans1 =0;
//		for(int i=0;i<n;i++) {
//			ans = budget[i]*n;
//			if(ans>ans1) {
//				ans1 = ans ;
//			}
//			n=n-1;
//		}
//      return ans1;
//	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		
		int res = maximumProfit(arr);
		System.out.println(res);
	}

}
