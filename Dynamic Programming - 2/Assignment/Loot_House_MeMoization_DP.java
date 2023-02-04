package Assignment;

import java.util.Arrays;
import java.util.Scanner;

public class Loot_House_MeMoization_DP {

	// Dynamic Programming
	public static int maxMoneyLootedDP(int []arr,int n) {
		if(arr.length==0) {
			return  0;
		}
		int storage[] = new int [n];
		storage[0] = arr[0];
		storage[1] = Math.max(arr[0], arr[1]);
		for(int i=2;i<n;i++) {
			storage[i] = Math.max(storage[i-2] + arr[i], storage[i-1]);
		}
		return storage[n-1];
	}
	public static int maxMoneyLootedDP(int[] houses) {
        int n = houses.length;
		return maxMoneyLootedDP(houses,n);
	}
	// Memoization
	public static int lootHousesMemo(int[] arr,int n) {
		int[] storage = new int[n+1];
		Arrays.fill(storage, -1);
		return lootHousesMemo(arr, n,storage);
	}

	public static int lootHousesMemo(int[] arr, int n, int[] storage) {
		if(n<=0) {
			storage[0] = 0;
			return storage[0];
		}
		if(storage[n]!=-1) {
			return storage[n];
		}
		
		storage[n] = Math.max(lootHousesMemo(arr, n-1,storage),  lootHousesMemo(arr, n-2, storage)+arr[n-1]);
		return storage[n];
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[] = new int [n];
		for(int i=0;i<n;i++) {
			arr[i] = s.nextInt();
		}
		System.out.println(lootHousesMemo(arr,n));
		System.out.println(maxMoneyLootedDP(arr));
	}
}
