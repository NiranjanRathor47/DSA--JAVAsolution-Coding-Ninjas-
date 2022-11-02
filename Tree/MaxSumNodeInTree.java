import java.util.Scanner;

public class MaxSumNodeInTree {

	public static int max(TreeNode<Integer> root) {
		int maxsum = root.data;
		for(int i=0;i<root.children.size();i++) {
			maxsum = maxsum + root.children.get(i).data;
		}
		return maxsum ;
	}
	public static TreeNode<Integer> maxSumNode(TreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		int rootsum = max(root);
		TreeNode<Integer> max = root;
		TreeNode<Integer> child;
		int childsum;
		for(int i=0;i<root.children.size();i++) {
		   child = 	maxSumNode(root.children.get(i));
		   childsum = max(root.children.get(i));
		   if(childsum>rootsum) {
			   max = child;
		   }
		}
		return max;		
	}

	public static TreeNode<Integer> takeInputLevelWise() {
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootdata = s.nextInt();
		QueueUsingLL<TreeNode<Integer>> pending = new QueueUsingLL<>();
		TreeNode<Integer> root = new TreeNode<>(rootdata);
		pending.enqueue(root);
		while(!pending.isEmpty()) {
			try {
				TreeNode<Integer> frontnode = pending.dequeue();
				System.out.println("enter num of children "+ frontnode.data);
				int childnum = s.nextInt();
				for(int i=0;i<childnum;i++) {
					System.out.println("enter " + (i+1) +"Ith child of "+frontnode.data);
					int child = s.nextInt();
					TreeNode<Integer> childnode = new TreeNode<>(child);
					frontnode.children.add(childnode);
					pending.enqueue(childnode);					
				}
				
			} catch (QueueEmptyException e) {
				
				return null;
			}
		}
		return root;
	}
	
	

	public static void main(String[] args) {
	    TreeNode<Integer> root =  takeInputLevelWise();
	    TreeNode<Integer> ans = maxSumNode(root); 
	    System.out.println(ans.data);

		}
}
