import java.util.Scanner;

public class LCS_DP {

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
	public static int lcsDP(String s1,String s2) {
		int m = s1.length();
		int n = s2.length();
		int storage[][] = new int [m+1][n+1];
		for(int i=0;i<=m;i++) {
			storage[i][0] = 0;
		}
		for(int j=0;j<=n;j++) {
			storage[0][j] = 0;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s1.charAt(m-i)==s2.charAt(n-j)) {
					storage[i][j] = 1 + storage[i-1][j-1];
				}
				else {
					storage[i][j] = Math.max(storage[i][j-1], storage[i-1][j]);
				}
			}
		}
		return storage[m][n];
	}
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
	    String str1 = s.next();
		String str2 = s.next();
		System.out.println(lcsDP(str1,str2));
		System.out.println(lcsM(str1,str2));
		System.out.println(lcs(str1,str2));
	}	
}
