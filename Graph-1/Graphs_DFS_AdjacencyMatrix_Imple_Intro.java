import java.util.Scanner;

public class Graphs_DFS_AdjacencyMatrix_Imple_Intro {

	// ==> DFS = Depth for search
	public static void printDFShelper(int[][] edges, int sv, boolean[] visited) {
		System.out.println(sv);
		visited[sv] = true;
		for(int i=0;i<edges.length;i++) {
			if(edges[sv][i]==1 && !visited[i]) {
				printDFShelper(edges,i,visited);
			}
		}
	}
	public static void DFS(int edges[][]) {
		boolean visited[] = new boolean [edges.length];
		for(int i=0;i<edges.length;i++) {
			if(!visited[i]) {
				printDFShelper(edges,i,visited);
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
		DFS(edges);
	}
}
