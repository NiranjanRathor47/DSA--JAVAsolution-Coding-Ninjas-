package Assignment;
import java.util.Scanner;

public class FindUniqueElement {
	
    public static int findUnique(int[] arr) {
    	int ans = arr[0] ;
    	for(int i=1;i<arr.length;i++) {
					  ans = ans^arr[i];
			}		
		return ans ;
		
	}
    public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t  = s.nextInt();
		while(t>0) {
			int[] input = takeInput();
			int res = findUnique(input);
			System.out.println(res);
			t--;
		}
		

	}

}
