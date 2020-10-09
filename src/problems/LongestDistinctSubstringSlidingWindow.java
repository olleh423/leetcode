package problems;

/*
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/submissions/
 */

public class LongestDistinctSubstringSlidingWindow {

	public int longestDistinctSubstring(String str) {
		
		if(str == null || str.isEmpty())
			return 0;
		
		int n = str.length();
		int CHARS = 256;
		int i=0, j=0;
		
		int[] lookup = new int[CHARS];
		lookup[str.charAt(0)] = 1;
		
		int result = 1;
		
		while(j < n-1) {
			
			char ch = str.charAt(j+1);
			
			if(lookup[ch] == 0) {
				j++;
				lookup[ch]++;
			}
			else {
				while(lookup[ch] != 0) {
					lookup[str.charAt(i)]--;
					i++;
				}
			}
			result = Math.max(result, j - i + 1);
		}
			
		return result;
	}
	
	public static void main(String[] args) {
		
		String str = "abrexrzx";
		
		LongestDistinctSubstringSlidingWindow obj = new LongestDistinctSubstringSlidingWindow();
		
		System.out.println(obj.longestDistinctSubstring(str));
	}
}
