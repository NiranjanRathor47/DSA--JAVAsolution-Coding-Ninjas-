import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Is_Connected_Or_Not {

	public static boolean Isconnected(int edges[][],int sv) {
		if(edges.length==0){
            return true;
        }
		boolean[] visited = new boolean[edges.length];
		Queue<Integer> q = new LinkedList<>();
		q.add(sv);
		visited[sv] = true;
		while(!q.isEmpty()) {
			int front = q.remove();
			for(int i=0;i<edges.length;i++) {
				if(edges[front][i]==1 && !visited[i]) {
					q.add(i);
					visited[i] = true;
				}
			}
		}
		for(boolean i : visited) {
			if(!i) {
				return false;
			}
		}
	  return true;
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
		System.out.print(Isconnected(edges,0));
	}
}

/*
      public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int e = scanner.nextInt();
		int[][] edges = new int[n][n];
		for(int i=0;i<e;i++) {
			int se = scanner.nextInt();
			int ee = scanner.nextInt();
			edges[se][ee] = 1;
			edges[ee][se] = 1;
		}
		System.out.println(isConnected(edges,0));
    }
    public static boolean isConnected(int[][] edges,int sv) {
        boolean[] visited = new boolean[edges.length];
        Queue<Integer> queue = new LinkedList<>();
        queue.add(sv);
        visited[sv] = true;
        while(!queue.isEmpty()) {
            int front = queue.poll();
            for(int i=0;i<edges.length;i++) {
                if(!visited[i] && edges[front][i] ==1) {
                    queue.add(i);
                    visited[i]=true;
                }
            }
        }
        for(boolean b : visited) {
            if(!b) {
                return false;
            }
        }
        return true;



/*	public static void printHelper(int edges[][], int sv,boolean visited[]){
        Queue<Integer> q = new LinkedList<>();
        q.add(sv);
        visited[sv]=true;
        while(q.size()!=0){
            int firstelem = q.remove();
            for(int i=0; i<edges.length; i++){
                if(edges[firstelem][i]==1 && !visited[i]){
                    q.add(i);
                    visited[i]=true;
                }       
            }
        }   
    }
	public static boolean BFS(int edges[][]) {
		if(edges.length==0) {
			return true ;
		}
		boolean visited[] = new boolean [edges.length];
		printHelper(edges,0,visited);
		for(int i=0;i<edges.length;i++) {
		    if(visited[i]) {
              continue ;
		    }
		    else {
		    	return false;
		    }
		}
		return true;
	}      */

   
 
