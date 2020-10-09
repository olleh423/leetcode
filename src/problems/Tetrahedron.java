package problems;

public class Tetrahedron {

	public static int MOD = 100000007;
	
	//recursive solution
	public static int solve(int src, int dest, int n) {
				
		if(n == 0) return src == dest ? 1 : 0;
		
		int ans = 0;
		for(int i=0 ; i<4 ; i++) {
			if(i != src) 
				ans += solve(i, dest, n-1);
			ans %= MOD;
		}
		
		return ans;
	}
	
	//recursive solution with dynamic programming O(2n) space.
	public static int solve(int same, int n, int[][] res) {
		
		if(n == 0) return same == 1 ? 1 : 0;
		if(res[same][n-1] != -1) return res[same][n-1];
		res[same][n-1] = same == 1 ? (3 * solve(0, n-1, res)) % MOD : (2 * solve(0, n-1, res) + solve(1, n-1, res)) % MOD;
		return res[same][n-1];
	}
	
	//Iterative solution without memory limit error.
	public static int solveIterative(int n) {
		
		int[][] res = new int[2][n];
		res[1][0] = 1;
		for(int i=1 ; i<n ; i++) {
			res[1][i] = (3 * res[0][i-1]) % MOD;
			res[0][i] = (2 * res[0][i-1] + res[1][i-1]) % MOD;
		}
		return res[1][n-1];
	}
	
	public static int solve(int n) {
		
		int[][] res = new int[2][n];
		for(int i=0 ; i<res.length ; i++)
			for(int j=0 ; j<res[i].length ; j++)
				res[i][j] = -1;
		
		return solve(1, n, res);
	}
	
	public static void main(String[] args) {
		
		System.out.println(solveIterative(2));
	}
}
