import java.util.Scanner;

public class CalculatePower {

	public static int power(int x, int n) {
	       if(n==0) {
			  return 1;
		  }
		  int smallans = power(x,n-1);
		  return x*smallans ;
	}
 	public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
         int x = s.nextInt();
	         int n = s.nextInt();
         
	        int ans = power(x,n);
	        System.out.print(ans);

		}

}
