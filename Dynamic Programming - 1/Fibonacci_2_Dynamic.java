import java.util.Scanner;

public class Fibonacci_2_Dynamic {

	// ==> DP is to store values by iterative ==> Important
	// ==> and this is apply Bottom to Up
	public static int fib(int n) {
		if(n==0 || n==1) {
			return n;
		}
		return fib(n-1) + fib(n-2);
	}
	
	public static int fibM(int n) {
		int storage[] = new int [n+1];
		for(int i=0;i<storage.length;i++) {
			storage[i] = -1;
		}
		return fibM(n,storage);
	}
	
	private static int fibM(int n, int[] storage) {
		if(n==0 || n==1) {
			storage[n] = n;
			return storage[n];
		}
		if(storage[n]!=-1) {
			return storage[n];
		}
		storage[n] = fibM(n-1,storage) + fibM(n-2,storage);
		return storage[n];
	}

	public static int fibDP(int n) {
		 int storage[] = new int[n+1];
			storage[0] = 0;
			storage[1] = 1;
			
			for(int i=2;i<storage.length;i++) {
				storage[i] = storage[i-1] + storage[i-2];
			}
			return storage[n];
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(fibDP(n));
		System.out.println(fibM(n));
		System.out.println(fib(n));
	}
}
