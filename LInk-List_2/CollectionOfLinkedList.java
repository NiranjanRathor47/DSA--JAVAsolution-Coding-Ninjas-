import java.util.LinkedList;
public class CollectionOfLinkedList {

	public static void main(String[] args) {
		LinkedList<Integer> list = new LinkedList<>();
		list.add(12);
		list.add(10);
		list.addFirst(45);
		list.set(2, 133);
        System.out.println(list.size());
        
        for(int i=0;i<list.size();i++) {
        	System.out.println(list.get(i));
        }
	}

}
