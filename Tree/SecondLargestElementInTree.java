import java.util.Scanner;

public class SecondLargestElementInTree {
	
	public static TreeNode<Integer> largest ;
	public static TreeNode<Integer> secondlargest;
	
    public static void helper(TreeNode<Integer> root){
    	if(root==null) {
    		return ;
    	}
    	if(root.data>largest.data) {
    		secondlargest = largest;
    		largest = root;
    	}
    	else if(root.data>secondlargest.data && root.data!=largest.data) {
    		secondlargest = root;
    	}
    	for(int i=0;i<root.children.size();i++) {
    		helper(root.children.get(i));
    	}
    }
    public static TreeNode<Integer> findSecondLargest(TreeNode<Integer> root){
         largest = new TreeNode<Integer>(Integer.MIN_VALUE);
         secondlargest = largest;
         
         helper(root);
         return secondlargest;
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
	    TreeNode<Integer> res = findSecondLargest(root);
	    System.out.println(res.data);

		}
}
