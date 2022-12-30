import java.util.PriorityQueue;
import java.util.Scanner;

public class Collection_Of_MIN_PriorityQueue {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		
		 for(int i=0;i<input.length;i++) {
			pq.add(input[i]);
		}
	 System.out.print(pq.element());   
 //    System.out.print(pq.peek());  
	 System.out.println();
	 while(!pq.isEmpty()) {
		 System.out.print(pq.remove()+" ");
	 }
	 
}
}
