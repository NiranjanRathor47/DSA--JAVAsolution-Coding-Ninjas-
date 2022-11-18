import java.util.Scanner;

public class BSTCheck2 {

	public static Pair1<Boolean, Pair1<Integer, Integer>> isBST2(BinaryTreeNode<Integer> root) {
		if (root == null) {
			Pair1<Boolean, Pair1<Integer, Integer>> output = new Pair1<Boolean, Pair1<Integer, Integer>>();
			output.first = true;
			output.second = new Pair1<Integer, Integer>();
			output.second.first = Integer.MAX_VALUE;
			output.second.second = Integer.MIN_VALUE;
			return output;
		}
		Pair1<Boolean, Pair1<Integer, Integer>> leftOutput = isBST2(root.left);
		Pair1<Boolean, Pair1<Integer, Integer>> rightOutput = isBST2(root.right);
		int min = Math.min(root.data, Math.min(leftOutput.second.first, rightOutput.second.first));
		int max = Math.max(root.data, Math.max(leftOutput.second.second, rightOutput.second.second));
		boolean isBST = (root.data > leftOutput.second.second) 
				&& (root.data <= rightOutput.second.first)
				&& leftOutput.first && rightOutput.first;
		Pair1<Boolean, Pair1<Integer, Integer>> output = new Pair1<Boolean, Pair1<Integer, Integer>>();
		output.first = isBST;
		output.second = new Pair1<Integer, Integer>();
		output.second.first = min;
		output.second.second = max;
		return output;
	}
	public static boolean isBst1(BinaryTreeNode<Integer> root) {
		 Pair1 ans=isBST2(root);
	     return (boolean) ans.first;   
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
		boolean res = isBst1(root);
		System.out.println(res);
	}
	
}

class Pair1<T,V>{
	public T first;
	public V second;
}