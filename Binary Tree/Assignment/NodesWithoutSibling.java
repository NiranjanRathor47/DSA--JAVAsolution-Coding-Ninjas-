package Assignment;

import java.util.Scanner;

public class NodesWithoutSibling {

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
    
	public static void printNodesWithoutSibling(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		 if (root.left != null && root.right != null) {
				printNodesWithoutSibling(root.left);
				printNodesWithoutSibling(root.right);
				 }
		 else if(root.left!=null ) {
			System.out.print(root.left.data + " ");
			printNodesWithoutSibling(root.left);
		}
		else if(root.right!=null ) {
				System.out.print(root.right.data + " ");
				printNodesWithoutSibling(root.right);
	    }
		
	}
	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printNodesWithoutSibling(root);
	}
}
