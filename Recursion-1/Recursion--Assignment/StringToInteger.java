package Recrusion1Assignment;

import java.util.Scanner;

public class StringToInteger {

	public static int convertStringToInt(String input){
		if(input.length()== 1) {
			  return (input.charAt(0) - '0');
		}
		double y = convertStringToInt(input.substring(1));
		double x = input.charAt(0) - '0';
		
		  x = x * Math.pow(10, input.length() - 1) + y;
	        return (int)(x);
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(); 
        int ans = convertStringToInt(str);
        System.out.println(ans);
	}

}
