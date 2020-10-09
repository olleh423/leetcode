package problems;

public class EggDroppingProblem {
	
	//Dynamic Programming
	public static int eggDrop(int n, int k, int[][] DP) {
		
		if(n == 1 || n == 0 || k == 1)
			return n;
		
		if(DP[n-1][k-1] != -1)
			return DP[n-1][k-1];
		
		Integer MIN = Integer.MAX_VALUE;
		for(int i=1 ; i<=n ; i++) {
			MIN = Math.min(MIN, 1 + Math.max(eggDrop(n-i, k, DP), eggDrop(i-1, k-1, DP)));
		}
		
		DP[n-1][k-1] = MIN;
		return MIN;
	}

	//Brute force
	public static int eggDrop(int n, int k) {
		
		if(n == 1 || n == 0 || k == 1)
			return n;
		
		Integer MIN = Integer.MAX_VALUE;
		for(int i=1 ; i<=n ; i++) {
			MIN = Math.min(MIN, 1 + Math.max(eggDrop(n-i, k), eggDrop(i-1, k-1)));
		}
		
		return MIN;
	}
	
	public static void main(String[] args) {
		
		int n = 35; // number of floors
		int k = 2; // number of eggs

		//result DP
		int[][] DP = new int[n][k];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//System.out.println(eggDrop(n, k));
		System.out.println(eggDrop(n, k, DP));
	}
}
