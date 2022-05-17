package Assignment;

import java.util.Scanner;
import java.util.Stack;

public class CheckRedundantBrackets {

	public static boolean checkRedundantBrackets(String expression) {
		 Stack<Character> s = new Stack<>();
	        char[] str = expression.toCharArray();
	     
	        for (char ch : str) {
	        	//	        for(char i=0;i<str.length;i++) {
	            if (ch == ')') {
	                char top = s.peek();
	                s.pop();
	                
	                boolean flag = true;
	                while (top != '(') {
	               	if (top == '+' || top == '-'|| top == '*' || top == '/') {
	                        flag = false;
	                    }
	                    top = s.peek();
	                    s.pop();
	                }	
	                if (flag == true) {
	                    return true;
	                }
	            } else {
	                s.push(ch);
	            }                
	        }
	        return false;
	}
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
		boolean res = checkRedundantBrackets(str);
        System.out.print(res);
	}

}
