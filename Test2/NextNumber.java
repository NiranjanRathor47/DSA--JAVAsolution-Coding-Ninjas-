import java.util.Scanner;
import java.util.LinkedList;

public class NextNumber {

	public static LinkedListNode<Integer> nextLargeNumber(LinkedListNode<Integer> head) {
        LinkedListNode<Integer> temp;
        LinkedListNode<Integer> prev =null;
        LinkedListNode<Integer> curr=head;
        while(curr!=null){
            temp=curr.next;
            curr.next=prev;
            prev=curr;
            curr=temp;
        }
        LinkedListNode<Integer> tem=prev;
        int extra=0;
        LinkedListNode<Integer> a= new LinkedListNode<Integer>(1);        
        while(tem!=null){
            if(tem.data==9){
                tem.data=0;
                extra=1;
                if(tem.next==null){
                    tem.next=a;
                }
            }else{
              if(extra==1){                
                int d=tem.data+1;
                if(d==10){
                  tem.data=0;
                   extra=1;  
                }else{
                   extra=0;
                }
              }else{                
                  tem.data=tem.data+1;
                  break;
            }}
            tem=tem.next;
        }
        LinkedListNode<Integer> temp1;
        LinkedListNode<Integer> prev1 =null;
        LinkedListNode<Integer> curr1=prev;
        while(curr1!=null){
            temp1=curr1.next;
            curr1.next=prev1;
            prev1=curr1;
            curr1=temp1;
        }
        return prev1;
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
		
		LinkedListNode<Integer> head = takeinput();
		head = nextLargeNumber(head);
		print(head);
		
	}
}
class LinkedListNode<T> {
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
} 