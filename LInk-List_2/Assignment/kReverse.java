package Assignment;

import java.util.Scanner;

public class kReverse {

	public static LinkedListNode<Integer> kReverse(LinkedListNode<Integer> head, int k) {
		if(head==null || head.next==null) {
			return head ;
		}
		if(k==0) {
			return head ;
		}
		 LinkedListNode<Integer> h1=head,h2,t1=head;
	      int count=1;
	      while(count<k && t1.next!=null) {
           t1 = t1.next ;
	    	  count++;
	      }
	      h2 = t1.next ;
	      t1.next = null;
	    
	      DoubleNode ans=reversePart(h1);
	      LinkedListNode<Integer> secondHead=kReverse(h2,k);
	      ans.tail.next = secondHead;
	      return ans.head;
	}
	 private static DoubleNode reversePart(LinkedListNode<Integer> head)
	    {
	        if(head==null || head.next==null)
	        { DoubleNode ans=new DoubleNode();
	        ans.head=head;
	        ans.tail=head;
	        return ans;}
	     
	        DoubleNode ans=reversePart(head.next);
	        ans.tail.next=head;
	        head.next=null;
	        ans.tail=ans.tail.next;
	        return ans;
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
				int k = s.nextInt();
				head = kReverse(head,k);
				print(head);
				t--;
			}

		}
	}
	class DoubleNode{
	    LinkedListNode<Integer> head;
	    LinkedListNode<Integer> tail; 
	    }
	

