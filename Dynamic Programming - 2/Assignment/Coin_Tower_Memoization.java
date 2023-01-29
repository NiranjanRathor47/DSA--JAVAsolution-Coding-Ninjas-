package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Coin_Tower_Memoization {

	public static String CoinTowerM(int n, int x, int y) {
		int storage[] = new int [n+1];
		Arrays.fill(storage, -1);
		return helpM(n,x,y,storage)==1 ?"Beerus" : "whis";
	}
	public static int helpM(int n, int x, int y,int []storage) {
		if(n==1 || n==x ||n==y) {
			storage[n] = 1;
			return storage[n];
		}
		if(n<=0) {
			return 0;
		}
		if(storage[n]!=-1) {
			return storage[n];
		}
		int a1 = helpM(n-1,x,y,storage)^1;
		int a2 = helpM(n-x,x,y,storage)^1;
		int a3 = helpM(n-y,x,y,storage)^1;
		
		storage[n] = Math.max(a1, Math.max(a2, a3));
		return storage[n];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		System.out.print(CoinTowerM(n,x,y));
	}
}
