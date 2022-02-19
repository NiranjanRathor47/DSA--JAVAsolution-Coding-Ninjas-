import java.util.Scanner;

public class CheckPalindrome {

    public static boolean isStringPalindrome(String input) {
    	if(input.length()==0 || input.length()==1) {
    		return true ;
    	}
		   return isStringPalindrome(input,0,input.length()-1);
	  }
    private static boolean isStringPalindrome(String input,int start,int end) {
		   if(start==end) {
			   return true ;
		   }
		   if (input.charAt(start) != input.charAt(end)) {
               return false ;
               } 
		   if (start < end + 1)
	            return isStringPalindrome(input, start + 1, end - 1);
	 
	        return true;
	  }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(); 
		  boolean ans = isStringPalindrome(str);
		System.out.println(ans);
	}

}
