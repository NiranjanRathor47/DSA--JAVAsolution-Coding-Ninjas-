import java.util.Scanner;

public class EditDistance_DP {

	public static int editDistanceDP(String s, String t) {
		int m = s.length();
		int n = t.length();
		int storage[][] = new int [m+1][n+1];
		for(int i=0;i<=m;i++) {
			storage[i][0] = i;
		}
		for(int j=0;j<=n;j++) {
			storage[0][j] = j;
		}
		for(int i=1;i<=m;i++) {
			for(int j=1;j<=n;j++) {
				if(s.charAt(m-i)==t.charAt(n-j)) {
					storage[i][j] = storage[i-1][j-1];
				}
				else {
					storage[i][j] = 1 + Math.min(Math.min(storage[i][j-1], storage[i-1][j]),storage[i-1][j-1]);
				}
			}
		}
		return storage[m][n];
	}
	   public static void main (String [] args) {
			Scanner s = new Scanner(System.in);
		    String str1 = s.next();
			String str2 = s.next();
			System.out.println(editDistanceDP(str1,str2));
		}	
}
