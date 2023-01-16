import java.util.Scanner;

public class NumberOfBalancedBTs_Recursion {

	 // h-1 || h-1
    // h-1 || h-2
    // h-2 || h-3
	public static long balancedBTs(long n){
    if(n==0 || n==1) {
    	return 1;
    }
    int mod = (int) Math.pow(10, 9) + 7;
    long a = balancedBTs(n-1);
    long b = balancedBTs(n-2);
    
    long x = (a*a)%mod;
    long y = (a*b)%mod;
    long z = (2*y)%mod;
    
	return (int)(x+z)%mod;	
	}
   public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		long n = s.nextInt();
		System.out.println(balancedBTs(n));
	}
}









/*
      if(n == 0 || n == 1) {
			return 1;
		}
		int mod = (int)Math.pow(10, 9) + 7;
		long x = balancedBTs(n-1);
		long y = balancedBTs(n-2);
		
		long x_2 = (x*x)%mod;
		long x_y = (x*y)%mod;
		long x_y_2 = (2*x_y)% mod ;
		return (int)(x_2+x_y_2)%mod;
*/