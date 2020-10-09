package problems;

public class MinimumWindowSubsequence {

	public boolean isPatternSequenceExists(String str, String pat, int i, int j) {
		
		if(j == pat.length())
			return true;
		
		if(i == str.length())
			return false;
		
		return str.charAt(i) == str.charAt(j) 
				? isPatternSequenceExists(str, pat, i+1, j+1) 
				: isPatternSequenceExists(str, pat, i+1, j);
	}
	
	public static void main(String[] args) {
		
		String str = "akibcdkabdcab";
		String pat = "abc";
		
		MinimumWindowSubsequence obj = new MinimumWindowSubsequence();
		
		System.out.println(obj.isPatternSequenceExists(str, pat, 0, 0));
	}
}
