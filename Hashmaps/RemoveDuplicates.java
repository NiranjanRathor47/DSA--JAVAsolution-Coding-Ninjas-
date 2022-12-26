import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class RemoveDuplicates {

	public static ArrayList<Integer> removedulicates(int a[]){
		ArrayList<Integer> output = new ArrayList<>();
		HashMap<Integer,Boolean> seen = new HashMap<>();
		for(int i=0;i<a.length;i++) {
			if(seen.containsKey(a[i])) {
				continue;
			}
			output.add(a[i]);
			seen.put(a[i], true);
		}
		return output;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a [] = new int[n];
		for(int i =0;i<a.length;i++) {
			a[i] = s.nextInt();
		}
		ArrayList<Integer> ans = removedulicates(a);
		for(int i =0;i<ans.size();i++) {
			System.out.print(ans.get(i) + " ");
		}
	}
}
