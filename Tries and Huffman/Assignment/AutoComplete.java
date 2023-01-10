package Assignment;

import java.util.ArrayList;
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
		childCount = 0;
	}
}
public class AutoComplete {

 private TrieNode root;
	
	public AutoComplete() {
		root = new TrieNode('\0');
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
	
	public TrieNode search(String word) {
		return search(root, word);
	}
	public TrieNode search(TrieNode root,String word) {
		if(word.length()==0) {
			return root;
		}
		int childIndex = word.charAt(0)-'a';
		TrieNode childNode = root.children[childIndex];
		if(childNode==null) {
			return null;
		}
		return search(childNode, word.substring(1));
	}
	
	public void printPossibleWords(TrieNode root, String word,String output ) {
           if(root.isTerminating) {
        	   System.out.println(word + output);
           }
         for(int i=0;i<root.children.length;i++) {
        	 if(root.children[i]!=null) {
        		 printPossibleWords(root.children[i],word,output + root.children[i].data);
        	 }
         }
	}
	public void autoComplete(ArrayList<String> input, String word) {
	    for(int i=0;i<input.size();i++) {
	    	add(input.get(i));
	    }
	    TrieNode t = search(word);
	    if(t==null) {
	    	return ;
	    }
	    printPossibleWords(t,word,"");
	}
	public static void main(String[] args) {
    	Scanner s = new Scanner(System.in);
    	AutoComplete x = new AutoComplete();
		int n = s.nextInt();
        ArrayList<String> input = new ArrayList<String>();
        String[] words = new String[100];
	        
        for(int i=0; i<n; i++) {  
	        words[i] = s.next();  
	     }        
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
		String pattern = s.next();
		x.autoComplete(input, pattern);
	}
}

/*
 * if(root.isTerminating) {
			System.out.println(word + output);
		}
		for(int i=0;i<root.children.length;i++) {
			if(root.children[i]!=null) {
				printPossibleWords(root.children[i],word,output+root.children[i].data);
			}
		}
 * 
   for(int i=0;i<input.size();i++) {
	    	 add(input.get(i));
	     }
	     TrieNode t = search(word);
	     if(t==null) {
	    	 return ;
	     }
	     printPossibleWords(t,word,"");
 */
