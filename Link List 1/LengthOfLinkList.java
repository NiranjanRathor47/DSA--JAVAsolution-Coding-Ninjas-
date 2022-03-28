package LinkList;

import java.util.Scanner;

public class LengthOfLinkList {
	
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
	public static int length(LinkedListNode<Integer> head){
		 LinkedListNode<Integer> temp=head;
	        int count=1;
	        while(temp.next!=null){
	            temp=temp.next;
	            count++;
	        }
	        return count;

	}
	public static void print(LinkedListNode<Integer>head) {
		while(head!=null)
		{
			System.out.print(head.data + " ");
			head =head.next ;
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			LinkedListNode<Integer> head =  takeinput() ;
		// print(head);
			int res = length(head);
	    	System.out.println(res);
			t--;
		}
		
	}

}
