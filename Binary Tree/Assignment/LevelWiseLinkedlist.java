package Assignment;
import java.util.Scanner;
import java.util.ArrayList;

public class LevelWiseLinkedlist {

   public static ArrayList<LinkedListNode<Integer>> constructLinkedListForEachLevel(BinaryTreeNode<Integer> root){
	   if(root==null){
           return null;
       }  
	   QueueUsingLL<BinaryTreeNode<Integer>> q  =new QueueUsingLL<BinaryTreeNode<Integer>>();
	   ArrayList<LinkedListNode<Integer>> arr= new ArrayList<LinkedListNode<Integer>>();
	   LinkedListNode<Integer> head=null;
	   LinkedListNode<Integer> tail=null;
	       q.enqueue(root); 
	       q.enqueue(null);
	       // first insert the root and null in the queue 
	       // so that we can know the level is fully traversed or not
	      while(!q.isEmpty()) {
	         BinaryTreeNode<Integer> temp= null;
	         try{ 
	             temp = q.dequeue(); 
	         }
	         catch (QueueEmptyException e){}
	          if(temp==null){
	              // if the node which is dequeued is null than 
	              // it has two meaning 
	              // one is that the level is completed and the tree traversal is completed
	              arr.add(head);
	              head=null;
	              tail=null;
	              if(q.isEmpty()){
	                  break;
	              }	
	              q.enqueue(null);
	              continue;
	          }
	            else{
	              if(temp.left!=null)
	              q.enqueue(temp.left);
	              // insert the childrens
	             if(temp.right!=null)
	             q.enqueue(temp.right);
	             
	             LinkedListNode<Integer> ans1= new LinkedListNode<Integer>(temp.data);
	             if(head==null){
	             // check if this is the first node and if it is then we assign the both variables to ans1
	                 head=ans1;
	                 tail=ans1;
	             }
	             else{
	             // we are using tail 
	             // if we dont use the tail then we have to traverse the linked list again which make the algo worthless
	                 tail.next=ans1;
	                 tail=tail.next;
	             }
	         }
	     }
	    return arr;	
	}
   public static BinaryTreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		QueueUsingLL<BinaryTreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if (rootData == -1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootData);
		pendingNodes.enqueue(root);
		
		while (!pendingNodes.isEmpty()) {
			BinaryTreeNode<Integer> front;
			try {
				front = pendingNodes.dequeue();
			} catch (QueueEmptyException e) {
				return null;
			}
			System.out.println("Enter left child of " + front.data);
			int leftChild = s.nextInt();
			if (leftChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(leftChild);
				pendingNodes.enqueue(child);
				front.left = child;
			}
			
			System.out.println("Enter right child of " + front.data);
			int rightChild = s.nextInt();
			if (rightChild != -1) {
				BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(rightChild);
				pendingNodes.enqueue(child);
				front.right = child;
			}
		}
		return root;
	}
	
   private static void print(LinkedListNode<Integer> temp)
	{
		while(temp != null){
			System.out.print(temp.data + " ") ;
			temp = temp.next;
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		ArrayList<LinkedListNode<Integer>> output = constructLinkedListForEachLevel(root);
		if(output!=null)
		{
			for(LinkedListNode<Integer> head : output){
				print(head);
				
			}
		}	}
}
class LinkedListNode<T> {

	T data;
	LinkedListNode<T> next;

	public LinkedListNode(T data) {
		this.data = data;
}
}