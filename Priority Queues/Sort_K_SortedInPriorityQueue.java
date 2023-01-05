import java.util.PriorityQueue;
import java.util.Scanner;

public class Sort_K_SortedInPriorityQueue {

	public static void sortKSorted(int input[],int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int i=0;
		for(;i<k;i++) {
			pq.add(input[i]);
		}
		for(;i<input.length;i++) {
			input[i-k] = pq.remove();
			pq.add(input[i]);
		}
		for(int j=input.length-k;j<input.length;j++) {
			input[j] = pq.remove();
		}
	}	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		sortKSorted(input,k);
		 for(int i=0;i<input.length;i++) {
			 System.out.print(input[i]+" ");
		 }
	 
  }
	
}
