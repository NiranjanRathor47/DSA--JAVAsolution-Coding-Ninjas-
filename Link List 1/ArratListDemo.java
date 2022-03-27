import java.util.ArrayList;
public class ArratListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		System.out.println(list.size());
		list.add(15);
		list.add(20);
		list.add(25);
		list.add(2,50);
		System.out.println(list.size());
		System.out.println(list.get(2));
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		list.remove(1);
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
		System.out.println();
		list.set(1,100);
		for(int elem : list) {
			System.out.print(elem + " ");
		}
	}
}
