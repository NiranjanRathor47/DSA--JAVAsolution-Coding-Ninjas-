import java.util.Scanner;

public class PrintLevelWiseInTree {

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
	
	public static void printLevelWise(TreeNode<Integer> root){
	  if(root==null) {
		  return ;
	  }
	  QueueUsingLL<TreeNode<Integer>> q = new QueueUsingLL<>();
	  TreeNode<Integer> nullnode = new TreeNode<>(Integer.MIN_VALUE);
	  q.enqueue(root);;
	  q.enqueue(nullnode);
	  System.out.println(root.data);
	  while(q.size()!=1) {
		  TreeNode<Integer> temp= null; 
		  try {
			temp = q.dequeue();
		} catch (QueueEmptyException e) {
			return ;
		}
		  if(temp==nullnode) {
			  q.enqueue(nullnode);
			  System.out.println();
		  }
		  for(int i=0;i<temp.children.size();i++) {
			  System.out.print(temp.children.get(i).data+" ");
			  q.enqueue(temp.children.get(i));   
		  }
	  }	  
}


public static void main(String[] args) {
	TreeNode<Integer> root = takeInputLevelWise();
	printLevelWise(root);
}

}
