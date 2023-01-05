import java.util.Scanner;

public class Priority_Queues_Insert_DeleteUse {

	public static void main(String[] args) throws NumberFormatException {	
		Scanner s = new Scanner(System.in);
		Priority_Queues_Insert_Delete pq = new Priority_Queues_Insert_Delete();
		int choice = s.nextInt();
		while(choice>0) {
			switch(choice) {
				case 1 : // insert
					int element = s.nextInt();
					pq.insert(element);
					break;
				case 2 : // getMin
				try {
					System.out.println(pq.getmin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
					break;
				case 3 : // removeMin
				try {
					System.out.println(pq.removeMin());
				} catch (PriorityQueueException e) {
					System.out.println(Integer.MIN_VALUE);
					return;
				}
					break;
				case 4 : // size
					System.out.println(pq.size());
					break;
				case 5 : // isEmpty
					System.out.println(pq.isEmpty());
				default :
						return;
			}
			choice--;
		}
		}
}
