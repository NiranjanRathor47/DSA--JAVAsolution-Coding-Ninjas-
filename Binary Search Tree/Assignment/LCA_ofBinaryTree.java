package Assignment;

import java.util.Scanner;

public class LCA_ofBinaryTree {

	   static int getLCA(BinaryTreeNode<Integer> root, int a, int b) {
		   if(root==null){
	            return -1;
	        }
	       if(root.data==a || root.data==b){
	           return root.data;
	       }
	       int lnode = getLCA(root.left,a,b);
	       int rnode = getLCA(root.right,a,b);
	       if(lnode!=-1 && rnode!=-1){
	           return root.data;
	       }
	       else if(lnode!=-1){
	           return lnode;
	       }
	       else{
	           return rnode;
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
		    Scanner s = new Scanner(System.in);
			BinaryTreeNode<Integer> root = takeInputLevelWise();
			int a = s.nextInt();
			int b = s.nextInt();
			int ans = getLCA(root,a,b);
			System.out.print(ans);
	  }
}
