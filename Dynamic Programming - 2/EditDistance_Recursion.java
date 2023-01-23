import java.util.Scanner;

public class EditDistance_Recursion {

   public static int editDistance(String s1, String s2){
		if(s1.length()==0 ) {
			return s2.length();
		}
		if(s2.length()==0) {
			return s1.length();
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			return editDistance(s1.substring(1),s2.substring(1));
		}
		else {
			//Insert
			int opt1 = editDistance(s1,s2.substring(1));
			// Delete
			int opt2 = editDistance(s1.substring(1),s2.substring(1));
			// Substitute
			int opt3 = editDistance(s1.substring(1),s2);
		    return 1 + Math.min(Math.min(opt1,opt2), opt3);
		}
	}
   public static void main (String [] args) {
		Scanner s = new Scanner(System.in);
	    String str1 = s.next();
		String str2 = s.next();
		System.out.println(editDistance(str1,str2));
	}	
}
