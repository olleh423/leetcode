package problems;

public class CoinChangeNumOfWays {

	public static long getNumberOfWays(long n, long[] coins) {
		
		long[][] res = new long[coins.length][(int) (n+1)];
		
		for(int i = 0 ; i<res.length ; i++) {
			
			for(int j = 0 ; j<=n ; j++) {
				
				if(j == 0) {
					res[i][j] = 1;
				}
				else if(i == 0) {
					res[i][j] = (j % coins[i] == 0) ? 1 : 0;
				}
				else {
					
					if(coins[i] > j) {
						res[i][j] = res[i-1][j];
					} else {
						res[i][j] = res[i-1][j] + res[i][(int) (j-coins[i])];
					}
				}
			}
		}
		
		return res[coins.length - 1][(int) n];
	}
	
	public static long coinChangeWays(long n, long[] d, int i) {
		
		if(n == 0) return 1;
		if(n < 0 || i == d.length) return 0;
		return coinChangeWays(n - d[i], d, i) + coinChangeWays(n, d, i+1);
	}
	
	public static void main(String[] args) {
		
		long n = 6;
		long[] coins = {1, 2, 3};
		System.out.println(coinChangeWays(n, coins, 0));
	}
}
