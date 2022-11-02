import java.util.Scanner;

public class FindHeightOfTree {

    public static int getHeight(TreeNode<Integer> root){
		if(root==null) {
			return 0;
		}
		int max =0;
		int childheight =0;
		for(int i=0;i<root.children.size();i++) {
			childheight = getHeight(root.children.get(i));
			if(max<childheight) {
				max = childheight;
			}
		}
		return max+1;
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
	    int res = getHeight(root); 
	    System.out.println(res);

		}
}
