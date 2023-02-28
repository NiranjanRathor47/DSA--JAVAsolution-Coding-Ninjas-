import java.util.Scanner;
import java.util.ArrayList;

public class Get_Path_DFS {

	public static ArrayList<Integer> getPath( int[][] edges ,int start ,int end, boolean[] visited){
		if(start==end) {
			ArrayList<Integer> arr = new ArrayList<>();
			arr.add(start);
			return arr;
		}
		visited[start] = true;
		for(int i=0;i<edges.length;i++) {
			if(edges[start][i] ==1 && !visited[i]) {
				ArrayList<Integer> ans = getPath(edges,i,end,visited);
				if(ans!=null) {
					ans.add(start);
					return ans ;	
				}
			}
		}
		return null;
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
		int start = s.nextInt();
		int end = s.nextInt(); 
		boolean[] visited = new boolean[n];
        ArrayList<Integer> ans = getPath(edges,start,end,visited);
        if(ans!=null) {
        	for(int i : ans) {
        		System.out.print(i+" ");
        	}
        }
	}	
}


