package problems;

public class UniqueBSTs {

	private static final int MOD = 1000000007;
	
	private static int uniqueBSTs(int from, int to, int[][] res) {
		
		if(from > to) return 1;
		if(res[from][to] != -1) return res[from][to];
		int total = 0;
		for(int i=from ; i <= to ; i++) {
			total += ((uniqueBSTs(from, i-1, res) % MOD) * (uniqueBSTs(i+1, to, res) % MOD)) % MOD;
		}
		return res[from][to] = total;
	}
	
	public static int uniqueBSTs(int n) {
		
		int[][] res = new int[n+2][n+2];
		for(int i=0 ; i<res.length ; i++) 
			for(int j=0 ; j<res[i].length ; j++)
				res[i][j] = -1;
		
		return uniqueBSTs(1, n, res);
	}
	
	public static void main(String[] args) {
		
		int n = 5;
		System.out.println(uniqueBSTs(n));
	}
}
