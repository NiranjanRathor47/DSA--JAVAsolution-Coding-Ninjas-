package LinkList;

public class PrintlinkList {
    
	public static void print(Node<Integer>head) {
		 while(head!=null)
		{
			System.out.print(head.data + " ");
			head =head.next ;
		}
	}
	public static void main(String[] args) {
		   Node<Integer> node1 = new Node <>(10);
           Node<Integer> node2 = new Node <>(20);
           Node<Integer> node3 = new Node <>(30);
           Node<Integer> node4 = new Node <>(50);
           Node<Integer> head = node1 ;
           node1.next = node2 ;
           node2.next = node3 ;
           print(head);

	}

}
