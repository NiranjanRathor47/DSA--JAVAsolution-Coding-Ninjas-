import java.util.Scanner;

public class ConstructBST_FromSorteArray {

	private static BinaryTreeNode<Integer> helper(int []arr,int si,int ei){
		 if(si>ei) {
			   return null;
		   }
		   int mid = (si+ei)/2;
		   BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		   root.left = helper(arr,si,mid-1);
		   root.right = helper(arr,mid+1,ei);
      
		   return root;
	}
	public static BinaryTreeNode<Integer> SortedArrayToBST(int[] arr, int n){
		return helper(arr,0,n-1);
		}		  
	private static void preOrder(BinaryTreeNode<Integer> root) {
		if (root == null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int len = s.nextInt();
		int arr[] = new int[len];
		for(int i=0;i<len;i++) {
			arr[i] = s.nextInt();
		}
		BinaryTreeNode<Integer> ans = SortedArrayToBST(arr, len);
		preOrder(ans);
	}
}
