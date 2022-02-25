package Recrusion1Assignment;

import java.util.Scanner;

public class ReplacePi {

	public static String replace(String input){
		if(input.length()<=1) {
			return input ;
		}
	    if(input.charAt(0)=='p'&& input.length()>=2 && input.charAt(1)=='i'){
	    	return "3.14" + replace(input.substring(2,input.length()));
	    }
	    return input.charAt(0) + replace(input.substring(1,input.length()));
	}
	public static void main(String[] args) {		
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
			  String ans = replace(str);
			System.out.println(ans);
	}

}
