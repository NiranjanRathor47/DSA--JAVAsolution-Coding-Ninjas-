import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Islands_DFS {

	public static void help(int edges[][],boolean visited[],int start){  
		ArrayList<Integer> arr = new ArrayList<>();
        visited[start]=true;
        arr.add(start);
        int n=edges.length;   
          for(int j=0;j<n;j++){
              if(edges[start][j]==1&&!visited[j]){
                 help(edges,visited,j); 
              }
          }
    }
	public static int numConnected(int[][] edges, int n) {
        boolean visited[]=new boolean[edges.length];
        int count =0;
        for(int i=0;i<edges.length;i++){
          if(!visited[i]){
             help(edges,visited,i);
             count++;
          }
        }
        return count;
    }
    public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int e = s.nextInt();
        int edges[][]=new int[n][n];
        for(int i=0;i<e;i++){
            int fv=s.nextInt();
            int sv=s.nextInt();
            edges[fv][sv]=1;
            edges[sv][fv]=1;
        }
       System.out.print(numConnected(edges,0));
    }
}
