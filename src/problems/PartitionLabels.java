package problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * Leetcode 763. Partition Labels
 */

public class PartitionLabels {

	public static List<Integer> partitionStringNew(String str) {
		
		List<Integer> result = new ArrayList<>();
		
		if(str == null || str.isEmpty())
			return result;
		
		int[] lastIndex = new int[26];
		for(int i=0 ; i<str.length() ; i++) {
			lastIndex[str.charAt(i) - 'a'] = i;
		}
		
		for(int i=0 ; i<str.length() ; i++) {
			
			int end = lastIndex[str.charAt(i) - 'a'];
			int j = i;
			while(j < end) {
				end = Math.max(end, lastIndex[str.charAt(j++) - 'a']);
			}
			result.add(end - i + 1);
			i = j;
		}
		
		return result;
	}
	
	public static List<Integer> partitionString(String str) {
		
		List<Integer> result = new ArrayList<>();
		
		if(str == null || str.isEmpty())
			return result;
		
		Map<Character, Index> indexMap = new HashMap<>();
		for(int i=0 ; i<str.length() ; i++) {
			
			char ch = str.charAt(i);
			if(indexMap.containsKey(ch)) {
				int right = indexMap.get(ch).end;
				indexMap.get(ch).end = right < i ? i : right;
			} else {
				indexMap.put(ch, new Index(i, i));
			}
		}
		
		for(int i=0 ; i<str.length() ; i++) {
			
			char ch = str.charAt(i);
			int start = i;
			int end = indexMap.get(ch).end;
			
			while(start < end) {
				int endIndex = indexMap.get(ch).end;
				end = end < endIndex ? endIndex : end;
				ch = str.charAt(++start);
			}
			result.add(end - i + 1);
			i = end;
		}
		
		return result;
	}
	
	private static class Index {
		int start, end;
		Index(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	public static void main(String[] args) {
		
		String str = "ababcbacadefegdehijhklij";
		
		System.out.println(partitionString(str));
		System.out.println(partitionStringNew(str));
	}
}
