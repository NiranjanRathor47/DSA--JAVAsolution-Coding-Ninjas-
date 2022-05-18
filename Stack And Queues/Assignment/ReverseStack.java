package Assignment;
import java.util.Scanner;
import java.util.Stack;
public class ReverseStack {

	public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {
		int n = input.size();
		helper(input, n);
	}
 static void transfer(Stack<Integer> s1, Stack<Integer> s2 ,int n)
{
for(int i = 0; i < n; i++){
int temp = s1.peek();

s1.pop();

s2.push(temp);
}
}
static void helper(Stack<Integer> s, int n)
{
Stack<Integer> s2 = new Stack<Integer>();
Stack<Integer> s3 = new Stack<Integer>();

    transfer(s,s2,n);
    transfer(s2,s3,n);
    transfer(s3,s,n);
}
public static int[] takeinput() {
	Scanner s = new Scanner(System.in);
	int n = s.nextInt(); 
	int arr[]= new int [n];
	for(int i=0;i<n;i++) {
		arr[i]= s.nextInt();
	}
	return arr;
}
public static void main(String[] args)
{
int a[] = takeinput();
Stack<Integer> input = new Stack<Integer>();

for(int i = 0; i < a.length; i++) {
	input.push(a[i]);
}

Stack<Integer> empty = new Stack<>();

reverseStack(input, empty);

for(int i = 0; i < a.length; i++)
{
System.out.print(input.peek() + " ");
input.pop();
}
}
}


