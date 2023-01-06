package Assignment;

import java.util.Scanner;

public class CheckMax_Heap {

	public static boolean checkMaxHeap(int arr[]) {
          for(int i=0;i<arr.length;i++) {
        	  int parentindex = i;
        	  int lchild = 2*i + 1;
        	  int rchild = 2*i + 2; 
        	  if( lchild < arr.length && arr[parentindex] < arr[lchild] ) {
  				return false;
  			    }
  			  if( rchild < arr.length && arr[parentindex] < arr[rchild] ) {
  				return false;
  			   }
          }
          return true;
	}
//	public static boolean checkMaxHeap(int arr[]) {
//	      int lchild=1;    
//	      int rchild=2;
//	      int parentindex=0;
//	      int minindex=parentindex;
//	      while(lchild<arr.length){
////	          if(arr[parentindex]>arr[lchild] && arr[parentindex]>arr[rchild]) {
////	        	  continue ;
////	          }
////	          else {
////	        	  return false ;
////	          }
//	    	  if(arr[lchild]>arr[minindex])
//	              minindex=lchild;
//	          if(rchild<arr.length && arr[rchild]>arr[minindex])
//	              minindex=rchild;
//	          if(parentindex==minindex)
//	              break;
//	          else{
//	        	  if(arr[parentindex]>arr[minindex] ) {
//	        		  parentindex=minindex;
//		              lchild=2*parentindex+1;
//		              rchild=2*parentindex+2;
//	        		  continue ;		        	  
//		          }
//	        	  else {
//	        		  return false;
//	        	  }  
//	           }
//	          
//	      }
//	    return true;  
//	}
	 public static void main(String[] args) {
			Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int input[] = new int[n];
			for (int i = 0; i < n; i++) {
				input[i] = s.nextInt();
			}
			boolean res = checkMaxHeap(input);
				System.out.print(res);
		
	 }
}
