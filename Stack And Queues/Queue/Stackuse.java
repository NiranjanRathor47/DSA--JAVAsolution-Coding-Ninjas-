package StackS;

public class Stackuse {

	public static void main(String[] args)/* throws StackFullException */{		
		StackUsingArray stack = new StackUsingArray(3);
		for(int i = 1; i <= 5; i++){
			stack.push(i);
		}
		
		while(!stack.isEmpty()){
		//	try {
				System.out.print(stack.pop()+" ");
//			} catch (StackEmptyException e) {
//				// Never reach here
//			}
		}
	}

}
