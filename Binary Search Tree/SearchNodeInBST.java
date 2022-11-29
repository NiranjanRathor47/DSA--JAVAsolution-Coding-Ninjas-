import java.util.Scanner;

public class SearchNodeInBST {

   public static boolean searchInBST(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return false;
		}
		boolean ans1 =false,ans2=false;
		if(k==root.data) {
			return true;
		}
		if(k>root.data) {
			 ans1 = searchInBST(root.right,k);
		}
		if(k<root.data) {
			 ans2 = searchInBST(root.left,k);
		}
		if(ans1==true) {
			return true;
		}
		if(ans2==true) {
			return true ;
		}
		return false;
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
		int k = s.nextInt();
		boolean res = searchInBST(root,k);
		System.out.println(res);
	}
}
