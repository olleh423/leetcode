package problems;

import java.util.HashMap;
import java.util.Map;

public class TrieInsertDeleteSearch {

	private static class TrieNode {
	
		Map<Character, TrieNode> children;
		boolean endOfWord;
		TrieNode() {
			this.children = new HashMap<>();
			this.endOfWord = false;
		}
	}
	
	private static class Trie {
		
		private final TrieNode root;
		
		Trie() {
			root = new TrieNode();
		}
		
		
		void insert(String word) {
			
			TrieNode current = root;
			for(int i=0 ; i<word.length() ; i++) {
				
				char ch = word.charAt(i);
				TrieNode node = current.children.get(ch);
				if(node == null) {
					node = new TrieNode();
					current.children.put(ch, node);
				}
				current = node;
			}
			current.endOfWord = true;
		}
		
		/*
		 * special character means '.'. Dot can be considered as any character
		 * e.g.
		 * 		insert('abc');
		 * 		search('..c'); // true;
		 * 		search('.bc'); // true
		 * 		search('.bk'); // false
		 */
		boolean searchWithSpecialCharacter(String word) {
			return search(word, 0, root);
		}
		
		boolean search(String word, int idx, TrieNode current) {
			
			if(idx == word.length())
				return current.endOfWord;
			
			char ch = word.charAt(idx);
			if(ch == '.') {				
				for(char key : current.children.keySet()) {
					if(search(word, idx+1, current.children.get(key)))
						return true;
				}
			}
			else {
				TrieNode node = current.children.get(ch);
	            return node == null ? false : search(word, idx+1, node);
			}

			return false;
		}
		
		boolean searchExact(String word) {
			
			TrieNode current = root;
			for(int i=0 ; i<word.length() ; i++) {
				
				char ch = word.charAt(i);
				TrieNode node = current.children.get(ch);
				if(node == null)
					return false;
				current = node;
			}
			return current.endOfWord;
		}
		
		void delete(String word) {
			delete(root, word, 0);
		}
		
		/*
		 * returns true if parent should delete the mapping
		 */
		boolean delete(TrieNode current, String word, int index) {
	    	
	        if (index == word.length()) {
	        	
	            if (!current.endOfWord)
	            	return false;
	            
	            current.endOfWord = false;
	            return current.children.size() == 0;
	        }
	        
	        char ch = word.charAt(index);
	        TrieNode node = current.children.get(ch);
	        
	        if (node == null) 
	        	return false;
	        
	        boolean deleteCurrentNode = delete(node, word, index + 1);

	        if (deleteCurrentNode) {
	            current.children.remove(ch);
	            return current.children.size() == 0;
	        }
	        return false;
	    }
	}
	
	/*
	 * Driver method
	 */
	public static void main(String[] args) {
		
		Trie trie = new Trie();
		
		trie.insert("abc");
		trie.insert("abcd");
		trie.insert("lmn");
		trie.insert("abgl");
		trie.insert("pqr");
		
		System.out.println(trie.searchWithSpecialCharacter("abc"));
		
		trie.delete("abc");
		
		System.out.println(trie.searchWithSpecialCharacter("abcd"));
		System.out.println(trie.searchWithSpecialCharacter("abc"));
	}
}
