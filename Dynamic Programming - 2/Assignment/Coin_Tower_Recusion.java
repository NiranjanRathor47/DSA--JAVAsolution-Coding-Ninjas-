package Assignment;

import java.util.Scanner;

public class Coin_Tower_Recusion {

	public static String CoinTower(int n,int x,int y) {
		if(help(n,x,y)==1) {
			return "Beerus";
		}
		return "whis";
	}
	public static int help(int n,int x,int y) {
		if(n<=0) {
			return 0;
		}
		if(n==1 || n==x || n==y) {
			return 1;
		}
		int a1 = help(n-1,x,y)^1;
		int a2 = help(n-x,x,y)^1;
		int a3 = help(n-y,x,y)^1;
		
		return Math.max(a1, Math.max(a2, a3));
	}
	public static void main(String[] args) {
		Scanner s = new Scanner (System.in);
		int n = s.nextInt();
		int x = s.nextInt();
		int y = s.nextInt();
		System.out.print(CoinTower(n,x,y));
	}
}
