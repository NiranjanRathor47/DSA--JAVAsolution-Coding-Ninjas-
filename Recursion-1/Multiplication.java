import java.util.Scanner;

public class Multiplication {
	public static int multiplyTwoIntegers(int m, int n){ 
        if (m==0 || n==0)
            return 0;
     
            return (m + multiplyTwoIntegers(m, n - 1));
    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt(); 
		int n = s.nextInt(); 
		
       int res = multiplyTwoIntegers(m,n);
       System.out.print(res);
	}

}
