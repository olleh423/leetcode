package problems;
import java.util.*;

/*
 * Leetcode : 205
 */

public class IsomorphicStrings {

	public static void main(String[] args) {

		String s = "ab";
		String t = "ac";
		
		System.out.println(isIsomorphic(s, t));
	}
	
	private static boolean isIsomorphic(String s, String t) {
		
		Map<Character, Character> map = new HashMap<>();
        for(int i=0 ; i<s.length() ; i++) {
            
            if(map.containsKey(s.charAt(i))) {
                if(!map.get(s.charAt(i)).equals(t.charAt(i))) return false;
            }
            else if(map.containsKey(t.charAt(i))) {
                if(!map.get(t.charAt(i)).equals(s.charAt(i))) return false;
            }
            else {
                map.put(t.charAt(i), s.charAt(i));
                map.put(s.charAt(i), t.charAt(i));
            }
        }
        boolean result = map.get(s.charAt(s.length()-1)).equals(t.charAt(t.length()-1));
        return result;
	}
}
