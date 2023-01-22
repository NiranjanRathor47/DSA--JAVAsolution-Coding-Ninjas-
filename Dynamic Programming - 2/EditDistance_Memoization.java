import java.util.Scanner;

public class EditDistance_Memoization {

	private static int editDistanceM(String s1,String s2,int storage[][]) {
		int m = s1.length();
		int n = s2.length();
		
		if(m==0) {
			storage[m][n] = n;
			return storage[m][n];
		}
		if(n==0) {
			storage[m][n] = m;
			return storage[m][n];
		}
		if(storage[m][n]!=-1) {
			return storage[m][n];
		}
		if(s1.charAt(0)==s2.charAt(0)) {
			storage[m][n] = editDistanceM(s1.substring(1),s2.substring(1));
			return  storage[m][n];
		}
		else {
			//Insert
			int opt1 = editDistanceM(s1,s2.substring(1),storage);
			// Delete
			int opt2 = editDistanceM(s1.substring(1),s2.substring(1),storage);
			// Substitute
			int opt3 = editDistanceM(s1.substring(1),s2,storage);
		     storage[m][n] = 1 + Math.min(Math.min(opt1,opt2), opt3);
		     return storage[m][n];
		}
		
	}

	public static int editDistanceM(String s, String t) {
		int storage[][] = new int [s.length()+1][t.length()+1];
		for(int i=0;i<s.length()+1;i++) {
			for(int j=0;j<t.length()+1;j++) {
				storage[i][j] = -1;
			}
		}
		return editDistanceM(s,t,storage);
    }
	
	   public static void main (String [] args) {
			Scanner s = new Scanner(System.in);
		    String str1 = s.next();
			String str2 = s.next();
			System.out.println(editDistanceM(str1,str2));
		}	
}
