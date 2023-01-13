import java.util.Scanner;

public class Min_Steps_To_One_Recursion {
	
	public static int countMinStepsToOne(int n) {
		 if(n==1) {
				return 0;
			}
			int opt1 =  countMinStepsToOne(n-1);
			int min = opt1;
			if(n % 3 == 0) {
				int opt2 = countMinStepsToOne(n/3);
				if(min>opt2) {
					min = opt2;
				}
			}
			if(n % 2 == 0) {
				int opt3 = countMinStepsToOne(n/2);
				if(min>opt3) {
					min = opt3;
				}
			}
			return 1 + min ;
	}

//	public static int help(int n,int count) {
//		if(n==1) {
//			return count;
//		}
//		int op1 = Integer.MAX_VALUE;
//		int op2 = Integer.MAX_VALUE;
//		int op3 = Integer.MAX_VALUE;
//		
//		if(n%2==0) {
//			op1 = help(n/2,count+1);
//		}
//		if(n%3==0) {
//			op2 = help(n/3,count+1);
//		}
//		op3 = help(n-1,count+1);
//		 // option 3 is always run because if we do not use opt3 then 
//        // our program will fail for the value of 11
//		
//		return Math.min(Math.min(op2, op3), op1);
//	}
//	public static int countMinStepsToOne(int n) {
//		int count = 0;
//		return help(n,count);
//	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.print(countMinStepsToOne(n));
	}
}

