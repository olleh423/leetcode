package problems;


/*

Given two strings str1 and str2, find the shortest string that has both str1 and str2 as subsequences.
Examples :

Input:   str1 = "geek",  str2 = "eke"
Output: 5 // "geeke"

Input:   str1 = "AGGTAB",  str2 = "GXTXAYB"
Output: 9 // "AGXGTXAYB"

*/

public class ShortestCommonSuperSequence {
	
	private int solveDP(String s1, String s2, int m, int n, int[][] DP) {
		
		if(m == 0) return n;
		if(n == 0) return m;
		
		if(DP[m][n] != -1)
			return DP[m][n];
		
		if(s1.charAt(m-1) == s2.charAt(n-1))
			DP[m][n] = 1 + solveDP(s1, s2, m-1, n-1, DP);
		else
			DP[m][n] = 1 + Math.min(solveDP(s1, s2, m-1, n, DP), solveDP(s1, s2, m, n-1, DP));
		
		return DP[m][n];
	}

	private int solve(String s1, String s2, int m, int n) {
		
		if(m == 0) return n;
		if(n == 0) return m;
		
		if(s1.charAt(m-1) == s2.charAt(n-1)) 
			return 1 + solve(s1, s2, m-1, n-1);
		
		return 1 + Math.min(solve(s1, s2, m-1, n), solve(s1, s2, m, n-1));
	}
	
	public void scs(String s1, String s2) {
		
		int[][] DP = new int[s1.length()+1][s2.length()+1];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//int result = solve(s1, s2, s1.length(), s2.length());
		int result = solveDP(s1, s2, s1.length(), s2.length(), DP);
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		String s1 = "AGGTAB";
		String s2 = "GXTXAYB";
		
		ShortestCommonSuperSequence obj = new ShortestCommonSuperSequence();
		
		obj.scs(s1, s2);
	}
}
