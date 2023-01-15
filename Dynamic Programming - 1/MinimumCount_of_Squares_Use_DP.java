import java.util.Scanner;

public class MinimumCount_of_Squares_Use_DP {

	public static int minCount(int n) {
		int storage []= new int [n+1];
		 storage[0] = 0;
//		 if(n>0) {
//			 storage[1] = 1;
//		 }
//		 if(n>1){
//			 storage[2] = 2;
//		 }
//		 if(n>2){
//			 storage[3] = 3;
//		 }
		 for(int i=1;i<=n;i++) {
			 int num = (int)Math.sqrt(i);
			 int ans = Integer.MAX_VALUE;
			 while(num>0) {
				 int remaning = i-(num*num);
				 int sum = 1 + storage[remaning];
				 num--;
				 if(ans>sum) {
					 ans = sum;
				 }
				 storage[i] = ans;
			 }
		 }
		 return storage[n];
	}
	public static void main(String [] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		System.out.println(minCount(n));
	}
}