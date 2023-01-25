import java.util.Scanner;

public class LCS_Memoization {

	public static int lcs(String s1,String s2) {
		if(s1.length()==0 || s2.length()==0) {
			return 0;
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			return 1 + lcs(s1.substring(1),s2.substring(1));
		}
		else {
			int opt1 = lcs(s1,s2.substring(1));
			int opt2 = lcs(s1.substring(1),s2);
//			int opt3 = lcs(s1.substring(1),s2.substring(1));
			return Math.max(opt1, opt2);
		}
	}
	
	private static int lcsM(String s1,String s2,int storage[][]) {
		int m = s1.length();
		int n = s2.length();
		
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(m==0 || n==0) {
			storage[m][n] = 0;
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n] = 1 + lcsM(s1.substring(1),s2.substring(1),storage);
		}
		else {
			int opt1 = lcsM(s1,s2.substring(1),storage);
			int opt2 = lcsM(s1.substring(1),s2,storage);
			storage[m][n] = Math.max(opt1, opt2);
		}
		return storage[m][n] ;
	}
	public static int lcsM(String s1,String s2) {
		int storage[][] = new int [s1.length()+1][s2.length()+1];
		for(int i=0;i<s1.length()+1;i++) {
			for(int j=0;j<s2.length()+1;j++) {
				storage[i][j] = -1;
			}
		}
		return lcsM(s1,s2,storage);
 	}
	
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
	    String str1 = s.next();
		String str2 = s.next();
		System.out.println(lcsM(str1,str2));
		System.out.println(lcs(str1,str2));
	}
}
