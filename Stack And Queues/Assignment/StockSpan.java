package Assignment;
import java.util.Stack;
//import java.util.Arrays;
import java.util.Scanner;

public class StockSpan {

	 public static int[] stockSpan(int[] price) {
   	  Stack<Integer> st = new Stack<>();
         st.push(0);
 
       int S[] = new int [price.length];
         S[0] = 1;
 
 
         for (int i = 1; i < price.length; i++) {
 
          
             while (!st.empty() && price[st.peek()] <= price[i])
                 st.pop();
 
        
//             S[i] = (st.empty()) ? (i + 1) : (i - st.peek());
             if(st.isEmpty()){
	        	  S[i]=i+1 ;
	               }
	           else{
	        	   S[i]=i-st.peek();
	               }
 
            // Push this element to stack
             st.push(i);
         }
         return S;
  	}  
//	 public static int[] stockSpan(int[] price) {
//	        Stack<Integer> stack = new Stack<>();
//	        int n = price.length;
//
//	        int[] output=new int[n];
//	        stack.push(0);
//	        output[0] = 1;
//	        for(int i=1;i<n;++i) {
//	          while(!stack.isEmpty() && output[stack.peek()]<output[i]) {
//	        	  stack.pop(); 
//	          }	                 
//	          if(stack.isEmpty()){
//	        	  output[i]=i+1 ;
//	               }
//	           else{
//	        	   output[i]=i-stack.peek();
//	               }
//	            // Push this element to stack 
//	          stack.push(i); 
//	               }
//	        return output;
//		}
//	 
	
    public static int[] takeinput() {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt(); 
    	int arr[]= new int [n];
    	for(int i=0;i<n;i++) {
    		arr[i]= s.nextInt();
    	}
    	return arr;
    }
    public static void printArray(int[] arr) {
    	for (int i = 0 ; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}

    	System.out.println();
    }
	public static void main(String[] args) {
		int price[] = takeinput();
		int R[] = stockSpan(price);
		
		printArray(R);
	}

}
