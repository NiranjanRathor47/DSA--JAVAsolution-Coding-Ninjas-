import java.util.Scanner;

public class MergeSort {

	public static LinkedListNode<Integer> mergeSort(LinkedListNode<Integer> head) {
		if(head==null) {
			return head;
		}
		if(head.next==null) {
			return head ;
		}
		LinkedListNode<Integer> mid = midPoint(head);
		LinkedListNode<Integer> head2 = mid.next;
		mid.next = null ;
		LinkedListNode<Integer> t1 = mergeSort(head);
		LinkedListNode<Integer> t2 = mergeSort(head2);
		LinkedListNode<Integer> T =  mergeTwoSortedLinkedLists(t1,t2);
		return T ;
		
	}
	private static LinkedListNode<Integer> midPoint(LinkedListNode<Integer> head) {
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

	private static LinkedListNode<Integer> mergeTwoSortedLinkedLists(LinkedListNode<Integer> head1, LinkedListNode<Integer> head2) {
        if(head1==null)
            return head2;
        if(head2==null)
            return head1;
        LinkedListNode<Integer> t1=head1,t2=head2,tail=null,head=null;
        if(t1.data<=t2.data)
        {
            head=t1;
            tail=t1;
            t1=t1.next;
        }
        else
        {
            head=t2;
            tail=t2;
            t2=t2.next;
        }
        while(t1!=null &&t2!=null)
        {
            if(t1.data<=t2.data)
            {
                tail.next=t1;
                tail=t1;
                t1=t1.next;
            }
            else
            {
                tail.next=t2;
                tail=tail.next;
                t2=t2.next;
            }
        }
        if(t1==null)
            tail.next=t2;
        if(t2==null)
            tail.next=t1;
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
				head = mergeSort(head);
		        print(head);
				t--;
			}

		}
}
