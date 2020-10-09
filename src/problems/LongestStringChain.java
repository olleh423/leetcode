package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 	Longest String Chain
	Given a list of strings, write a function that returns the longest string chain that can be built from those strings. A string chain is dened as follows: let string
	A be a string in the initial array; if removing any single character from string A yields a new string B that is contained in the initial array of strings, then
	strings A and B form a string chain of length 2. Similarly, if removing any single character from string B yields a new string C that is contained in the initial
	array of strings, then strings A, B, and C form a string chain of length 3. The function should return the string chain in descending order (i.e., from the longest
	string to the shortest one). Note that string chains of length 1 do not exist; if the list of strings does not contain any string chain formed by 2 or more strings,
	the function should return an empty list.
	Sample input: ["abde","abc","abd","abcde","ade","ae","1abde","abcdef"]
	Sample output: ["abcdef","abcde","abde","ade","ae"]
 */

public class LongestStringChain {
	
	private static class Chain {
		String next;
		int chainSize;
		Chain() {
			this(null, 1);
		}
		Chain(String next, int chainSize) {
			this.next = next;
			this.chainSize = chainSize;
		}
	}

	public static List<String> getLongestStringChain(List<String> words) {
		
		List<String> chain = new ArrayList<>();

		if(words == null || words.isEmpty())
			return chain;
		
		//sort in non decreasing order by length
		Collections.sort(words, new Comparator<String>() {
			@Override
			public int compare(String one, String two) {
				return one.length() - two.length();
			}
		});
		
		//add all words into map in order to lookup in constant time
		Map<String, Chain> map = new HashMap<>();
		for(String str : words) {
			map.put(str, new Chain());
		}
		
		int maxSize = Integer.MIN_VALUE;
		String chainHead = null;
		
		for(String word : words) {
			
			for(int i=0 ; i<word.length() ; i++) {
				
				//Generate remaining string after removing ith character
				String str = new StringBuilder(word).deleteCharAt(i).toString();
				
				if(map.containsKey(str) && map.get(word).chainSize < map.get(str).chainSize + 1) {
					map.put(word, new Chain(str, map.get(str).chainSize + 1));
					
					int chainHeadSize = map.get(word).chainSize;
					if(chainHeadSize > maxSize) {
						maxSize = chainHeadSize;
						chainHead = word;
					}
				}
			}
		}
		
		if(chainHead == null)
			return chain;
		
		chain.add(chainHead);
		while(map.get(chainHead).next != null) {
			
			chain.add(map.get(chainHead).next);
			chainHead = map.get(chainHead).next;
		}
		
		return chain;
	}
	
	public static void main(String[] args) {
		
		List<String> words = Arrays.asList("abcdefg", "1234", "abdefg", "abdfg", "123", "12", "bg", "g", "12345", "12a345");
		//List<String> words = Arrays.asList("abde","abc","abd","abcde","ade","ae","1abde","abcdef");
		
		List<String> longestChain = getLongestStringChain(words);
		System.out.println(longestChain);
	}
}
