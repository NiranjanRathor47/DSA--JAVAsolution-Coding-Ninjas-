package Assignment;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

// import Tries_Implementation.TrieNode;

//class TrieNode{
//	char data;
//	boolean isTerminating;
//	TrieNode children[];
//	int childCount;
//	
//	public TrieNode(char data) {
//		this.data = data;
//		isTerminating = false;
//		children = new TrieNode[26];
//		childCount =0 ;
//	}
//	
//}
public class Pattern_Matching {

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	private TrieNode root;
	public Pattern_Matching() {
		root = new TrieNode('\0');
	}
	
	public boolean search(String word){
		return search(root, word);
	}
	private boolean search(TrieNode root, String word) {
		if(word.length() == 0){
			return true;
		}
		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];
		if(child == null){
			return false;
		}
		return search(child, word.substring(1));
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
    
    public boolean patternMatching(ArrayList<String> vect, String pattern) {
      for(int i=0;i<vect.size();i++) {
    	 String word = vect.get(i);
    	  for(int j=0;j<word.length();j++) {
    		  add(word.substring(j));
    	  }
      }
      
    	return (search(pattern));
    } 
    public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	Pattern_Matching t = new Pattern_Matching();
		int n = s.nextInt();
        ArrayList<String> input = new ArrayList<String>();
        String[] words = new String[100];
	        
        for(int i=0; i<n; i++){  
	        words[i] = s.next();  
	      }        
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = s.next();
		System.out.println(t.patternMatching(input, pattern));
	}
  
    class TrieNode{

    	char data;
    	boolean isTerminating;
    	TrieNode children[];
    	int childCount;

    	public TrieNode(char data) {
    		this.data = data;
    		isTerminating = false;
    		children = new TrieNode[26];
    		childCount = 0;
    	}
    }

}


