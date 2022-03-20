package Generics;

public class GenericMethods {

	public static <T> void printarray(T [] arr) {
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
		
	}
	public static void main(String[] args) {
		Integer a[] = new Integer[10];
		for(int i=0;i<10;i++) {
			a[i] = i+1;
		}
		String s[] = new String[10];
		for(int i=0;i<10;i++) {
			s[i] = "abs";
		}
		printarray(s);
		System.out.println();
		printarray(a);
	}

}
