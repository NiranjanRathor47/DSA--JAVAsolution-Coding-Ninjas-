import java.util.Scanner;

public class ReverseRecursivelyDoubleNode {
	public static DoubleNode reverseLLBetter(LinkedListNode<Integer>head) {
		if(head==null || head.next==null) {
			DoubleNode ans = new DoubleNode();
			ans.head = head ;
			ans.tail = head ;
			return ans ;
		}
		DoubleNode smallans = reverseLLBetter(head.next);
		smallans.tail.next = head ;
		head.next = null ;
		
		DoubleNode ans = new DoubleNode();
		ans.head = smallans.head ;
		ans.tail = head ;
		
		return ans ;
		/*
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
		 */
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
		while(head!=null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	 }
		
	public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int t = s.nextInt();
			while(t>0) {
				LinkedListNode<Integer> head =  takeinput() ;			
				DoubleNode res = reverseLLBetter(head);
		        print(res.head);
				t--;
			}

		}

}



//  /* public */ class DoubleNode {
//
//	LinkedListNode<Integer> head ;
//	LinkedListNode<Integer> tail ;
//  }

