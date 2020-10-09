package problems;

/*
 * 
 * Given a string s, partition s such that every string of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 * For example, given s = "aab",
 * Return
 *   [
 *    ["a","a","b"],
 *    ["aa","b"]
 *   ]
 *   
 */

import java.util.List;
import java.util.ArrayList;

public class PalindromPartition2 {
	
	private static boolean isPalindrom(String s) {
		int start = 0;
		int end = s.length()-1;
		while(start < end) {
			if(s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
	
	private static List<List<String>> getParts(List<List<String>> parts, String s, List<String> temp, int index) {
		
		int length = s.length();
		List<String> current = new ArrayList<>(temp);
		
		if(index == 0) 
			temp.clear();
		
		String str = "";
		for(int i = index ; i < length ; i++) {
			
			str += s.charAt(i);
			if(isPalindrom(str)) {
				temp.add(str);
				if(i + 1 < length)
					parts = getParts(parts, s, temp, i+1);
				else
					parts.add(temp);
				temp = new ArrayList<>(current);
			}
		}
		
		return parts;
	}
	
	private static void printParts(List<List<String>> parts) {
		
		for(List<String> a : parts) {
			for(String b : a) {
				System.out.print(b + " ");
			}
			System.out.println();
		}
	}
	
	public static void partition(String s, List<List<String>> parts) {
		
		parts = getParts(parts, s, new ArrayList<String>(), 0);
		printParts(parts);
	}
	
	public static void main(String[] args) {
		
		String str = "ababa";
		List<List<String>> parts = new ArrayList<>();
		
		partition(str, parts);
	}
}
