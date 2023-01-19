import java.util.Scanner;

public class Staircase_Use_Recursion_Mamoziation {

	public static int staircase(int n) {
       if(n==0) {
    	   return 1;
       }
       else if(n<0){
    	   return 0;
       }
       int count = staircase(n-1);
       int count1 = staircase(n-2);
       int count2 = staircase(n-3);
       int cp = count + count1 + count2 ;
       
       return cp ;
	}
	public static int staircaseM(int n,int step[]) {
		if(n==0) {
	    	   return 1;
	       }
	       else if(n<0){
	    	   return 0;
	       }
		if(step[n]!=0) {
			return step[n];
		}
	       int count = staircaseM(n-1,step);
	       int count1 = staircaseM(n-2,step);
	       int count2 = staircaseM(n-3,step);
	       int cp = count + count1 + count2 ;
	       
	       step[n] = cp ;
	       return step[n];
	}
	public static int staircaseM(int n) {
		int step[] = new int [n+1];
		return staircaseM(n,step);
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(staircaseM(n));
		System.out.println(staircase(n));
	}
}
