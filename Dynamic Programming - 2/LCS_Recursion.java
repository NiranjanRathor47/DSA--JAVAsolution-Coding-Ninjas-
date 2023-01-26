import java.util.Scanner;

public class LCS_Recursion {

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
	public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
	    String str1 = s.next();
		String str2 = s.next();
		System.out.print(lcs(str1,str2));
	}
}
