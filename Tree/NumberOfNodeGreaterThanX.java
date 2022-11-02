import java.util.Scanner;

public class NumberOfNodeGreaterThanX {

	public static int numNodeGreater(TreeNode<Integer> root,int x){
		if(root==null) {
			return 0;
		}
		int count = 0;
		if(root.data>x) {
			count++;
		}
		for(int i=0;i<root.children.size();i++) {
			count = count + numNodeGreater(root.children.get(i),x);
		}
		return count ;
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
		int x = s.nextInt();
	    TreeNode<Integer> root =  takeInputLevelWise();
	    int res = numNodeGreater(root,x); 
	    System.out.println(res);

		}
}
