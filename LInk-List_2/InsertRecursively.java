import java.util.Scanner;

public class InsertRecursively {

	
	public static LinkedListNode<Integer> insert(LinkedListNode<Integer> head,int pos,int ele){
		if(pos==0) {
			LinkedListNode<Integer> newnode = new LinkedListNode<> (ele);
			newnode.next = head ;
			return newnode ;
		}
		if(head==null) {
			return head ;
		}
		head.next = insert(head.next,pos-1,ele);
		return head ;
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
				head = insert(head,2,58);
		        print(head);
				t--;
			}

		}
}
