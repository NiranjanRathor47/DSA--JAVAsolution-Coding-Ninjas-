import java.util.Scanner;

public class HEAP_Sort {

	public static void inplaceHeapSort(int arr[]) {
		  for(int i=0;i<arr.length;i++)
      {
          insertMin(arr,i);
        
      }
      for(int i=0;i<arr.length;i++)
      {
          arr[arr.length-1-i]=removeMin(arr,arr.length-i);
      }
      
	}
   
	public static void insertMin(int arr[],int i){
      int childindex=i;
      int parentindex=(i-1)/2;
      while(childindex>0){
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
		int n = s.nextInt();
		int input[] = new int[n];
		for (int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		inplaceHeapSort(input);
		 for(int i=0;i<input.length;i++)
			System.out.print(input[i] + " ");
		}
	}


