import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;

public class BFS_Traversal {

	// ==> BFS = Breath for search
/*	public static void printBFShelper(int edges[][],int sv,boolean visited[]) {
		QueueUsingLL<Integer> q = new QueueUsingLL<>();
		q.enqueue(sv);
		visited[sv] = true;
		int n = edges.length;
		while(!q.isEmpty()) {
			int front ;
			try {
				front = q.dequeue();
			} catch (QueueEmptyException e) {
				return ;
			}
			System.out.print(front + " ");
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					q.enqueue(i);
					visited[i] = true;
				}
			}
		}
	}   */
	public static void printHelper(int edges[][], int sv,boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while(q.size()!=0){
            int firstelem = q.remove();
            System.out.print(firstelem+" ");
            for(int i=0; i<edges.length; i++){
                if(edges[firstelem][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }       
            }
        }   
    }
	public static void BFS(int edges[][]) {
		boolean visited[] = new boolean [edges.length];
		for(int i=0;i<edges.length;i++) {
		    if(!visited[i]) {
//		    	printBFShelper(edges,i,visited);
		    	printHelper(edges,i,visited);
		    }
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
		int edges[][] = new int [n][n];
		for(int i=0;i<e;i++) {
			int fv = s.nextInt();
			int sv = s.nextInt();
			edges[fv][sv] = 1;
			edges[sv][fv] = 1;
		}
		BFS(edges);
	}
}

/*
   QueueUsingLL<Integer> q = new QueueUsingLL<> ();
		q.enqueue(sv);
		visited[sv] = true;
		while(!q.isEmpty()) {
			int front;
			try {
				 front = q.dequeue();
			} catch (QueueEmptyException e) {
				return ;
			}
			System.out.println(front);
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					q.enqueue(i);
					visited[i] = true;
				}
			}
		}
*/