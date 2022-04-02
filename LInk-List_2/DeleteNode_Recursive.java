import java.util.Scanner;

public class DeleteNode_Recursive {

    public static LinkedListNode<Integer> deleteNodeRec(LinkedListNode<Integer> head, int pos) {
        if(head==null) {
        	return head;
        }
        if(pos==0) {
        	return head.next;
        }
        head.next  = deleteNodeRec(head.next,pos-1);
       
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
				int pos = s.nextInt();
				head = deleteNodeRec(head,pos);
		        print(head);
				t--;
			}

		}
}
