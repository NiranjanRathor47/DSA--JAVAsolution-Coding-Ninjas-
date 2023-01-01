import java.util.ArrayList;
import java.util.Scanner;

public class MaxPriorityQueue {


    private ArrayList<Integer> heap ;
	
	public MaxPriorityQueue() {
		heap = new ArrayList<>();
	}
	boolean isEmpty() {
		return (heap.size()==0);
	}
	int getSize() {
		return heap.size();
	}
	
	int getMax() throws PriorityQueueException {
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
			if(heap.get(parentIndex)<heap.get(childrenIndex)) {
				int temp=heap.get(parentIndex);
                heap.set(parentIndex,heap.get(childrenIndex));
                heap.set(childrenIndex,temp);
                childrenIndex=parentIndex;
                parentIndex=(childrenIndex-1)/2;
			}
			else {
				return ;
			}
		}
	}
	int removeMax() throws PriorityQueueException {
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
			if(heap.get(leftIndex) > heap.get(minIndex)) {
				minIndex = leftIndex ;
			}
			if(rightIndex < heap.size() && heap.get(rightIndex) > heap.get(minIndex)){
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
}
