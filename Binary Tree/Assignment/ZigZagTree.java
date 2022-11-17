package Assignment;

import java.util.Scanner;
import java.util.Stack;

public class ZigZagTree {

	public static void printZigZag(BinaryTreeNode<Integer> root){
		if(root==null) {
	    	   return ;
	       }
	       Stack<BinaryTreeNode> curl = new Stack<BinaryTreeNode>();
	       Stack<BinaryTreeNode> nexl = new Stack<BinaryTreeNode>();
	       curl.push(root);
	       boolean leftToRight = true;
	       while(!curl.isEmpty()) {
	    	   BinaryTreeNode<Integer> temp = curl.pop();
	    	   if(temp!=null) {
	    		   System.out.print(temp.data + " ");
	    		   if(leftToRight) {
	    			    if(temp.left!=null) {
	    			    	nexl.push(temp.left);
	    			    }
	    			    if(temp.right!=null) {
	    			    	nexl.push(temp.right);
	    			    }
	    		   }
	    		   else {
	    			    if(temp.right!=null) {
	    			    	nexl.push(temp.right);
	    			    }
	    			    if(temp.left!=null) {
	    			    	nexl.push(temp.left);
	    			    }
	    		   }
	    	   }
	    	   if(curl.isEmpty()) {
	    		   System.out.println();
	    		   leftToRight = !leftToRight;
	    		   Stack<BinaryTreeNode> temp1 = curl;
	    		   curl = nexl;
	    		   nexl = temp1;
	    	   }
	    	   } 
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
	
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printZigZag(root);
	}
}
