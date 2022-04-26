package Assignment;

import java.util.Scanner;

public class FindEleInLL_Recursive {

	public static int findNodeRec(LinkedListNode<Integer> head, int n) {
		return helper(head,0,n);	
	}
	public static int helper(LinkedListNode<Integer> head, int index,int n) {
		if(head==null) {
			return -1;
		}
		if(head.data==n) 
			return index ;
		int ans = helper(head.next,index+1,n);
		return ans ;
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
				int n = s.nextInt();
				int res = findNodeRec(head,n);	
				System.out.println(res);
				t--;
			}

		}

}
