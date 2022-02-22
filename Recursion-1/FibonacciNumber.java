import java.util.Scanner;

public class FibonacciNumber {
	public static int fib(int n) {
		  if(n==0 || n==1) {
			  return n;
		  }
		  return fib(n-1)+fib(n-2);
	  }
		public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int n = s.nextInt();
	        
	        int ans = fib(n);
	        System.out.print(ans);

		}
}
