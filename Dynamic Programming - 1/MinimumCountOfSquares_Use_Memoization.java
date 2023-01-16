import java.util.Scanner;

public class MinimumCountOfSquares_Use_Memoization {

	public static int minCount(int n) {
		if(n==0) {
			return 0;
		}
		int num = (int)Math.sqrt(n);
		int ans = Integer.MAX_VALUE;
		while(num>0) {
			int remaning = n - (num*num);
			int sum = 1 + minCount(remaning);
			num--;
			if(ans>sum) {
				ans = sum;
			}
		}
		return ans;
	}
	public static int minCountM(int n,int storage[]) {
		if(n==0) {
			storage[n] = 0;
			return storage[n];
		}
		if(storage[n]!=0) {
			return storage[n];
		}
		int num = (int)Math.sqrt(n);
		int ans = Integer.MAX_VALUE;
		while(num>0) {
			int remaning = n - (num*num);
			int sum = 1 + minCountM(remaning,storage);
			num--;
			if(ans>sum) {
				ans = sum;
			}
			storage[n] = ans ;
		}
		return storage[n];
	}
	public static int minCountM(int n) {
		int storage[] = new int [n+1];
		return minCountM(n,storage);
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minCountM(n));
		System.out.println(minCount(n));
	}
}
