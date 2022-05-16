package Queue;

public class DynamicArrayInQueue {

	private int data[],front,rear,size;
	
	public DynamicArrayInQueue() {
		data = new int [10];
		front = -1;
		rear = -1;
		size = 0;
	}
	public DynamicArrayInQueue(int capacity) {
		data = new int [capacity];
		front = -1;
		rear = -1;
		size = 0;
	}
	int size() {
		return size;
	}
	boolean isEmpty() {
		return (size==0);
	}
	int front() {
		if(size == 0){
//			throw new QueueEmptyException();
			return -1;
		}
		return data[front];
	}
	void enQueue(int element) {
		if(size == data.length){
			doubleCapacity();
		}
		
		if(size == 0){
			front = 0;
		}
		size++;
		rear = (rear + 1) % data.length;
//		rear++;
//		if(rear == data.length){
//			rear = 0;
//		}
		data[rear] = element; 
	}
	private void doubleCapacity() {
		int temp[] = data;
		data = new int[ 2* temp.length];
		int index = 0;
		for(int i = front ; i < temp.length; i++){
			data[index] = temp[i];
			index++;
		}
		for(int i = 0; i <= front - 1;i++){
			data[index] = temp[i];
			index++;
		}
		front = 0;
		rear = temp.length - 1;
	}

	int dequeue() {
		if(size == 0){
//			throw new QueueEmptyException();
			return -1;
		}
		int temp = data[front];
		front = (front + 1) % data.length;
//		front++;
//		if(front == data.length){
//			front = 0;
//		}
		size--;
		if(size == 0){
			front = -1;
			rear = -1;
		}
		return temp;
	}
	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray(3);
		for(int i=1;i<=5;i++) {
			try {
				queue.enQueue(i);
			} catch (QueueFullException e) {
				e.printStackTrace();
			}
		}
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueue());
		}
	}
}
