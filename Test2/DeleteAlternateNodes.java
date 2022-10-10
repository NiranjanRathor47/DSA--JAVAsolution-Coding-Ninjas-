import java.util.Scanner;
public class DeleteAlternateNodes {

	public static void deleteAlternateNodes(Node<Integer> head) {
		 if(head==null || head.next==null) {
			 return ;
		 }
		Node<Integer> ptr = head, ptr1 = null;
		
		while(ptr!=null) {
			ptr1 = ptr.next;
			ptr.next = ptr1.next;
			ptr = ptr.next;
		}
	}
	
	public static Node<Integer> takeinput(){
	   Node<Integer> head = null , tail = null;
		Scanner s = new Scanner(System.in);
		int data =s.nextInt();
		while(data!=-1) {
			Node<Integer> newnode = new Node<Integer>(data);
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
	
    public static void print(Node<Integer> head) {
		Node<Integer> temp = head ;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
			Node<Integer> head =  takeinput() ;
			deleteAlternateNodes(head);
			print(head);
			
	}

	
}
class Node<T> {

	T data ;
	Node<T> next ;
	
	public Node(T data){
		this.data = data ;
		next = null ;
	}

	
}