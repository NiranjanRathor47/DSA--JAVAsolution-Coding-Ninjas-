import java.util.Scanner;

public class MidPointInLinkedList {

	 public static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
	       if(head==null){
	           return head ;
	       }
	        LinkedListNode<Integer> slow = head ,fast = head ;
			while(fast.next!=null && fast.next.next!=null) {
				fast = fast.next.next;
				slow = slow.next ;
			}
			return slow ;
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
		
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			LinkedListNode<Integer> head =  takeinput() ;
			 LinkedListNode<Integer> mid = midPoint(head);
	            
	            if (mid != null) {
	                System.out.println(mid.data);
	            }

		   
			t--;
		}
	}

}
