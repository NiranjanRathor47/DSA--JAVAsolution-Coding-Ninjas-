package Tries_Implementation;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

class TrieNode{
	char data;
	boolean isTerminating;
	TrieNode children[];
	int childCount;
	
	public TrieNode(char data) {
		this.data = data;
		isTerminating = false;
	    children = new TrieNode[26];
	}
	
}

public class Trie_Insert_Delete_Search {
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	private TrieNode root;
	
	public Trie_Insert_Delete_Search() {
		root = new TrieNode('\0');
	}

	private void remove(TrieNode root,String word) {
		if(word.length()==0) {
			root.isTerminating = false;
			return ;
		}
		 int childIndex=word.charAt(0)-'a';
	     TrieNode child=root.children[childIndex];
	     if(child==null) {
	    	 return ;
	     }
	     remove(child,word.substring(1));
	 // we can remove child node only if it is not terminating and it's numbers of children are 0;
	     if(!child.isTerminating && child.childCount==0) {
	    	 root.children[childIndex] = null;
    		 child = null;
             root.childCount--;
	     }
//	     
//	     if(!child.isTerminating) {
//	    	 int numchild =0;
//	    	 for(int i=0;i<26;i++) {
//	    		 if(child.children[i]!=null) {
//	    			 numchild++;
//	    		 }
//	    	 }
//	    	 if(numchild==0) {
//	    		 // we can delete child
//	    		 root.children[childIndex] = null;
//	    		 child = null;
//	             root.childCount--;
//	    	 }
//	     }
	     
	}
	
	public void remove(String word ) {
		remove(root,word);
	}
	
	public boolean search(String word){
	        return search(root,word);
	    }
	
	private boolean search(TrieNode root,String word){
	        if(word.length()==0)
	        {
	           return root.isTerminating;
	        }
	 
	        int childIndex=word.charAt(0)-'a';
	        TrieNode child=root.children[childIndex];
	        if(child==null)
	            return false;
	    
	         return search(child,word.substring(1));
	    
	    }

	 private void add(TrieNode root, String word){
		 if(word.length() == 0){
				root.isTerminating = true;
				return;
			}		
			int childIndex = word.charAt(0) - 'a';
			TrieNode child = root.children[childIndex];
			if(child == null){
				child = new TrieNode(word.charAt(0));
				root.children[childIndex] = child;
				root.childCount++;
			}
			add(child, word.substring(1));
	}

	 public void add(String word){
		add(root, word);
	 }
	
	public  int countWords() {
		return root.childCount;
	
	}
	
	public static void main(String[] args) throws IOException{
//		Trie_Insert_Delete_Search t = new Trie_Insert_Delete_Search();
//        String[] string = br.readLine().split("\\s");
//        int choice = Integer.parseInt(string[0]);
//        String word = "Null";
//        if (string.length!=1)        
//        {
//            word = string[1];
//        }
//        		
//		while(choice != -1) {
//			switch(choice) {
//				case 1 : // insert
//					t.add(word);
//					break;
//				case 2 : // search
//					System.out.println(t.search(word));
//					break;
//				default :
//						return;
//			}
//            string = br.readLine().split("\\s");
//            choice = Integer.parseInt(string[0]);
//            if (string.length!=1)
//            {
//                word = string[1];
//            }
//		}
		Trie_Insert_Delete_Search t = new Trie_Insert_Delete_Search();
		Scanner s = new Scanner(System.in);
		t.add("this");
		t.add("for");
		System.out.println(t.search("for"));
		t.remove("for");
		System.out.println(t.search("for"));
		
		System.out.println(t.countWords());
				
	}
}


/*
 
 */
