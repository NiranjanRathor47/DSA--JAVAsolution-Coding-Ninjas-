import java.util.ArrayList;
import java.util.Scanner;

public class Priority_Queues_Insert_Delete {

	private ArrayList<Integer> heap ;
	
	public Priority_Queues_Insert_Delete() {
		heap = new ArrayList<>();
	}
	boolean isEmpty() {
		return (heap.size()==0);
	}
	int size() {
		return heap.size();
	}
	
	int getmin() throws PriorityQueueException {
		if(isEmpty()) {
			// throw an exception
			throw new PriorityQueueException();
		}
		return heap.get(0);
	}
	void insert(int element) {
		heap.add(element);
		int childrenIndex = heap.size()-1;
		int parentIndex = (childrenIndex-1) / 2;
		while(childrenIndex>0) {
			if(heap.get(parentIndex)>heap.get(childrenIndex)) {
				int temp = heap.get(childrenIndex);
				heap.set(childrenIndex, heap.get(parentIndex));
				heap.set(parentIndex, temp);
				childrenIndex = parentIndex;
				parentIndex = (childrenIndex-1)/2;
			}
			else {
				return ;
			}
		}
	}
	
	int removeMin() throws PriorityQueueException {
		
		if(isEmpty()) {
			// throw an exception
			throw new PriorityQueueException();
		}
		int temp = heap.get(0);
		heap.set(0,heap.get(heap.size()-1) );
		heap.remove(heap.size()-1);
		int parentIndex = 0;
		int minIndex = parentIndex;
		int leftIndex = 1;
		int rightIndex = 2;
		while(leftIndex<heap.size()) {
			if(heap.get(leftIndex) < heap.get(minIndex)) {
				minIndex = leftIndex ;
			}
			if(rightIndex < heap.size() && heap.get(rightIndex) < heap.get(minIndex)){
				minIndex = rightIndex;
			}
			if(minIndex == parentIndex){
				break;
			}
			else {
				 int temp1 = heap.get(parentIndex);
	             heap.set(parentIndex, heap.get(minIndex));
		         heap.set(minIndex, temp1);
				parentIndex = minIndex;
				leftIndex = 2 * parentIndex + 1;
				rightIndex = 2 * parentIndex + 2;				
			}
		}
		return temp;
	}
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
