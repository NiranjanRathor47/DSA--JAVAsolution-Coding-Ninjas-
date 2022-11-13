import java.util.Scanner;

public class TakeInput_Print_InBST {

	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
		    return ;	
		}
		String toBePrinted = root.data + " ";
		if(root.left!=null) {
			toBePrinted += "L:" + root.left.data + "";
		}
		if(root.right!=null) {
			toBePrinted += " R:" + root.right.data ;
		}
		System.out.println(toBePrinted);
		printTree(root.left);
		printTree(root.right);
	}
	public static BinaryTreeNode<Integer> takeInput(Scanner s) {
		int rootdata;
		System.out.println("enter root data ");
		rootdata = s.nextInt();
		if(rootdata==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
		root.left = takeInput(s);
		root.right = takeInput(s);
		return root;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BinaryTreeNode<Integer> root = takeInput(s);
		printTree(root);
		s.close();
	}

}
