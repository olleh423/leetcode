package problems;

public class StaircaseProblem {
	
	//brute force solution
	public int countWays(int n, int[] hops, int current) {
		
		if(current == n) return 1;
		if(current > n) return 0;
		
		int ans = 0;
		for(int i=0 ; i<hops.length ; i++) {
			ans += countWays(n, hops, current + hops[i]);
		}
		
		return ans;
	}
	
	//recursive solution with DP
	public int countWays(int n, int[] hops, int current, int[] DP) {
		
		if(current == n) return 1;
		if(current > n) return 0;
		
		if(DP[current] != -1) return DP[current];
		
		int ans = 0;
		for(int i=0 ; i<hops.length ; i++) {
			ans += countWays(n, hops, current + hops[i], DP);
		}
		DP[current] = ans;
		return ans;
	}
	
	public int countWaysDP(int n, int[] hops) {
		
		int[] DP = new int[n];
		for(int i=0 ; i<DP.length ; i++) 
			DP[i] = -1;
		
		return countWays(n, hops, 0, DP);
	}

	//iterative solution with DP
	public void getNumOfWays(int[] steps, int n) {
		
		int[][] res = new int[steps.length][n+1];
		
		for(int i=0 ; i<steps.length ; i++) {
			
			for(int j=0 ; j<=n ; j++) {
				
				if(i == 0) {
					
					if(j % steps[i] == 0)
						res[i][j] = 1;
					else
						res[i][j] = 0;
				} else {
					int ways = 0;
					if(steps[i] <= j) {
						for(int k = i ; k >= 0 ; k--) {
							ways += res[i][j-steps[k]];
						}
					} else {
						ways = res[i-1][j];
					}
					res[i][j] = ways;
				}				
			}
		}
		
		for(int[] a : res) {
			for(int b : a) 
				System.out.print(b + " ");
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		
		int[] hops = {1, 2, 3};
		int n = 4;
		
		StaircaseProblem sp = new StaircaseProblem();
		//sp.getNumOfWays(steps, n);
		System.out.println(sp.countWays(n, hops, 0));
	}
}
