import java.util.Scanner;

public class ConstructTreeFromPostorderAndInorder {

	public static BinaryTreeNode<Integer> help(int[] post,int[] in,int inS,int inE,int postS,int postE){
	       if(inS > inE) 
	         return null;
	        
	        int root=post[postE];
	        BinaryTreeNode<Integer> ans=new BinaryTreeNode<Integer>(root);
	        int index=-1;
	        for(int i=0;i<in.length;i++){
	            if(in[i]==root){
	                index=i;
	                break;
	            }
	        }
	        if(index==-1){
	          return null;  
	        }
	        int leftInS =inS;
	        int leftInE =index-1;
	        int leftpostS=postS;
	        int leftpostE=leftpostS+leftInE-leftInS;
	        
	        int rightInS=index+1;
	        int rightInE=inE;
	        int rightpostS=leftpostE+1;
	        int rightpostE=postE-1;
	        // the main problem is created by leftPreE
	        // the actual concept is leftpreE-leftpreS=rightpreE-rightpreS;
	        ans.left= help(post, in, leftInS, leftInE, leftpostS, leftpostE);
	        ans.right=help(post, in, rightInS, rightInE, rightpostS, rightpostE);
	        return ans;    
	    } 
		public static BinaryTreeNode<Integer> buildTree(int[] postorder, int[] inOrder) {
			 return help(postorder,inOrder,0,inOrder.length-1,0,postorder.length-1);
		}
		
public static void printLevelWise(BinaryTreeNode<Integer> root) {	
			QueueUsingLL<BinaryTreeNode<Integer>>  pendingNodes = new QueueUsingLL<>();
			pendingNodes.enqueue(root);
	        pendingNodes.enqueue(null);

			while(!pendingNodes.isEmpty()) {
				BinaryTreeNode<Integer> frontNode = null ;
				try {
					frontNode = pendingNodes.dequeue();
				} catch (QueueEmptyException e) {
					return ;
				}	
		        if (frontNode == null) {
		            System.out.println();

		            if (!pendingNodes.isEmpty()) {
		                pendingNodes.enqueue(null);
		            }
		        } else {
		        	System.out.print(frontNode.data + " ");

		            if (frontNode.left != null) {
		                pendingNodes.enqueue(frontNode.left);
		            } 

		            if (frontNode.right != null) {
		                pendingNodes.enqueue(frontNode.right);
		            } 
		        }	}
		}

	public static Pair3 takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int post[] = new int[n];
    	int in[] = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		post[i]= s.nextInt();
		}
    	for(int i=0;i<n;i++) {
		in[i]= s.nextInt();	
		}
    	return new Pair3(post,in);
	}
	
	public static void main(String[] args) {
		Pair3 input = takeInput();

		int[] postorder = input.postorder;
    	int[] inOrder = input.inOrder;
    	
    	BinaryTreeNode<Integer> root = buildTree(postorder, inOrder);
	
    	printLevelWise(root);
	}
}
class Pair3 {
	int[] postorder;
	int[] inOrder;

	public Pair3(int[] postorder, int[] inOrder) {
		this.postorder = postorder;
		this.inOrder = inOrder;
	}

}




