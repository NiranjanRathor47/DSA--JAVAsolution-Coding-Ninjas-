import java.util.Scanner;

public class SumOfArray {

	public static int sum(int input[]) {
		return sum(input,0);
		
	}
    private static int sum(int input[],int startIndex){
        if(startIndex==input.length)
            return 0;
        int ans=input[startIndex]+sum(input,startIndex+1);
        return ans;
    }
	   public static int[] takeinput() {
				Scanner s = new Scanner(System.in);
				int n = s.nextInt(); 
				int arr[]= new int [n];
				for(int i=0;i<n;i++) {
					arr[i]= s.nextInt();
				}
				return arr;
			}
	  	public static void main(String[] args) {
	  		int input[] = takeinput();
	  		int res = sum(input);
	  		System.out.println(res);
	  	}
}
