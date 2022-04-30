package StackS;
import java.util.Scanner;
import java.util.Stack;
public class CodeBalancedParenthesis {

	 public static boolean isBalanced(String expression) {
	        Stack<Character> s = new Stack<>();
	        for(int i=0;i<expression.length();i++){
	        	char x = expression.charAt(i);
	        	if(x=='[' || x=='{' || x=='(') {
	        		s.push(x);
	        		 continue;
	        	}
	        	 if (s.isEmpty())
	                 return false;
	             char check;
	             switch (x) {
	             case ')':
	                 check = s.pop();
	                 if (check == '{' || check == '[')
	                     return false;
	                 break;
	  
	             case '}':
	                 check = s.pop();
	                 if (check == '(' || check == '[')
	                     return false;
	                 break;
	  
	             case ']':
	                 check = s.pop();
	                 if (check == '(' || check == '{')
	                     return false;
	                 break;
	             }
	        }
	        return s.size()==0?true:false;
	    }
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
		boolean res = isBalanced(str);
        System.out.print(res);
	}

}
