import java.util.Scanner;

public class AllIndicesNumber {

	public static int[] allIndexes(int input[], int x){
		 return allIndexes(input, x, 0);
	}
   private static int[] allIndexes(int input[], int x,int k) {
		if(k==input.length) {
			 int[] ans = new int[0]; 
	            return ans;
		}
	int[] smallIndex = allIndexes(input, x, k+1);
		if(input[k]==x) {
			  int[] myAns = new int[smallIndex.length + 1];
			  myAns[0] = k;
			   for (int j = 0; j < smallIndex.length; j++) {
	                myAns[j + 1] = smallIndex[j];
	            }
	            return myAns;
	        }
	        else {
	            return smallIndex;
	        }
		}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt(); 
		int arr[]= new int [n];
		for(int i=0;i<n;i++) {
			arr[i]= s.nextInt();
		}
		int x = s.nextInt(); 
		 int output[] = allIndexes(arr, x);
	        for (int i = 0; i < output.length; i++) {
	            System.out.print(output[i] + " ");
	        }
	}

}
