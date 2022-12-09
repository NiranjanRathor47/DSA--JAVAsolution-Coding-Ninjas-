import java.util.ArrayList;
import java.util.Scanner;

public class LongestLeafToRootPath {

	public static ArrayList<Integer> longestRootToLeafPath(BinaryTreeNode<Integer> root){
		if(root==null) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			return output;
		}
		
		ArrayList<Integer> leftoutput = longestRootToLeafPath(root.left);
		ArrayList<Integer> rightoutput = longestRootToLeafPath(root.right);

		if(leftoutput.size()>rightoutput.size()) {
			leftoutput.add(root.data);
		}
		else {
			rightoutput.add(root.data);
		}
		
         return (leftoutput.size()>rightoutput.size() ?leftoutput : rightoutput);
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
    ArrayList<Integer> res = longestRootToLeafPath(root);
	for(int i=0;i<res.size();i++) {
		 int curr = res.get(i);

		  System.out.println(curr);
	}
}}
