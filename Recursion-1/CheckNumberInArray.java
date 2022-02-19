import java.util.Scanner;

public class CheckNumberInArray {
	
	public static boolean checkNumber(int input[], int x) {
		return checkNumber(input,x,0);
	}
	 private static boolean checkNumber(int input[], int x, int size){
		  if(size == input.length){
		        return false;
		    }else if(input[size] == x){
		        return true;
		    }else{
		        return checkNumber(input, x, size+1);
		    }  
	   }
	   public static void main(String args[]){
	      Scanner s = new Scanner(System.in);
	      int size = s.nextInt();
	      int myArray[] = new int [size];
	      for(int i=0; i<size; i++){
	         myArray[i] = s.nextInt();
	      }
          int target = s.nextInt();
	      boolean bool = checkNumber(myArray, target);
	      if(bool){
	         System.out.println("true");
	      }
	      else{
	         System.out.println("false");
	      }
	   }
}
