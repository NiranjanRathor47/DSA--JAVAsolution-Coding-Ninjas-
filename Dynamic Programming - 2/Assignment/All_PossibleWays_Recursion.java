package Assignment;

import java.util.Scanner;

public class All_PossibleWays_Recursion {

	public static int allWays(int x, int n) {
        
	       return allWays(x,n,1);
	    }
	    public static int allWays(int x, int n,int num) {
            int val = x - (int)Math.pow(num, n);
            if(val<0) {
            	return 0;
            }
            if(val==0) {
            	return 1;
            }
            return allWays(val,n,num+1)+allWays(x,n,num+1);
		}
	public static void main(String [] args) {
			Scanner s = new Scanner(System.in);
			int x = s.nextInt();
			int n = s.nextInt();
			System.out.println(allWays(x,n));
	 }
}
