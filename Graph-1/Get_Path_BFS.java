import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;

public class Get_Path_BFS {
	
	
	
	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int V = s.nextInt();
	        int E = s.nextInt();
	        int edges[][]=new int[V][V];
	        for(int i=0;i<E;i++){
	            int sv=s.nextInt();
	            int ev=s.nextInt();
	            edges[sv][ev]=1;
	            edges[ev][sv]=1;
	        }
	        int V1=s.nextInt();
	        int V2=s.nextInt();
	        boolean visited[]=new boolean[V];
	        ArrayList<Integer> ans=getPathBFS(edges,visited,V1,V2);
	        if(ans!=null){
	            for(int elem:ans)
	            {
	                System.out.print(elem+" ");
	            }
	        }
	    }
	    public static ArrayList<Integer> getPathBFS(int[][] edges,boolean[] visited,int V1,int V2){
	        if(V1==V2)
	        {
	            ArrayList<Integer> ans=new ArrayList<Integer>();
	            ans.add(V1);
	            visited[V1]=true;
	            return ans;
	        }
	        Queue<Integer> q=new LinkedList<Integer>();
	        HashMap<Integer,Integer> h=new HashMap<>();
	        ArrayList<Integer> ans=new ArrayList<>();
	        q.add(V1);
	        visited[V1]=true;
	        while(!q.isEmpty() ){
	            int first=q.remove();
	            for(int i=0;i<edges.length;i++){
	                if(edges[first][i]==1 && !visited[i]){
	                    visited[i]=true;
	                    q.add(i);
	                    h.put(i,first);
	                    if(i==V2)
	                    {    ans.add(i); 
	                     while(!ans.contains(V1)){

	                         int b=h.get(i);
	                         ans.add(b);
	                         i=b;
	                     }
	                     return ans;
	                    }
	                }
	            }



	        }


	        return null;
	    }
}
/*
	 public static ArrayList<Integer> getPathBFS(int[][] edges,boolean[] visited,int start,int end){
	        if(start==end)
	        {
	            ArrayList<Integer> ans=new ArrayList<Integer>();
	            ans.add(start);
	            visited[end]=true;
	            return ans;
	        }
	      Queue<Integer> q = new LinkedList<Integer>();
	      HashMap<Integer,Integer> map = new HashMap<>();
	      
	      q.add(start);
	      visited[start] = true;
	      map.put(start, -1);
	      boolean pathFound = false;
	      while(!q.isEmpty()) {
	    	  int currentvertex = q.remove();
	    	  for(int i=0;i<edges.length;i++) {
		    	  if(edges[start][i]==1 && !visited[i]) {
		    		  visited[i] = true ;
		    		  q.add(i);
		    		  map.put(i, currentvertex);
		    		  if(i==end) {
		    			  pathFound = true ;
		    			  break;
		    		  }
		    	  }
		      }
	      }
	      if(pathFound) {
	    	  ArrayList<Integer> ans = new ArrayList<>();
	    	  int currentvertex = end ;
	    	  while(currentvertex!=-1) {
	    		  ans.add(currentvertex);
	    		  int parent = map.get(currentvertex);
	    		  currentvertex = parent ;
	    	  }
	    	  return ans;
	      }
	     return null;
	  }
	    return null;

	 public static void main(String[] args) {
	        Scanner s = new Scanner(System.in);
	        int V = s.nextInt();
	        int E = s.nextInt();
	        int edges[][]=new int[V][V];
	        for(int i=0;i<E;i++){
	            int sv=s.nextInt();
	            int ev=s.nextInt();
	            edges[sv][ev]=1;
	            edges[ev][sv]=1;
	        }
	        int start=s.nextInt();
	        int end =s.nextInt();
	        boolean visited[]=new boolean[V];
	        ArrayList<Integer> ans=getPathBFS(edges,visited,start,end);
	        if(ans!=null){
	            for(int elem:ans)
	            {
	                System.out.print(elem+" ");
	            }
	        }
	    }

}
*/
