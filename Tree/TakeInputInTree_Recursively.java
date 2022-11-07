import java.util.Scanner;

public class TakeInputInTree_Recursively {

	public static TreeNode<Integer> takeinput(Scanner s){
		int n ;
		System.out.println("enter next node data");
		n = s.nextInt();
		TreeNode<Integer> root = new TreeNode<>(n);
		System.out.println("enter number of children for " + n);
		int childcount = s.nextInt();
		for(int i=0;i<childcount;i++) {
			 TreeNode<Integer> child = takeinput(s);
			 root.children.add(child);
		}
		return root;
	}
	
	public static void print( TreeNode<Integer> root) {
		String s = root.data +":";
		for(int i=0;i<root.children.size();i++) {
			s = s + root.children.get(i).data + ",";
		}
		System.out.println(s);
		for(int i=0;i<root.children.size();i++) {
			print(root.children.get(i));
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		TreeNode<Integer> root = takeinput(s);
	    print(root);
	}

}
