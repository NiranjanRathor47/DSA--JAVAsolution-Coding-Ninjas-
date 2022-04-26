package Assignment;

import java.util.Scanner;

public class EvenAfterOddLinkedList {

	public static LinkedListNode<Integer> evenAfterOdd(LinkedListNode<Integer> head) {
		if(head==null) {
			return head;
		}
		LinkedListNode<Integer> evenH = null,evenT=null,oddH=null,oddT=null;
		while(head!=null) {
			if(head.data%2==0) {
				if(evenH == null && evenT==null) {
					evenH = head ;
					evenT = head ;
				}
				else {
					evenT.next = head;
					evenT = head ;
				}
				head = head.next;
			}
			else {
				if(oddH==null && oddT==null ) {
					oddH = head ;
					oddT = head ;
				}
				else {
					oddT.next = head;
					oddT = head ;
				}
				head = head.next;
			}
		}
		if(oddH!=null) {
			oddT.next = evenH ;
		}
		else {
			return evenH ;
		}
		if(evenH!=null) {
			evenT.next = null ;
		}
		return oddH ;
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
			head = evenAfterOdd(head);
			print(head);
			t--;
		}

	}

}
