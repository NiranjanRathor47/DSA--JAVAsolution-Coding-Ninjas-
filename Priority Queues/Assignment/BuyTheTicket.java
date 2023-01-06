package Assignment;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int value;
	int index;
}
public class BuyTheTicket {

	public static int buyTicket(int input[], int k) {
		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Pair> queue = new LinkedList<>();
		for(int i=0;i<input.length;i++) {
			Pair pair = new Pair();
			pair.value = input[i];
			pair.index = i;
			pq.add(input[i]);
			queue.add(pair);
		}
		int count = 0;
		while(!queue.isEmpty()) {
			if(pq.peek()==queue.peek().value) {
				pq.remove();
			    Pair pair =	queue.poll();
				count++;
				if(pair.index==k) {
					return count;
				}
			}
			else {
				queue.add(queue.poll());
			}
		}
	   return count;	
	}
	public static void main(String[] args)  {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		int k = s.nextInt();
		System.out.println(buyTicket(input, k));
	}
}

