package Assignment;

import java.util.ArrayList;
import java.util.Scanner;

public class PalindromePair {

	private TrieNode root;
	public int count;

	public PalindromePair() {
		root = new TrieNode('\0');
	}

	private void add(TrieNode root, String word){
		if(word.length() == 0){
			root.isTerminating = true;
			return;
		}		

		int childIndex = word.charAt(0) - 'a';
		TrieNode child = root.children[childIndex];

		if(child == null) {
			child = new TrieNode(word.charAt(0));
			root.children[childIndex] = child;
			root.childCount++;
		}

		add(child, word.substring(1));
	}

	public void add(String word){
		add(root, word);
	}

	private boolean search(TrieNode root, String word) {
		if(word.length() == 0) {
			return true;
		}

		int childIndex=word.charAt(0) - 'a';
		TrieNode child=root.children[childIndex];

		if(child == null) {
			return false;
		}

		return search(child,word.substring(1));

	}

	public boolean search(String word) {
		return search(root,word);
	}
	private void print(TrieNode root, String word) {
		if (root == null) {
			return;
		}
		
		if (root.isTerminating) {
			System.out.println(word);
		}
		
		for (TrieNode child : root.children) {
			if (child == null) {
				continue;
			}
			String fwd = word + child.data;
			print(child, fwd);
		}
	}
	
	public void print() {
		print(this.root, "");
	}

	public String reverse(String word) {
		String str = "";
		for(int i = word.length()-1;i>=0;i--) {
			 str +=  word.charAt(i);
		}
		return str;
	}
	public boolean isPalindromePair(ArrayList<String> words) {
		for(int i=0;i<words.size();i++) {
			String str = reverse(words.get(i));
			for(int j=0;j<str.length();j++) {
			 	add(str.substring(j));
			}
			for(String s : words) {
				if(search(s)) {
					return true;
				}
			}
		}
		return false;
	} 

    public static void main(String[] args){
    	Scanner s = new Scanner(System.in);
    	PalindromePair root = new PalindromePair();
		int n = s.nextInt();
        ArrayList<String> input = new ArrayList<String>();
        String[] words = new String[100];
	        
        for(int i=0; i<n; i++) {  
	        words[i] = s.next();  
	     }        
		for(int i = 0; i < n; i++) {
			
			input.add(words[i]);
		}
	        System.out.println(root.isPalindromePair(input));
	 }

	
}
/*
 * for(int i=0;i<words.size();i++) {
			String str = reverse(words.get(i));
			for(int j=0;j<str.length();j++) {
			 	add(str.substring(j));
			}
			for(String s : words) {
				if(search(s)) {
					return true;
				}
			}
		}
		return false;
   for(int i=0;i<words.size();i++) {
			String str = reverse(words.get(i));
			for(int j=0;j<str.length();j++) {
				add(str.substring(j));
			}
			for(String z : words) {
				if(search(z)) {
					return true;
				}
			}
		}
		return false;
 */
