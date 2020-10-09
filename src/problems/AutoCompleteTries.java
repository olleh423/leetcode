package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AutoCompleteTries {
	
	private static class TrieNode {
		
		char data;
		Map<Character, TrieNode> children;
		TrieNode parent;
		boolean isEnd;
		
		TrieNode(char data) {
			
			this.data = data;
			this.children = new HashMap<>();
			this.isEnd = false;
		}
		
		TrieNode getChild(char ch) {
			
			return children.get(ch);
		}
		
		void addChild(char ch, TrieNode child) {
			
			children.put(ch, child);
		}
		
		String convertToString() {
			
			return (parent == null ? "" : parent.convertToString()) + String.valueOf(data);
		}
		
		List<String> getWords() {
			
			List<String> words = new ArrayList<>();
			if(isEnd)
				words.add(convertToString());
			
			if(children != null) {
				for(Character ch : children.keySet()) {
					words.addAll(children.get(ch).getWords());
				}
			}
			
			return words;
		}
	}
	
	private static class Trie {
		
		TrieNode root;
		
		Trie() {
			root = new TrieNode(' ');
		}
		
		boolean search(String word) {
			
			if(word == null)
				return false;
			
			TrieNode current = root;
			for(char ch : word.toCharArray()) {
				
				TrieNode child = current.getChild(ch);
				if(child == null)
					return false;
				
				current = child;
			}
			
			return current.isEnd;
		}
		
		void insert(String word) {
			
			if(word == null || search(word))
				return;
			
			TrieNode current = root;
			TrieNode parent;
			
			for(char ch : word.toCharArray()) {
				
				parent = current;
				TrieNode child = current.getChild(ch);
				
				if (child != null) {
					
	                current = child;
	                child.parent = parent;
	                
	            } else {
	            	
	                 current.addChild(ch, new TrieNode(ch));
	                 current = current.getChild(ch);
	                 current.parent = parent;
	            }
			}
			
			current.isEnd = true;
		}
		
		List<String> autoComplete(String prefix) {
			
			if(prefix == null)
				return new ArrayList<>();
				
			TrieNode lastNode = root;
			for(char ch : prefix.toCharArray()) {
				
				lastNode = lastNode.getChild(ch);
				if(lastNode == null) 
					return new ArrayList<>();
			}
			
			return lastNode.getWords();
		}
	}
	
	/*
	 * Driver function
	 */
	public static void main(String[] args) {
	
		Trie trie = new Trie();

		trie.insert("amazon");
		trie.insert("amazon prime");
		trie.insert("amazed");
		trie.insert("uber");
		trie.insert("google");
		trie.insert("amazon pay");
		trie.insert("amazing");
		trie.insert("glassdoor");
		trie.insert("alibaba");
		trie.insert("ali express");
		trie.insert("alphabet");
		trie.insert("walmart");
		trie.insert("groffers");
		trie.insert("adobe");
		trie.insert("flipkart");
		trie.insert("samsung");
		trie.insert("linkedin");
		trie.insert("log me in");
		
		String prefix = "am";
		List<String> suggestions = trie.autoComplete(prefix);
		
		System.out.println(suggestions);
	}
}
