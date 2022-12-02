package Assignment;
import java.util.Arrays;
import java.util.Scanner;

public class PairSumBinaryTree {

    public static int [] arrayInsert(BinaryTreeNode<Integer> root) {
		if(root==null) {
	     int [] arr = new int[0];
	     return arr;
		}
		int currdata = root.data;
		int jarr [] = arrayInsert(root.left);
		int karr [] = arrayInsert(root.right);
		int finalarr [] = new int [1+jarr.length+karr.length];
		
		int x =0;
		finalarr[x] = currdata;
		x++;
		for(int i=0;i<jarr.length;i++) {
			finalarr[x] = jarr[i];
			x++;
		}
		for(int i=0;i<karr.length;i++) {
			finalarr[x] = karr[i];
			x++;
		}
		return finalarr;
	}
	public static void pairSum(BinaryTreeNode<Integer> root, int sum) {
	    if(root==null) {
	    	return ;
	    }
	    int arr[] = arrayInsert(root);
	    Arrays.sort(arr);
	    for(int i=0;i<arr.length;i++) {
	    	for(int j=i+1;j<arr.length;j++) {
	    		if(arr[i] + arr[j] == sum) {
	    			System.out.println(arr[i] + " " + arr[j]);
	    		}
	    	}
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
			int sum = s.nextInt();
			pairSum(root,sum);
	  }
}
class BinaryTreeNode<T> {
	 
	public BinaryTreeNode( T data){
		this.data = data;
	}
	public T data ;
	public BinaryTreeNode<T> left ;
	public BinaryTreeNode<T> right;
}
