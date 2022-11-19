import java.util.Scanner;

public class BSTtoSortedLinkedList {

	public static Pair helper(BinaryTreeNode<Integer> root) {
		  if(root==null)
	        {
	            Pair output=new Pair();
	            output.head=null;
	            output.tail=null;
	            return output;
	        }
	        Pair lefttree=helper(root.left);
	        LinkedListNode<Integer> newNode=new LinkedListNode<>(root.data);
	        Pair righttree=helper(root.right);
	        Pair output=new Pair();
	       if(lefttree.head!=null)
	       {
	           output.head=lefttree.head;
	           lefttree.tail.next=newNode;
	        
	       }
	        else {
	            output.head=newNode;
	        }
	    newNode.next=righttree.head;
	        if(righttree.head==null)
	        {
	            output.tail=newNode;
	            
	        }
	        else{
	            output.tail=righttree.tail;
	        }
	        return output; 
	}
	public static LinkedListNode<Integer> constructLinkedList(BinaryTreeNode<Integer> root) {
		  Pair ans=helper(root);
	      return ans.head;     
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

	public static void main(String[] args)  {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		LinkedListNode<Integer> head = constructLinkedList(root);
		while(head != null) {
			System.out.print(head.data + " ");
			head = head.next;
		}
	}
}
class LinkedListNode<T>{
	T data;
	LinkedListNode<T> next;
	
	public LinkedListNode(T data) {
		this.data = data;
	}
}
class Pair{
    LinkedListNode<Integer> head;
    LinkedListNode<Integer> tail;
}