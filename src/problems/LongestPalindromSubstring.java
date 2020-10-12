package problems;

public class LongestPalindromSubstring {

	public String LPS(String str) {
		
		if(str == null || str.isEmpty())
			return null;
		
		boolean[][] DP = new boolean[str.length()][str.length()];
		int n = str.length();
		int maxLength = 1;
		int startingIndex = 0;
		
		for(int i=0 ; i<str.length() ; i++) {
			DP[i][i] = true;
		}
		
		for(int i=0 ; i<n-1 ; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				DP[i][i+1] = true;
				startingIndex = i;
				maxLength = 2;
			}
		}
		
		for(int k=3 ; k<=n ; k++) {
			for(int i=0 ; i<n-k+1 ; i++) {
				int j = i + k - 1;
				DP[i][j] = str.charAt(i) == str.charAt(j) && DP[i+1][j-1];
				if(DP[i][j] && maxLength < k) {
					maxLength = k;
					startingIndex = i;
				}
			}
		}
		
		return str.substring(startingIndex, startingIndex + maxLength);
	}

	public static void main(String[] args) {
		
		String str = "abcdefgfedcba";
		
		LongestPalindromSubstring obj = new LongestPalindromSubstring();
		
		System.out.println("Longest Palindrom substring is : " + obj.LPS(str));
	}
}
