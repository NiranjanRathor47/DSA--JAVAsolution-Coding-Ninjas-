import java.util.Scanner;

public class ReverseLinkedList_Recursive {

	 public static LinkedListNode<Integer> reverse_R(LinkedListNode<Integer> head) {
	        if(head==null)
	            return head;
	        if(head.next==null)
	            return head;
	        LinkedListNode<Integer> tail=head.next;
	        LinkedListNode<Integer> smallhead=reverse_R(head.next);
	        tail.next=head;
	        head.next=null;
	        return smallhead;


	}
//	public static LinkedListNode<Integer> reverseLinkedListRec(LinkedListNode<Integer> head) {
//		if(head==null || head.next==null)
//	        return head;
//	     LinkedListNode<Integer> ans=reverseLinkedListRec(head.next);
//	     LinkedListNode<Integer> temp= ans ;
//	     while(temp.next!=null) {
//	    	 temp = temp.next ;
//	     }
//	     temp.next=head;
//	     head.next=null;
//	     return ans;
//	}
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
//				head = reverseLinkedListRec(head);
				head = reverse_R(head);
		        print(head);
				t--;
			}

		}
}
