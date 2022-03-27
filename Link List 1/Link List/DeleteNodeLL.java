package LinkList;
import java.util.Scanner;
public class DeleteNodeLL {

	public static LinkedListNode<Integer> deleteNode(LinkedListNode<Integer> head, int pos) {
		 if(head==null) {
			 return head ;
		 }
		 if(pos==0) {
			 return head.next ;
		 }
		
		int i=0;
        LinkedListNode<Integer> temp = head ;
		while(temp!=null && i<pos-1) {
			temp = temp.next;
			i++;
		}
		if(temp==null)
           return head;
       if(temp.next!=null)
           temp.next=temp.next.next;
		 
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
		LinkedListNode<Integer> temp = head ;
		while(temp!=null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		while(t>0) {
			LinkedListNode<Integer> head =  takeinput() ;
			int index = s.nextInt();
			head = deleteNode(head ,index);
			print(head);
			t--;
		}
	}

}
