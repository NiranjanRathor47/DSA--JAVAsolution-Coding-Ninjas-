import java.util.Scanner;

public class Does_c_Contain_t {

	public static boolean checkSequence(String a, String b) {
		
		if( b.length()==0) {
			return true;
		}
		 if(a.length() == 0){
	            return false;
	        }
	        if(a.charAt(0) == b.charAt(0)){
	            a = a.substring(1);
	            b = b.substring(1);
	        }else{
	            a = a.substring(1);
	        }
	        
	        boolean ans = checkSequence(a,b);

	        return ans;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String input1 = s.nextLine();
		boolean res = checkSequence(input,input1);
		System.out.print(res);
	}
}
