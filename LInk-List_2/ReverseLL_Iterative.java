import java.util.Scanner;

public class ReverseLL_Iterative {

	public static LinkedListNode<Integer> Iterative(LinkedListNode<Integer> head){
		LinkedListNode<Integer> curr = head ;
		LinkedListNode<Integer> prev = null ;
		LinkedListNode<Integer> fwd ;
		
		while(curr!=null) {
			fwd = curr.next;
			curr.next = prev ;
			prev = curr;
			curr = fwd ;
		}
		return prev ;
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
				head = Iterative(head);
		        print(head);
				t--;
			}

		}
}
