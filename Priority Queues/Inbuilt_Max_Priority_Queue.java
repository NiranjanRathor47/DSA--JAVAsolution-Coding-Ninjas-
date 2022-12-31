import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class MinPQComparator implements Comparator<Integer>{
	public int compare(Integer o1,Integer o2 ) {
		if(o1<o2) {
			return -1;
		}
		else if(o1>o2) {
			return 1;
		}
		return 0;
	}
 }

class MaxPQComparator implements Comparator<Integer>{
	public int compare(Integer o1,Integer o2 ) {
		if(o1<o2) {
			return 1;
		}
		else if(o1>o2) {
			return -1;
		}
		return 0;
	}
}

class StringLengthComparator implements Comparator<String>{
	public int compare(String o1,String o2 ) {
		if(o1.length()<o2.length()) {
			return -1;
		}
		else if(o1.length()>o2.length()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

public class Inbuilt_Max_Priority_Queue {

	
	public static void insertMin(int arr[],int i){
	      int childindex=i;
	      int parentindex=(i-1)/2;
	      while(childindex>0){  // compare(o1,o2)<0
	          if(arr[parentindex]>arr[childindex])
	          {
	              int temp=arr[parentindex];
	              arr[parentindex]=arr[childindex];
	              arr[childindex]=temp;
	              childindex=parentindex;
	              parentindex=(childindex-1)/2;

	          }
	          else
	              return;
	      }
	  }
	
  public static void insertMax(int arr[],int i){
	      int childindex=i;
	      int parentindex=(i-1)/2;
	      while(childindex>0){  // compare(o1,o2)<0
	          if(arr[parentindex]<arr[childindex])
	          {
	              int temp=arr[parentindex];
	              arr[parentindex]=arr[childindex];
	              arr[childindex]=temp;
	              childindex=parentindex;
	              parentindex=(childindex-1)/2;

	          }
	          else
	              return;
	      }
	  }

	  
	  public static int removeMin(int arr[],int heapsize){
	      int temp=arr[0];
	      arr[0]=arr[heapsize-1];
	      heapsize--;
	      int lchild=1;    
	      int rchild=2;
	      int parentindex=0;
	      int minindex=parentindex;
	      while(lchild<heapsize){
	          
	          if(arr[lchild]<arr[minindex])
	              minindex=lchild;
	          if(rchild<heapsize && arr[rchild]<arr[minindex])
	              minindex=rchild;
	          if(parentindex==minindex)
	              break;
	          else{
	              int temp1=arr[parentindex];
	              arr[parentindex]=arr[minindex];
	              arr[minindex]=temp1;
	              parentindex=minindex;
	              lchild=2*parentindex+1;
	              rchild=2*parentindex+2;
	              }
	      }



	      return temp;     
	  }

	  public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
//		MinPQComparator mincomparator = new MinPQComparator();
//		MaxPQComparator maxcomparator = new MaxPQComparator();
//		PriorityQueue<Integer> pq = new PriorityQueue<>(maxcomparator);
//		PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());  ==> Important
		String input[] = {"this","a","their","at","queue"};
		
//		StringLengthComparator Stringcomparator = new StringLengthComparator();
//		PriorityQueue<String> pq = new PriorityQueue<>(Collections.reverseOrder());
		StringLengthComparator Stringcomparator = new StringLengthComparator();
		PriorityQueue<String> pq = new PriorityQueue<>(Stringcomparator);
//		int n = s.nextInt();
//		int input[] = new int[n];
//		for (int i = 0; i < n; i++) {
//			input[i] = s.nextInt();
//		}
		
		 for(int i=0;i<input.length;i++) {
			pq.add(input[i]);
		}
//	 System.out.print(pq.element());   
 //    System.out.print(pq.peek());  
//	 System.out.println();
	 while(!pq.isEmpty()) {
		 System.out.print(pq.remove()+" ");
	 }
	 
}
	
}
