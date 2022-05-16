package Queue;

public class QueueUsingLL<T> {
    private Node<T> front,rear;
    private int size;
	
	public QueueUsingLL() {
		 front = null;
		 rear = null;
	     size = 0;
	}

	public int getSize() { 
		return size;
    }


    public boolean isEmpty() { 
         return (front==null);
    }

    public void enqueue(int data) {
         Node <T> ptr = new Node(data);
         ptr.data = data ;
         if(front==null) {
        	 front = ptr ;
        	 rear =  ptr ;
        	 front.next = null;
        	 rear.next = null;
         }
         else {
        	 rear.next = ptr ;
             rear = ptr ;
             rear.next = null ;
         }
        this.size++;     
    }

    public int dequeue() {
    	 int ptr ;
    	if(front==null) {
    		return -1;
    	}
    	ptr = front.data ;
    	front = front.next;
    	this.size--;
    	return ptr ;
    }

    public int front() {
    	if(isEmpty()) {
    		return -1;
    	}
    	return front.data;
    }
}
class Node<T> {
	int data;
	Node next;

	public Node(int data) {
		this.data = data;
		this.next = null;
	}

}
