import java.util.Scanner;

public class RecursionAndPMI {
	public static int sum(int n) {
		  if(n==1) {
			  return 1;
		  }
		  return n+sum(n-1) ;
	  }
		public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        
	        int ans = sum(n);
	        System.out.print(ans);

		}
}
