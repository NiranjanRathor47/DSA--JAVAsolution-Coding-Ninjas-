package Assignment;
import java.util.Scanner;
public class PrintPermutations {
	public static void FindPermutations(String str) {
		// Write your code here
             print(str,"");
	}
    public static void print(String input,String output){
        if(input.length() == 0){
            System.out.println(output);
            return;
        }
        
        for(int i=0;i<input.length();i++){
            String str = input.substring(0,i) + input.substring(i+1,input.length());    
            print(str , output + input.charAt(i));
        }
        
        // input = input.substring(1);
        // print(input,output); 
    }
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String input = s.nextLine();
		FindPermutations(input);
	}
}
