package Assignment;
import java.util.Scanner;
public class ReturnPermutationsString {
	public static String[] permutationOfString(String input){
		// Write your code here
        if(input.length() == 0){
            String y[] = {""};
            return y;
        }
        
        String [] ans = permutationOfString(input.substring(1));
      //  char ch = input.charAt(0);
		String output[] = new String[ans.length*input.length()];
        
        int k=0;
        for(int i=0;i<ans.length;i++){
            
            for(int j=0;j<=ans[i].length();j++){
                output[k++] = ans[i].substring(0,j) + input.charAt(0) + ans[i].substring(j);
            }
        }
        
        return output;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		String output[] = permutationOfString(input);
		for(int i = 0; i < output.length; i++) {
			System.out.println(output[i]);
		}
	}
}
