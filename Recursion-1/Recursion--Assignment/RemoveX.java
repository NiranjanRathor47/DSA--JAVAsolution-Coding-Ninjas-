package Recrusion1Assignment;

import java.util.Scanner;

public class RemoveX {
	public static String removeX(String input){
		if(input.length()==0) {
			return input;
		}
		if (input.charAt(0) == 'x') {
	        return removeX(input.substring(1));
		}
		return input.charAt(0) + removeX(input.substring(1));
	}
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
			  String ans = removeX(str);
			System.out.println(ans); 
	}

}
