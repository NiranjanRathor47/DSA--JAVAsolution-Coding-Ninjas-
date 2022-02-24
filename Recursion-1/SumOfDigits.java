import java.util.Scanner;

public class SumOfDigits {

	public static int sumOfDigits(int input){
		if(input==0) 
		{
			return 0;
		}
		if(input<10)
		{
			return input;			
		}
		return (input % 10 + sumOfDigits(input / 10));
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int m = s.nextInt(); 

		int res = sumOfDigits(m);
		System.out.print(res);
	}
}
