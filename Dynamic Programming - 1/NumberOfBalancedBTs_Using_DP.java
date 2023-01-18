import java.util.Scanner;

public class NumberOfBalancedBTs_Using_DP {

	public static int balancedBTs(int height){
           int storage[] = new int [height+1];
           storage[0] = 1;
           storage[1] = 1;
           storage[2] = 3;
           int mod = (int)Math.pow(10, 9) + 7;
        for(int i=3;i<=height;i++) {
        	int x = storage[i-1];
        	int y = storage[i-2];
        	
        	long p = (long)x*x;
        	long q = (long)x*y*2;
        	int value1 = (int)(p%mod);
    		int value2 = (int)(q%mod);
    		
    		storage[i] = (value1+value2)%mod;
        }
        return storage[height];
	}
	   public static void main(String [] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			System.out.println(balancedBTs(n));
		}
}
