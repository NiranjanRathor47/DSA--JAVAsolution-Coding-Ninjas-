package Assignment;

import java.util.Scanner;

public class BubbleSort_Iterative_LinkedList {

	public static LinkedListNode<Integer> bubbleSort(LinkedListNode<Integer> head) {
		if(head==null || head.next==null) {
			return head ;
		}
		for(int i=0;i<length(head)-1;i++) {
			LinkedListNode<Integer> curr = head ;
			LinkedListNode<Integer> prev = null;
			LinkedListNode<Integer> fwd  = curr.next;
			while(curr.next!=null) {
				if(curr.data>curr.next.data) {
					if(prev==null) {
						curr.next = fwd.next ;
						fwd.next = curr;
						prev = fwd ;
						head = prev;
					}
					else {
						fwd = curr.next;
						curr.next = fwd.next;
                        prev.next = fwd;
                        fwd.next = curr;
                        prev = fwd;
					}
				}
				else {
					 prev = curr;
	                 curr = curr.next;
				}
			}
		}
		return head ;
	}
	private static int length(LinkedListNode<Integer> head) {
		int count =0;
		while(head!=null) {
			head = head.next;
			count++;
		}
		return count ;
	}
	public static LinkedListNode<Integer> swapNodes(LinkedListNode<Integer> head, int i, int j) {
		if(i==j) {
			return head;
		}
		LinkedListNode<Integer> temp=head,prev=null,p1=null,c1=null,p2=null,c2=null;
		int pos=0;
		while(temp!=null) {
			if(pos==i) {
				p1=prev;
				c1=temp;
			}
			else if(pos==j) {
				p2=prev;
				c2=temp;
			}
			prev = temp;
		    temp = temp.next;
		    pos++;
		}
		if(p1!=null) {
			p1.next = c2;
		}
		else {
			head=c2;
		}
		if(p2!=null) {
			p2.next = c1;
		}
		else {
			head=c1;
		}
		LinkedListNode<Integer> temp1 = c2.next;
		c2.next = c1.next;
		c1.next = temp1;
		return head ;
	}
	 public static LinkedListNode<Integer> takeinput(){
			LinkedListNode<Integer> head = null , tail = null;
			Scanner s = new Scanner(System.in);
			int data =s.nextInt();
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
		
	   public static void print(LinkedListNode<Integer> head) {
			LinkedListNode<Integer> temp = head ;
			while(temp!=null) {
				System.out.print(temp.data + " ");
				temp = temp.next;
			}
		}
		public static void main(String[] args) {
				LinkedListNode<Integer> head =  takeinput() ;
				head = bubbleSort(head);
				print(head);
		}
}
