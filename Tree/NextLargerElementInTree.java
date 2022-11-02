import java.util.Scanner;

public class NextLargerElementInTree {

	public static TreeNode<Integer> findNextLargerNode(TreeNode<Integer> root, int n){
         if(root==null) {
        	 return null;
         }
         int rootdata=Integer.MIN_VALUE;    
         TreeNode<Integer> ans = null;
        if(root.data>n) {
        	 rootdata = root.data;
          	ans = root ;
           }
         for(int i=0;i<root.children.size();i++) {
        	 TreeNode<Integer> temp = findNextLargerNode(root.children.get(i),n);
        	 if(temp!=null) {
        		 int tempdata = temp.data;
        		 if(tempdata>n && (rootdata>tempdata || rootdata==Integer.MIN_VALUE )) {
        			 ans = temp;
        			 rootdata = tempdata;
        		 }
        	 }
 		}
         return ans ;
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
		int n = s.nextInt();
	    TreeNode<Integer> root =  takeInputLevelWise();
	    TreeNode<Integer> ans = findNextLargerNode(root,n); 
	    System.out.println(ans.data);

		}
}
