package Assignment;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

class Triplet{
	int element;
	int eleIndex;
	int arrIndex;
}
class Tripletcomparator implements Comparator<Triplet>{
	public int compare(Triplet a ,Triplet b) {
		if(a.element<=b.element) {
			return -1;
		}
		return 1;
	}
}
public class Merge_K_SortedArrays {

	public static ArrayList<Integer> mergeKSortedArrays(ArrayList<ArrayList<Integer>> input) {
		Tripletcomparator comparator = new Tripletcomparator();
		PriorityQueue<Triplet> priorityQueue = new PriorityQueue<>(comparator);
		for(int i=0;i<input.size();i++) {
			if(input.get(i)!=null) {
				Triplet a = new Triplet();
				a.element = input.get(i).get(0);
				a.arrIndex = i;
				a.eleIndex = 0;
				priorityQueue.add(a);
			}			
		}
		ArrayList<Integer> arr = new ArrayList<>();
		
		while(!priorityQueue.isEmpty()) {
			Triplet a = priorityQueue.remove();
			arr.add(a.element);
			
			if( a.eleIndex+1 <  input.get(a.arrIndex).size() ) {
				Triplet b = new Triplet();
				b.element = input.get(a.arrIndex).get(a.eleIndex+1);
				b.arrIndex = a.arrIndex  ;
				b.eleIndex = a.eleIndex+1;
				priorityQueue.add(b);
			}
			
		}
		return arr;
		
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int k = s.nextInt();
		ArrayList<ArrayList<Integer>> input = new ArrayList<ArrayList<Integer>>();
		while(k > 0) {
			int n = s.nextInt();
			ArrayList<Integer> current = new ArrayList<Integer>();
			for(int i = 0; i < n; i++) {
				current.add(s.nextInt());
			}
			input.add(current);
			k--;
		}
		ArrayList<Integer> output = mergeKSortedArrays(input);
		for(int i : output) {
			System.out.print(i + " ");
		}
	}
}
