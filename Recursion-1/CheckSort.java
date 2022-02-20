import java.util.Scanner;

public class CheckSort {
  /*    public static boolean checkSorted(int input[]){
		
		if(input.length <= 1){
			return true;
		}
		
		int smallInput[] = new int[input.length - 1];
		for(int i = 1; i < input.length; i++){
			smallInput[i - 1] = input[i];
		}
		
		boolean smallAns = checkSorted(smallInput);
		if(!smallAns){
			return false;
		}
		if(input[0] <= input[1]){
			return true;
		}else{
			return false;
		}
		
	}*/
	
      public static boolean checkSorted_2(int input[]){
  		
  		if(input.length <= 1){
  			return true;
  		}
  		if(input[0] > input[1]){
  			return false;
  		}
  		 
  		int smallInput[] = new int[input.length - 1];
  		for(int i = 1; i < input.length; i++){
  			smallInput[i - 1] = input[i];
  		}
  		boolean smallAns = checkSorted_2(smallInput);
  		return smallAns;
//  		if(smallAns){
//  			return true;
//  		}else{
//  			return false;
//  		}

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
  		System.out.println(checkSorted_2(input));

  	}

}
