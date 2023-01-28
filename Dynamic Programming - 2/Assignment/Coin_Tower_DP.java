package Assignment;

import java.util.Scanner;

public class Coin_Tower_DP {

	public static String CoinTowerDP(int n, int x, int y) {
		int storage[] = new int [n+1];
		int a1=0;
		int a2=0;
		int a3=0;
		storage[1] = 1;
		for(int i=2;i<storage.length;i++) {
			if(i==x || i==y) {
				storage[i] = 1;
				continue;
			}
			if(i-x>=1) {
				 a1 = storage[i-x]^1;
			}
			if(i-y>=1) {
				 a2 = storage[i-y]^1;
			}
			     a3 = storage[i-1]^1;
			storage[i] = Math.max(a1, Math.max(a2, a3));
		}
		if(storage[n]==1) {
			return "Beerus";
		}
		return "whis";
	}
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		System.out.print(CoinTowerDP(n,x,y));
	}
}
