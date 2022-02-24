import java.util.Scanner;

public class PrintNumbers {
	public static void print(int n){
       	if(n == 1){
			System.out.print(n + " ");
			return;
		}
       	print(n-1);
		System.out.print(n + " ");
	}
    
    	public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	         int n = s.nextInt();
         
	        print(n);
		}
}
