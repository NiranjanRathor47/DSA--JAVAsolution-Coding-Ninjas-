package LinkList;
import java.util.Scanner;
public class TakingLinkedListInput {

	public static Node<Integer> takeInput(){
		Node<Integer> head = null , tail=null;
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
	    while(data!=-1) {
	    	Node<Integer> newnode = new Node<Integer>(data);
	    	if(head==null) {
	    		head = newnode ;
	    		tail = newnode ;
	    	}
	    	else {
//	    		Node<Integer> temp = head ;
//	    		while(temp.next!=null) {
//	    			temp = temp.next ;
//	    		}
//	    		temp.next = newnode ;
	    		tail.next = newnode ;
	    		tail = newnode ; // tail = tail.next ;
	    	}
	    	data = s.nextInt();
	    }
	    return head ;
	}
	public static void print(Node<Integer>head) {
		while(head!=null)
		{
			System.out.print(head.data + " ");
			head =head.next ;
		}
	}
	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		print(head);
	}

}
