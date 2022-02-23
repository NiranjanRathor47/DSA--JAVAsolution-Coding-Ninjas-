import java.util.Scanner;

public class LastIndexNumber {

    public static int lastIndex(int input[], int x) {
		return lastIndex(input,x,input.length);
	}
    private static int lastIndex(int input[],int x,int i) {
   	 if(i==0) {
   		 return -1 ;
   	 }
   	 if(input[i-1]==x) {
   		 return i-1;
   	 }
   	 int ans = lastIndex(input ,x,i-1);
   	 if(ans>0) {
   		 return ans ;
   	 }
   	
   	 return -1 ;
    }
    /*
     * 
     */
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		int x = s.nextInt(); 
		System.out.println(lastIndex(arr, x));

	}

}
