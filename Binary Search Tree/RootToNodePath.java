import java.util.ArrayList;
import java.util.Scanner;

public class RootToNodePath {

	public static ArrayList<Integer> getRootToNodePath(BinaryTreeNode<Integer> root,int data){
		if(root==null) {
			return null;
		}
		if(root.data==data) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> leftoutput = getRootToNodePath(root.left,data);
		if(leftoutput!=null) {
			leftoutput.add(root.data);
			return leftoutput;
		}
		ArrayList<Integer> rightoutput = getRootToNodePath(root.right,data);
		if(rightoutput!=null) {
			rightoutput.add(root.data);
			return rightoutput;
		}else {
			return null;
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
		int NodeData = s.nextInt();
	    ArrayList<Integer> res = getRootToNodePath(root,NodeData);
		for(int i=0;i<res.size();i++) {
			 int curr = res.get(i);

			  System.out.print(curr + " ");
		}
	}}