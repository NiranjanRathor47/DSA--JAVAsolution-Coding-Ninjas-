import java.util.Scanner;

public class Min_Steps_ToOneUsing_Memoization {

	public static int countMinStepsToOneM(int n,int storage[]) {
		  if(n==1) {
				storage[n] = 0;
				return storage[n];
			}
			if(storage[n]!=0) {
				return storage[n];
			}
			int opt1 =  countMinStepsToOneM(n-1,storage);
			int min = opt1;
			if(n % 3 == 0) {
				int opt2 = countMinStepsToOneM(n/3,storage);
				if(min>opt2) {
					min = opt2;
				}
			}
			if(n % 2 == 0) {
				int opt3 = countMinStepsToOneM(n/2,storage);
				if(min>opt3) {
					min = opt3;
				}
			}
			storage[n] = 1 + min ;
			return storage[n];
	}
	public static int countMinStepsToOneM(int n) {
		int storage[] = new int [n+1];
		return countMinStepsToOneM(n,storage);
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.print(countMinStepsToOneM(n));
	}
}
