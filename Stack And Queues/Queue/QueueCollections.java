package Queue;
import java.util.LinkedList;
import java.util.Queue;
public class QueueCollections {

	public static void main(String[] args) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(10);
		queue.add(20);
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.size());
	}

}
