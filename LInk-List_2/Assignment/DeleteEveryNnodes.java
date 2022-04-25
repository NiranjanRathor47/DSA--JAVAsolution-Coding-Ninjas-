package Assignment;

import java.util.Scanner;

public class DeleteEveryNnodes {

    public static LinkedListNode<Integer> skipMdeleteN(LinkedListNode<Integer> head, int M, int N) {
		   if(head==null) {
			   return head;
		   }
		   if(M==0) {
			   return null;
		   }
		   if(N==0) {
			   return head ;
		   }
		   int count ;
		   LinkedListNode<Integer> t1 = head,t2 ;
		   while(t1!=null) {
			   for(count=1;count<M && t1!=null ; count++) {
				   t1 = t1.next;
			   }
			   if(t1==null) {
				   return head;
			   }
			   t2 = t1.next ;
			   for(count=1;count<=N && t2!=null ; count++) {
				   t2 = t2.next;
			   }
			   t1.next = t2 ;
			   t1 = t2;
			   
		   }
		   return head;
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
			head = skipMdeleteN(head,m,n);
			print(head);
			t--;
		}

	}
}
