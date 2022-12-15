import java.util.Scanner;
import java.util.ArrayList;

public class RemoveLeafNodesInTree {

public static TreeNode<Integer> removeLeafNodes(TreeNode<Integer> root) {
	if(root==null) {
		return null;
	}
	if (root.children.size() == 0){
	      root = null;
	      return root;
	}
	for(int i=root.children.size()-1 ; i >= 0 ; i--){
	       if (removeLeafNodes(root.children.get(i)) == null){
	            root.children.remove(root.children.get(i));
	     }
	}
	return root;
		
	}
public static TreeNode<Integer> takeInputLevelWise() {
	Scanner s= new Scanner(System.in);
	System.out.println("Enter root data");
	int rootData = s.nextInt();
	QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<>();
	TreeNode<Integer> root = new TreeNode<Integer>(rootData);
	pendingNodes.enqueue(root);
	while (!pendingNodes.isEmpty()) {
			try {
				TreeNode<Integer> frontNode = pendingNodes.dequeue();
				System.out.println("enter num of children of " + frontNode.data);
				int numchildren = s.nextInt();
				for(int i=0;i<numchildren;i++) {
					System.out.println("enter " + (i+1) + "Ith child of " + frontNode.data);
					int child = s.nextInt();
					TreeNode<Integer> childnode = new TreeNode<>(child);
					frontNode.children.add(childnode);
					pendingNodes.enqueue(childnode);
				}
			} catch (QueueEmptyException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
	}
	return root;
}


 public static void print( TreeNode<Integer> root) {
	if(root == null) {
		return;
	}
	QueueUsingLL<TreeNode<Integer>> pendingNodes = new QueueUsingLL<TreeNode<Integer>>(); 
	pendingNodes.enqueue(root);
	pendingNodes.enqueue(null);
	while(!pendingNodes.isEmpty()){
		TreeNode<Integer> currentNode = null;
		try {
			currentNode = pendingNodes.dequeue();
		} catch (QueueEmptyException e) {
			e.printStackTrace();
		}
		if(currentNode == null) {
			if(pendingNodes.isEmpty()) {
				break;
			}
			System.out.println();
			pendingNodes.enqueue(null);
			continue;
		}
		System.out.print(currentNode.data + " ");
		int numChild = currentNode.children.size();
		for(int i = 0 ; i < numChild; i++){
			pendingNodes.enqueue(currentNode.children.get(i));
		}
	}
}
 
 public static void main(String[] args) {
	TreeNode<Integer> root = takeInputLevelWise();
	root = removeLeafNodes(root);
	print(root);
   }
}

class TreeNode<T> {
	T data;
	ArrayList<TreeNode<T>> children;

	TreeNode(T data){
		this.data = data;
		children = new ArrayList<TreeNode<T>>();
	} }
