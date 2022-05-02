package StackS;
import java.util.Stack;

public class StackCollections {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int arr[] = {9,0,3,5};
		for(int i=0;i<arr.length;i++) {
			stack.push(arr[i]);
		}
		while(!stack.empty()) {
			System.out.println(stack.peek());
			stack.pop();
		}
	}
}
