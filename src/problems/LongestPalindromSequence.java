package problems;

/*
 * if the given sequence is “BBABCBCAB”, then the output should be 7 as “BABCBAB” is the longest palindromic subseuqnce in it. 
 * “BBBBB” and “BBCBB” are also palindromic subsequences of the given sequence, but not the longest ones.
 */

public class LongestPalindromSequence {
	
	private int solveDP(int i, int j, String s, int[][] DP) {
		
		if(i == j) return 1;
		if(i > j) return 0;
		
		if(DP[i][j] != -1) return DP[i][j];
		
		DP[i][j] = s.charAt(i) == s.charAt(j) ? 2 + solveDP(i+1, j-1, s, DP) : Math.max(solveDP(i, j-1, s, DP), solveDP(i+1, j, s, DP));
		return DP[i][j];
	}

	private int solve(int i, int j, String s) {
		
		if(i == j) return 1;
		if(i > j) return 0;
		
		return s.charAt(i) == s.charAt(j) ? 2 + solve(i+1, j-1, s) : Math.max(solve(i, j-1, s), solve(i+1, j, s));
	}
	
	public int LPSLength(String s) {
		
		int[][] DP = new int[s.length()][s.length()];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//int result = solve(0, s.length() - 1, s);
		int result = solveDP(0, s.length() - 1, s, DP);
		
		return result;
	}
	
	public static void main(String[] args) {
		
		String s = "BBABCBCABBBABCBCABBBABCBCAB";
		//String s = "geeksforgeeks";
		
		LongestPalindromSequence lps = new LongestPalindromSequence();
		
		System.out.println(lps.LPSLength(s));
	}
}
