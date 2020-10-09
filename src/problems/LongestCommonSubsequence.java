package problems;

public class LongestCommonSubsequence {
	
	/*
	 * DP Iterative
	 */
	private int solveDP(String s1, String s2) {
		
		int[][] LCS = new int[s1.length()+1][s2.length()+1];
		
		for(int i=1 ; i<LCS.length ; i++) {
			
			for(int j=1 ; j<LCS[i].length ; j++) {
				
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					LCS[i][j] = 1 + LCS[i-1][j-1];
				} else {
					LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
		}
		
		return LCS[s1.length()][s2.length()];
	}
	
	/*
	 * Recursive brute force
	 */
	private int solve(String s1, String s2, int i, int j) {
		
		if(i == s1.length() || j == s2.length())
			return 0;
		
		if(s1.charAt(i) == s2.charAt(j))
			return 1 + solve(s1, s2, i+1, j+1);
		
		return Math.max(solve(s1, s2, i+1, j), solve(s1, s2, i, j+1));
	}

	public int lcsLength(String s1, String s2) {
		
		//return solve(s1, s2, 0, 0);
		return solveDP(s1, s2);
	}
	
	public static void main(String[] args) {
		
		String s1 = "abefgstu";
		String s2 = "bgksetuyz";
		
		LongestCommonSubsequence obj = new LongestCommonSubsequence();
		
		System.out.println(obj.lcsLength(s1, s2));
	}
}
