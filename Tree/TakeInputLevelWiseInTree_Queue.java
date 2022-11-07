import java.util.Scanner;

public class TakeInputLevelWiseInTree_Queue {

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
		String s = root.data +":";
		for(int i=0;i<root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	

	public static void main(String[] args) {
		TreeNode<Integer> root = takeInputLevelWise();
		print(root);
	}

}
