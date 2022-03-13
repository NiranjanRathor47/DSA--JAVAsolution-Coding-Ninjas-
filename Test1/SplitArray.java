import java.util.Scanner;

public class SplitArray {

	public static boolean splitArray(int input[]) {
		return splitArray(input ,0,0,0);
		}
	    
	    private static boolean splitArray(int input[] ,int si,int lsum ,int rsum){
	        if(input.length == si){
	            return  lsum==rsum;
	        }
	        
	         if(input[si] % 3 == 0){
	                lsum += input[si];
	            }else if(input[si] % 5 == 0){
	                rsum += input[si];
	            }else{
	               return splitArray(input,si+1,lsum+input[si],rsum) || splitArray(input,si+1,lsum,rsum+input[si]) ;
	            }
	        
	        return splitArray(input,si+1,lsum,rsum) ;
	        
	        
	        
	    }
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		
		boolean res = splitArray(arr);
		System.out.println(res);

	}
}
