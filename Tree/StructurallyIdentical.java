import java.util.Scanner;

public class StructurallyIdentical {

	public static boolean checkIdentical(TreeNode<Integer> root1, TreeNode<Integer> root2){
		 if(root1 == null && root2 == null) 
	          return true;
	      if(root1 == null || root2 == null){ 
	          return false;
	      }
	      if(!root1.data.equals(root2.data))
	      { return false; }
	      if(root1.children.size() != root2.children.size())
	      { return false; } 
	      for(int i = 0; i < root1.children.size(); i++){ 
	          if(!checkIdentical(root1.children.get(i), root2.children.get(i))){ 
	              return false; 
	          }
	      }
	      return true;
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
	    TreeNode<Integer> root1 =  takeInputLevelWise();
	    TreeNode<Integer> root2 =  takeInputLevelWise();
	    boolean res = checkIdentical(root1,root2); 
	    System.out.println(res);

		}
}
