package Assignment;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LongestSubsetZeroSum {

	public static int lengthOfLongestSubsetWithZeroSum(int arr[]) {
		if(arr.length==0) {
			return 0;
		}
		HashMap<Integer,Integer> s = new HashMap<>();
		int sum = 0;
		int maxlength = 0;
		int maxlength1 = 0;
		for(int i=0;i<arr.length;i++) {
			sum = sum + arr[i];
			if(s.containsKey(sum)) {
				int c = s.get(sum);
				
				int r = i-c;
				maxlength1 = r;
			}
			else {
			s.put(sum, i);
			}
			
			if(sum==0) {
				maxlength1 = i+1;
			}
			 if(maxlength1>maxlength) {
	                maxlength=maxlength1;
	        }
		}
		return maxlength ;
	}
	 public static void main(String[] args) {
		 Scanner s = new Scanner(System.in);
			int n = s.nextInt();
			int a [] = new int[n];
			for(int i =0;i<a.length;i++) {
				a[i] = s.nextInt();
			}
			int res = lengthOfLongestSubsetWithZeroSum(a);			
		            System.out.print(res);
	 }		
}








/*
if(arr.length==0)
            return 0;
        HashMap<Integer,Integer> h=new HashMap<>();
        int sum=0;
        int maxlength=0;
        int maxlength1=0;
        for(int i=0;i<arr.length;i++)
        {
            sum=sum+arr[i];
            if(h.containsKey(sum)){
                int k=h.get(sum);
                int l=i-k;
                maxlength1=l;}
             // if(!h.containsKey(sum))
            else
            h.put(sum,i);
            if(sum==0)
            {
                maxlength1=i+1;
            }
           
            if(maxlength1>maxlength)
                maxlength=maxlength1;
        }
return maxlength1;
*/