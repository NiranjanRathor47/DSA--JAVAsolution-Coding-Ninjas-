package LinkList;

import java.util.Scanner;

public class InsertNodeLinkedList {

	public static LinkedListNode<Integer> takeinput(){
		LinkedListNode<Integer> head = null, tail = null ;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		while(data!=-1) {
			LinkedListNode<Integer> newnode = new LinkedListNode<Integer>(data);
			if(head==null) {
				head = newnode ;
				tail = newnode ;
			}
			else {
				tail.next = newnode ;
				tail = newnode ;
			}
			data = s.nextInt();
		}
		return head ;
	}
	public static void print(LinkedListNode<Integer>head) {
	//	int count =0;
		while(head!=null)
		{
			System.out.print(head.data + " ");
			head =head.next ;
	//		count++;
		}
	
	//	System.out.println("*" + count + "*" );
	}
    public static LinkedListNode<Integer> Insert(LinkedListNode<Integer>head,int data,int pos) {
    	LinkedListNode<Integer> newnode = new LinkedListNode<>(data) ;
    	if(pos==0) {
    		newnode.next = head;
    		return newnode ;
    	}
    	int i=0;
    	LinkedListNode<Integer> temp = head ;
    	while(i<pos-1) {
    	  temp = temp.next ;
    	  i++;
    	}
    	newnode.next = temp.next ;
    	temp.next = newnode ;
    	return head ;
    }

    public static void main(String[] args) {
		LinkedListNode<Integer> head = takeinput();
	    head = Insert(head,45,3);
		print(head);
	}

}
