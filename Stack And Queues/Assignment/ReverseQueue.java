package Assignment;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.Scanner;

public class ReverseQueue {

	public static void reverseQueue(Queue<Integer> input) {
		 Stack<Integer> stack = new Stack<>();
		 while(!input.isEmpty()) {
			 stack.add(input.poll());
		 }
		 while(!stack.isEmpty()) {
			 input.add(stack.pop());
		 }
	}
	public static int[] takeinput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
       while(t>0) {
    	   int a[] = takeinput();
    	   Queue<Integer> queue = new LinkedList<>();
    	   for(int i=0;i<a.length;i++) {
    		   queue.add(a[i]);
    	   }
    	   reverseQueue(queue);
    	   while (!queue.isEmpty()) {
				System.out.print(queue.poll() + " ");
			}

			System.out.println();
    	   t--;
       }
	}

}
