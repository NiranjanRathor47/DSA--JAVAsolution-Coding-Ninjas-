package Assignment;

import java.util.Scanner;

public class Staircase {
	public static int staircase(int n){
		 if(n<0)
	            return 0;
	        if(n==0)
	            return 1;
	        int op1=staircase(n-1);
	        int op2=staircase(n-2);
	        int op3=staircase(n-3);
	        return op1+op2+op3;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int res = staircase(n);
		System.out.print(res);
	}

}
