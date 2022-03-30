package LinkList;

public class Node<T> {

	T data ;
	Node<T> next ;
	
	Node(T data){
		this.data = data ;
		next = null ;
	}
	public static void main(String[] args) {
           Node<Integer> node1 = new Node <>(10);
           Node<Integer> node2 = new Node <>(20);
           node1.next = node2 ;
           System.out.println(node1.data);
           System.out.println(node1.next);
           System.out.println(node2.data);
           System.out.println(node2.next);
	}

}
