package Assignment;
import java.util.Scanner;
import java.util.HashMap;

public class ExtractUniqueCharacters {

	
	public static String uniqueChar(String str){
		HashMap<Character,Boolean> h = new HashMap<>();
		String s = "";
		for(int i=0;i<str.length();i++) {
			if(h.containsKey(str.charAt(i))) {
				continue;
			}
			else {
				h.put(str.charAt(i), true);
				s = s + str.charAt(i);
			}
		}
		return s ;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String str = s.nextLine();
		String res = uniqueChar(str);
		System.out.print(res);
	}
}
