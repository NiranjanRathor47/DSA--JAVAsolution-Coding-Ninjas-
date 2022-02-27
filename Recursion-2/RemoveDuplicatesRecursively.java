import java.util.Scanner;

public class RemoveDuplicatesRecursively {

	public static String removeConsecutiveDuplicates(String s) {
		if(s.length()<=1) {
			return s ;
		}
	    if(s.charAt(0)== s.charAt(1) && s.length()>=2 ){
	    	return  removeConsecutiveDuplicates(s.substring(1));
	    }
	    return s.charAt(0) + removeConsecutiveDuplicates(s.substring(1));
	}
	public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			String str = s.nextLine(); 
			  String ans = removeConsecutiveDuplicates(str);
			System.out.println(ans);
	}

}
