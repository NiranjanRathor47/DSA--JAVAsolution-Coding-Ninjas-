import java.util.Scanner;

public class BSTClassInDifferentway {

	public static BinaryTreeNode<Integer> root;
	
	private static BinaryTreeNode<Integer> deleteHelper(BinaryTreeNode<Integer> root,int data){
		if(root==null) {
			return null;
		}
		if(root.data==data) {
			if(root.left!=null && root.right==null) {
				return root.left;
			}
			else if(root.left==null && root.right!=null) {
				return root.right;
			}
			else if(root.left==null && root.right==null) {
				return null;
			}
			else {
				  BinaryTreeNode<Integer> minNode = root.right;
	                while (minNode.left != null) {
	                    minNode = minNode.left;
	                }
	                root.data = minNode.data;
	                root.right = deleteHelper(root.right,minNode.data);
	                return root;
			}
		}
		else if(root.data<data) {
			BinaryTreeNode<Integer> rightNode = deleteHelper(root.right,data);
			root.right = rightNode;
		}
		else {
			BinaryTreeNode<Integer> leftNode = deleteHelper(root.left,data);
			root.left = leftNode;
		}
		return root;
		
	}

	public static void Delete(int data) {
		root = deleteHelper(root,data);
	}
	
	private static BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> root,int data){
		if(root==null) {
			BinaryTreeNode<Integer> newnode = new BinaryTreeNode<>(data);
			return newnode;
		}
		if(root.data>=data) {
			root.left = insertHelper(root.left,data);
		}
		else {
			root.right= insertHelper(root.right,data);
		}
		return root;
	}
	
	public static void insert(int data) {
		  root = insertHelper(root,data);
	}
	
    private static boolean searchHelper(int data,BinaryTreeNode<Integer> root) {
	if(root==null) {
		return false;
	}
	if(root.data==data) {
		return true;
	}
	else if(data>root.data) {
		return searchHelper(data,root.right);
	}
	else {
		return searchHelper(data,root.left);
	}		
	}
	
	public static boolean search(int data) {
		return searchHelper(data,root);
	}
	
	private static void printHelper(BinaryTreeNode<Integer> root){
		if (root == null) {
			return;
		}
		System.out.print(root.data + ":");
		if(root.left!=null)
	            System.out.print("L:"+root.left.data+",");
	    if(root.right!=null){
	            System.out.print("R:"+root.right.data);
	     }
	    System.out.println();
		printHelper(root.left);
		printHelper(root.right);
	}
	
	public static void printTree(){
	        printHelper(root);
	        return;
	    }
  
	public static void main(String[] args) {
	  Scanner s = new Scanner(System.in);
	  BinaryTreeNode<Integer> bst = new BinaryTreeNode<Integer>(null);
			int choice, input;
			int q = s.nextInt();
			while (q-- > 0) {
				choice = s.nextInt();
				switch (choice) {
				case 1:
					input = s.nextInt();
					insert(input);
					break;
				case 2:
					input = s.nextInt();
					Delete(input);
					break;
				case 3:
					input = s.nextInt();
					System.out.println(search(input));
					break;
				default:
				    printTree();
					break;
				}

			}
		}



}
