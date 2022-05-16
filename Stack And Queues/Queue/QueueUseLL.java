package Queue;

import java.util.Scanner;

public class QueueUseLL {

	
		public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			QueueUsingLL<Integer> queue = new QueueUsingLL<>();

			int q = s.nextInt();

			while (q > 0) {
				int choice, input;
				choice = s.nextInt();

				switch(choice) {
					case 1:
						input = s.nextInt();
						queue.enqueue(input);
						break;

					case 2:
						System.out.println(queue.dequeue());
						break;

					case 3:
						System.out.println(queue.front());
						break;

					case 4:
						System.out.println(queue.getSize());
						break; 

					default: 
						System.out.println((queue.isEmpty()) ? "true" : "false");
				}

				q --;
			}

		}
	}


