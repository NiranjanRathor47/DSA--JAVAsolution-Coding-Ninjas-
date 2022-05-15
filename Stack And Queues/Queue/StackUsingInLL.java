package StackS;

public class StackUsingInLL<T>{
	private Node<T> head;
    private int size ;
    
	 public StackUsingInLL() {
	        head = null;
	        size = 0;
	    }

	    public int getSize() { 
	        
	    	return this.size;
	    }

	    public boolean isEmpty() {
//	       if(head==null) {
//	    	   return true ;
//	       }
//	       else
//	    	   return false ;
	        return (head==null);
	    }

	    public void push(int element) {
	    	  Node ptr = new Node(element);
	    	  if(ptr==null) {
	    		  return ;
	    	  }
	    	  ptr.data = element ;
	    	  ptr.next = head;
	    	  head = ptr ;
	    	  this.size++;
	    }

	    public int top() {
	        if(isEmpty()) {
	        	return -1;
	        }
	        return (int) head.data;
	    }
	    
	    public int pop() {
	        if(isEmpty()) {
	        	return -1;
	        }
	        int top = top();
	        this.size--;
	        this.head = this.head.next;
	        return  top ;
	    }

	   
}
class Node<T> {

	T data ;
	Node<T> next ;
	
	public Node(T data){
		this.data = data ;
		next = null ;
	}

	
}
