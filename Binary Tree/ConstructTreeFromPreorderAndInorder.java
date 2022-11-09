import java.util.Scanner;
import java.util.Queue;

public class ConstructTreeFromPreorderAndInorder {

	 public static BinaryTreeNode<Integer> help(int[] pre,int[] in,int inS,int inE ,int preS ,int preE){
	      if(inS>inE) {
	    	  return null;
	      }
	      int rootdata = pre[preS];
	      BinaryTreeNode<Integer> root = new BinaryTreeNode<Integer>(rootdata);
	      int rootIndex = -1;
	      for(int i=inS;i<=inE;i++) {
	    	  if(in[i]==rootdata){
	    		  rootIndex = i ;
	    		  break;
	    	  }
	      }
	      if(rootIndex==-1) {
	    	  return null;
	      }      
	      int leftInS = inS;
	      int leftInE = rootIndex -1;
	      int leftPreS = preS + 1 ;
	      int leftPreE = leftInE - leftInS + leftPreS ;
	      int RightInS = rootIndex + 1;
	      int RightInE = inE;
	      int RightPreS = leftPreE +1;
	      int RightPreE = preE;
	      
	       root.left = help(pre,in,leftInS,leftInE,leftPreS,leftPreE);
	      root.right = help(pre,in,RightInS,RightInE,RightPreS,RightPreE);
	      return root;
	     } 
	
	public static BinaryTreeNode<Integer> buildTree(int[] preOrder, int[] inOrder) {
			 return help(preOrder,inOrder,0,inOrder.length-1,0,preOrder.length-1);
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
		        }
			}
		}

	public static pair takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		
		int pre[] = new int[n];
    	int in[] = new int[n];
    	
    	for(int i=0;i<n;i++) {
    		pre[i]= s.nextInt();
		}
    	for(int i=0;i<n;i++) {
		in[i]= s.nextInt();	
		}
    	return new pair(pre,in);
	}
	
	public static void main(String[] args) {
		pair input = takeInput();

    	int[] preOrder = input.preOrder;
    	int[] inOrder = input.inOrder;

    	BinaryTreeNode<Integer> root = buildTree(preOrder, inOrder);
	
    	printLevelWise(root);
	}
}
class pair {
	int[] preOrder;
	int[] inOrder;

	public pair(int[] preOrder, int[] inOrder) {
		this.preOrder = preOrder;
		this.inOrder = inOrder;
	}

}

    

