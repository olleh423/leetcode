package problems;

public class InterweavingStrings {

	private static int solve(int i, int j, String one, String two, String three, int[][] DP) {
		
		int k = i + j;
		
		if(k == three.length())
			return 1;
		
		if(DP[i][j] != -1)
			return DP[i][j];
		
		if(i < one.length() && one.charAt(i) == three.charAt(k)) {
			
			DP[i][j] = solve(i+1, j, one, two, three, DP);
			if(DP[i][j] == 1)
				return DP[i][j];
		}
			
		if(j < two.length() && two.charAt(j) == three.charAt(k)) {
			DP[i][j] = solve(i, j+1, one, two, three, DP);
			return DP[i][j];
		}
		
		DP[i][j] = 0;
		return DP[i][j];
	}
	
	public static boolean isInterweaving(String one, String two, String three) {
		
		if(one == null || two == null || three == null || one.length() + two.length() != three.length())
			return false;
		
		int[][] DP = new int[one.length() + 1][two.length() + 1];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		return solve(0, 0, one, two, three, DP) == 1;
	}
	
	public static void main(String[] args) {
		
		String one = "aacaaaa";
		String two = "aaabaaa";
		String three = "aaaacabaaaaaaa";
		
		System.out.println(isInterweaving(one, two, three));
	}
}
