package problems;
import java.util.*;

public class LongestSubStringWithoutDuplicates {

	public static String longestSubstringWithoutDuplication(String str) {
	    
		if(str == null || str.isEmpty())
			return str;

		Map<Character, Integer> lastSeen = new HashMap<>();
		
		String result = str.charAt(0) + "";
		int bestLength = 1, i=0, j=1;
		lastSeen.put(str.charAt(0), 0);
		
		while(j < str.length()) {
			
			char ch = str.charAt(j);
			if(lastSeen.containsKey(ch) && lastSeen.get(ch) >= i) 
				i = lastSeen.get(ch) + 1;
			
			lastSeen.put(ch, j);
			int currentLength = j + 1 - i;
			if(bestLength < currentLength) {
				bestLength = currentLength;
				result = str.substring(i, j+1);
			}
			
			j++;
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String str = "clementisacap";
		
		System.out.println(longestSubstringWithoutDuplication(str));
	}
}
