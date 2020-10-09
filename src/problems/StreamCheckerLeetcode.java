package problems;
import java.util.*;

class StreamCheckerLeetcode {
	
	public static void main(String[] args) {
		
		String[] words = {"cd","f","kl"};
		StreamCheckerLeetcode streamChecker = new StreamCheckerLeetcode(words);
		
		System.out.println(streamChecker.query('a'));          // return false
		System.out.println(streamChecker.query('b'));          // return false
		System.out.println(streamChecker.query('c'));          // return false
		System.out.println(streamChecker.query('d'));          // return true, because 'cd' is in the wordlist
		System.out.println(streamChecker.query('e'));          // return false
		System.out.println(streamChecker.query('f'));          // return true, because 'f' is in the wordlist
		System.out.println(streamChecker.query('g'));          // return false
		System.out.println(streamChecker.query('h'));          // return false
		System.out.println(streamChecker.query('i'));          // return false
		System.out.println(streamChecker.query('j'));          // return false
		System.out.println(streamChecker.query('k'));          // return false
		System.out.println(streamChecker.query('l'));          // return true, 
	}
    
    private static class TrieNode {
        TrieNode[] children;
        boolean endOfWord;
        TrieNode() {
        	children = new TrieNode[26];
        	endOfWord = false;
        }
        
        public TrieNode get(char ch) {
        	return children[ch-'a'];
        }
        public void put(char ch, TrieNode node) {
        	children[ch-'a'] = node;
        }
    }
    
    private TrieNode root;
    private StringBuilder sb;

    public StreamCheckerLeetcode(String[] words) {
        
        root = new TrieNode();
        sb = new StringBuilder();
        for(String word : words) {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        
        sb.append(letter);
        return search(sb);
    }
    
    private void insert(String word) {
        
        TrieNode current = root;
        for(int i=word.length()-1 ; i>=0 ; i--) {
        	char ch = word.charAt(i);
			TrieNode node = current.get(ch);
			if(node == null) {
				node = new TrieNode();
				current.put(ch, node);
			}
			current = node;
        }
        current.endOfWord = true;
    }
    
    private boolean search(StringBuilder word) {
        
        TrieNode current = root;
        for(int i=word.length()-1 ; i>=0 ; i--) {
            char ch = word.charAt(i);
            TrieNode node = current.get(ch);
			if(node == null) return false;
			if(node.endOfWord) return true;
			current = node;
        }
        return current.endOfWord;
    }
}
