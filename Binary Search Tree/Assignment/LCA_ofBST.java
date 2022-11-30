package Assignment;

import java.util.Scanner;

public class LCA_ofBST {

	public static BinaryTreeNode<Integer> helper(BinaryTreeNode<Integer> root,int a,int b){
		if(root==null || root.data==a || root.data==b) {
			return root;
		}
		if(root.data<a && root.data<b) {
			return helper(root.right,a,b);
		}
		if(root.data>a && root.data>b) {
			return helper(root.left,a,b);
		}
		BinaryTreeNode<Integer> lnode = helper(root.left,a,b);
		BinaryTreeNode<Integer> rnode = helper(root.right,a,b);
		
		if(lnode!=null && rnode!=null) {
			return root;
		}
		if(lnode!=null) {
			return lnode;
		}
		return rnode;
	}
	public static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		BinaryTreeNode<Integer> node = 	helper(root,a,b);      
		return (node==null) ? -1 : node.data;
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
			int a = s.nextInt();
			int b = s.nextInt();
			int ans = getLCA(root,a,b);
			System.out.print(ans);
	  }
}
