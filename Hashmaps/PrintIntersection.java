import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class PrintIntersection {

    public static void printIntersection(int[] arr1,int[] arr2){
    	if(arr1.length==0 || arr2.length==0) {
    		return ;
    	}
    	HashMap<Integer,Integer> s = new HashMap<>();
    	for(int i=0;i<arr1.length;i++) {
    		if(s.containsKey(arr1[i])) {
    			s.put(arr1[i], s.get(arr1[i])+1);
    		}
    		else {
    			s.put(arr1[i], 1);
    		}
    	}
    	for(int i=0;i<arr2.length;i++) {
            if(s.containsKey(arr2[i])) {	
    			if(s.get(arr2[i])!=0) {
    				System.out.println(arr2[i]);
    				s.put(arr2[i], s.get(arr2[i])-1);
    			}
    		}
    		else {
    			continue;
    		}
    	}

	}
	public static int[] takeinput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int a [] = new int[n];
		for(int i =0;i<a.length;i++) {
			a[i] = s.nextInt();
		}
		return a;
	}
	 public static void main(String[] args) {
			int a1[] = takeinput();
			int a2[] = takeinput();
			printIntersection(a1,a2);				
	 }		
}
