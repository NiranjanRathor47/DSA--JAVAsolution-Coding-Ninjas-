import java.util.ArrayList;
import java.util.Scanner;

public class CheckCousins {
	public static boolean isSibling(BinaryTreeNode<Integer> root,int p ,int q ) {
		if(root==null) {
			return false;
		}
		if(root.left!=null && root.right!=null) {
			if(root.left.data==p && root.right.data==q) {
				return true;
			}
			else if(root.right.data==p && root.left.data==q) {
				return true;
			}
			else {
				return isSibling(root.left,p,q) || isSibling(root.right,p,q);
			}
		}
		if(root.right!=null) {
			return isSibling(root.right,p,q);
		}
		else {
			return isSibling(root.left,p,q);
		}
	}
	public static int depth(BinaryTreeNode<Integer> root,int node) {
		if(root==null) {
			return -1;
		}
		if(node==root.data) {
			return 0;
		}
		int left = depth(root.left,node);
		if(left!=-1) {
			return left+1;
		}
		else {
			int right = depth(root.right,node);
			if(right!=-1) {
				return right+1;
			}
			else {
				return -1;
			}
		}
	}
   public static boolean isCousin(BinaryTreeNode<Integer> root, int p, int q) {
    	        if(root==null) {
    	        	return false;
    	        }
    	    return ((depth(root,p)==depth(root,q)) || (!isSibling(root,p,q)));
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
		int p = s.nextInt();
		int q = s.nextInt();
		System.out.println(isCousin(root, p, q));
	}
}
