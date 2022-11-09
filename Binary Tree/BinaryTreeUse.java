
public class BinaryTreeUse {

	public static void main(String[] args) {
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(1);
		BinaryTreeNode<Integer> node1 = new BinaryTreeNode<>(2);
		root.left = node1;
		BinaryTreeNode<Integer> node2 = new BinaryTreeNode<>(3);
		root.right = node2;
		
		System.out.println(root.data);
		System.out.println(node1.data);
		System.out.println(node2.data);

	}
}
