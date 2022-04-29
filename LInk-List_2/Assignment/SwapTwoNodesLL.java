package Assignment;

import java.util.Scanner;

public class SwapTwoNodesLL {

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
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			LinkedListNode<Integer> head =  takeinput() ;
			int m = s.nextInt();
			int n = s.nextInt();
			head = swapNodes(head,m,n);
			print(head);
			t--;
		}

	}
}
