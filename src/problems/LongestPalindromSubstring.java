package problems;

public class LongestPalindromSubstring {

	public String LPS(String str) {
		
		if(str == null || str.isEmpty())
			return null;
		
		boolean[][] table = new boolean[str.length()][str.length()];
		int n = str.length();
		int maxLength = 1;
		int startingIndex = 0;
		
		for(int i=0 ; i<str.length() ; i++) {
			table[i][i] = true;
		}
		
		for(int i=0 ; i<n-1 ; i++) {
			if(str.charAt(i) == str.charAt(i+1)) {
				table[i][i+1] = true;
				startingIndex = i;
				maxLength = 2;
			}
		}
		
		for(int k=3 ; k<=n ; k++) {
			for(int i=0 ; i<n-k+1 ; i++) {
				int j=i+k-1;
				if(table[i+1][j-1] && str.charAt(i) == str.charAt(j)) {
					table[i][j] = true;
					if(maxLength < k) {
						startingIndex = i;
						maxLength = k;
					}
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
