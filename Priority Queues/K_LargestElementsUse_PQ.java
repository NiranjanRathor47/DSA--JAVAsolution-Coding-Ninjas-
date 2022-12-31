import java.util.ArrayList;
import java.util.Scanner;
import java.util.PriorityQueue;

public class K_LargestElementsUse_PQ {
    public static ArrayList<Integer> kLargest(int input[], int k) {	
    	PriorityQueue<Integer> pq = new PriorityQueue<>();
    	ArrayList<Integer> output = new ArrayList<Integer>();
        for(int i=0;i<input.length;i++) {
 			pq.add(input[i]);
 		}
        int j=0;
        for(;j<input.length-k;j++) {
 			pq.remove();
 		}
    	for(;j<input.length;j++) {
    		output.add(pq.remove());
    	}
    	return output;
	}
//    public static void printkLargest(int input[], int k) {	
//    	PriorityQueue<Integer> pq = new PriorityQueue<>();
// 
//        int j=0;
//        for(;j<k;j++) {
// 			pq.add(input[j]);
// 		}
//    	for(;j<input.length;j++) {
//    		int min = pq.element();
//    		if(min<input[j]) {
//    			pq.remove();
//    			pq.add(input[j]);
//    		}
//    	}
//    	 while(!pq.isEmpty()) {
//    		 System.out.println(pq.remove()+" ");
//    	 }
//	}
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}
		int k = s.nextInt();
		ArrayList<Integer> output = kLargest(input, k);
		
	//	printkLargest(input,k);
		
		for(int i : output) {
			System.out.println(i);
		}		 
    }
}
