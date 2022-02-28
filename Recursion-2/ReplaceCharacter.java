import java.util.Scanner;

public class ReplaceCharacter {

     public static String replaceCharacter(String input, char c1, char c2) {
    	 if(input.length()==0) {
 			return input ;
 		}
    	 char ans = input.charAt(0);
 		if (input.charAt(0) == c1) {
 			ans =  c2 ;
 			input = c2 + input.substring(1) ;
 		}
 		return ans + replaceCharacter(input.substring(1),c1,c2);
	 }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine(); 
        char c1 = s.next().charAt(0);
        char c2 = s.next().charAt(0);
        String res = replaceCharacter(str.substring(0),c1,c2);
        System.out.print(res);
	}

}
