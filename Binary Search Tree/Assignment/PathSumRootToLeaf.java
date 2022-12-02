package Assignment;

import java.util.Scanner;

public class PathSumRootToLeaf {
 
	public static void helper(BinaryTreeNode<Integer> root,int k ,String s) {
		if(root==null) {
			return ;
		}
		if(root.left==null && root.right==null && root.data==k) {
			System.out.println(s+root.data);
			return ;
		}
		s = s + root.data + " ";
		helper(root.left,k-root.data,s);
		helper(root.right,k-root.data,s);
	}
	public static void rootToLeafPathsSumToK(BinaryTreeNode<Integer> root, int k) {
	    helper(root,k,"");
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
		    Scanner s = new Scanner(System.in);
			BinaryTreeNode<Integer> root = takeInputLevelWise();
			int sum = s.nextInt();
			rootToLeafPathsSumToK(root,sum);
	  }
}
