package LinkList;

import java.util.Scanner;

public class Print_ith_Node {
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
	public static void printIthNode(LinkedListNode<Integer> head, int i){
		 int count=0;
	     LinkedListNode<Integer> temp=head;
	        while(count!=i && temp!=null)
	        {
	            temp=temp.next;
	            count++;
	        }
	       if( count==i &&temp!=null)
	           System.out.println(temp.data);
		 
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			LinkedListNode<Integer> head =  takeinput() ;
			int index = s.nextInt();
			printIthNode(head,index);
			t--;
		}
		
	}

}
