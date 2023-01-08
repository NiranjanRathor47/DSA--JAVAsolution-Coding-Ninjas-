package Assignment;
import java.util.Collection;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Scanner;

public class RunningMedian {

  public static void findMedian(int arr[])  {
	  PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
	  
	   for(int i : arr) {
		   if(max.isEmpty()) {
		    	max.add(i);
		    }
		   else if(i>max.peek()) {
			   min.add(i);
			   if(min.size()-max.size()>1) {
				   int p = min.remove();
					max.add(p);
			   }
		   }
		   else {
			   max.add(i);
			   if(max.size()-min.size()>1) {
				   int q = max.remove();
					min.add(q);
			   }
		   }
		   
		   if(max.size()-min.size()==1) {
			   System.out.print(max.peek() + " ");
		   }
		   else if(min.size()-max.size()==1) {
			   System.out.print(min.peek() +" ");
		   }
		   else {
			   System.out.print((max.peek()+min.peek())/2 + " ");
		   }
	   }
	  	  
	}

   public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		findMedian(input);
  }

}





/*
    PriorityQueue<Integer> min = new PriorityQueue<>();
		PriorityQueue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
		
		for(int i : arr) {
			
			if(max.isEmpty()) {
				max.add(i);
			}
			else if( i  > max.peek() ) {
				min.add(i);
				if( (min.size() - max.size()) > 1 ) {
					int p = min.remove();
					max.add(p);
				}
			}
			else {
				max.add(i);
				if( (max.size() -min.size()) > 1  ) {
					int p = max.remove();
					min.add(p); 
				}
			}
			
			if(max.size() > min.size()) {
				System.out.print(max.peek() + " ");
			}
			else if(max.size() < min.size()) {
				System.out.print(min.peek() + " ");
			}
			else {
				System.out.print( (max.peek() + min.peek()) /2 + " " );
			}
			
		}
		
*/