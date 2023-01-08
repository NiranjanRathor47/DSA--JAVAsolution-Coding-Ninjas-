package Assignment;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Kth_LargestElement {

	public static int kthLargest(int n, int[] input, int k) {
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
//		for(int i=0;i<input.length;i++) {
//			pq.add(input[i]);
//		}
//		for(int i=0;i<k-1;i++) {
//			pq.remove();
//		}
//		int ans = pq.element();
//		return ans;
		PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
		for(int i=0;i<k;i++)
			priorityQueue.add(input[i]);
		for(int i= k ;i < input.length;i++) {
			if(input[i] > priorityQueue.peek() ) {
				priorityQueue.remove();
				priorityQueue.add(input[i]);
			}
		}
		return priorityQueue.remove();
	}
	 public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int input[] = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = s.nextInt();
			}
			int k = s.nextInt();
			int res = kthLargest(n,input,k);
				System.out.print(res);
		
	 }
}
