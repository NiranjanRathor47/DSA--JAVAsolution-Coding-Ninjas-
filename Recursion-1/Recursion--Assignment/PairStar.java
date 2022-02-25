package Recrusion1Assignment;

import java.util.Scanner;

public class PairStar {
 
	 static String output = "";
	public static String addStars(String s) {
		return addStars(s,0);
	}
	private static String addStars(String s,int i) {
		  output = output + s.charAt(i);
		  
		    if (i == s.length() - 1)
		        return "";
		 
		    if (s.charAt(i) == s.charAt(i+1))
		        output = output + '*';    
		 
		    addStars(s, i+1);
		    
		    return output ;
	}
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
			  String ans = addStars(str);
			System.out.println(ans); 

	}
}
