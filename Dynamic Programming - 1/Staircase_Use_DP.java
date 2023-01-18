import java.util.Scanner;

public class Staircase_Use_DP {

	public static long staircaseDP(int n) {
		long step[] = new long [n+1];
	    step[0] = 1; 
		for(int i=1;i<=n;i++) {
			if(i==1) {
			step[i] = step[i-1]; 
//				step[1] = 1;
			}
			else if(i==2) {
				step[i] = step[i-1] + step[i-2];
//				step[2] = 2;
			}
			else {
				step[i] = step[i-1] + step[i-2] + step[i-3];
			}
		}
		
		return step[n];
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.print(staircaseDP(n));
	}
}











/*
   long step[] = new long[n+1];
	    step[0] = 1;
	    
	    for(int i=1;i<=n;i++) {
	    	if(i==1) {
	    		step[i] = step[i-1];
	    	}
	    	else if(i==2) {
	    		step[i] = step[i-1] + step[i-2];
	    	}
	    	else {
	    		step[i] = step[i-1] + step[i-2] + step[i-3];
	    	}
	    }
	    return step[n];
*/