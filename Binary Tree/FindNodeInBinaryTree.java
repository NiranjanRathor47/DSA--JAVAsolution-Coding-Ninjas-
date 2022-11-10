import java.util.Scanner;

public class FindNodeInBinaryTree {

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

	public static boolean isNodePresent(BinaryTreeNode<Integer> root, int x) {
		if(root==null) {
			return false;
		}
		if(root.data==x) {
			return true;
		}
		boolean rigth = false;
		boolean left = false;
		if(root.left!=null) {
			if(root.left.data==x) {
				return true;
			}
		left = isNodePresent(root.left,x);
		}
		if(root.right!=null) {
			if(root.right.data==x) {
				return true;
			}
			rigth = isNodePresent(root.right,x);			
		}
        if(left==true) {
        	return true;
        }
		if(rigth==true) {
			return true;
		}
		return false ;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		int x = s.nextInt();
		boolean res = isNodePresent(root,x);
		System.out.print(res);
	}
}
