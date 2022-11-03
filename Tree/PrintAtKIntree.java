import java.util.Scanner;

public class PrintAtKIntree {

	public static void PrinrAtK(TreeNode<Integer> root,int k) {
		if(k<0) {
			return ;
		}
		if(k==0) {
			System.out.println(root.data);
			return ;
		}
		for(int i=0;i<root.children.size();i++) {
			PrinrAtK(root.children.get(i),k-1);
		}
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
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
	    TreeNode<Integer> root =  takeInputLevelWise();
	    PrinrAtK(root,k); 
	    
		}
}
