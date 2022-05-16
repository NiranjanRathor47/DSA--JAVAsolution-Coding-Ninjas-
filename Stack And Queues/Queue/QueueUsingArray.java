package Queue;

import java.util.Scanner;

public class QueueUsingArray {

	private int data[] , front,rear,size ;
    
	public QueueUsingArray () {
		data = new int[10];
		front = -1;
		rear = -1;
		size = 0;
	}
	public QueueUsingArray (int capacity) {
		data = new int[capacity];
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
	int front() throws QueueEmptyException {
		if(size==0) {
			throw new QueueEmptyException();
		}
		return data[front];
	}
	void enQueue(int element) throws QueueFullException {
		if(size==data.length) {
		   throw new QueueFullException();
		}
		if(size==0) {
			front=0;
		}
		size++;
//      rear = (rear+1)%data.length ;	
		rear++;
		if(rear==data.length) {
			rear=0;
		}
		data[rear] = element; 
	}
	int deQueue() {
		if(size==0) {
			return -1;
		}
		int temp = data[front];
//		front = (front+1)%data.length;
		front++;
		size--;
		if(size==0) {
			front=-1;
			rear=-1;
		}
		return temp;
	}
	public static void main(String[] args) {
		QueueUsingArray queue = new QueueUsingArray();
		for(int i=1;i<=5;i++) {
			try {
				queue.enQueue(i);
			} catch (QueueFullException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		while(!queue.isEmpty()) {
			System.out.print(queue.deQueue());
		}
	}
}
