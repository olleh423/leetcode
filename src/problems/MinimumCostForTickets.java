package problems;

import java.util.Arrays;

/*
 * 		Leetcode = 983
 */

public class MinimumCostForTickets {

	public static void main(String[] args) {
		
		//int[] days = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
		//int[] costs = {2, 7, 15};
		
		int[] days = {1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28};
		int[] costs = {3,13,45};
		
		System.out.println(mincostTickets(days, costs));
	}
	
	public static int mincostTickets(int[] days, int[] costs) {
        
		if(days == null || costs == null)
			return 0;
		
		//return solve(0, 0, 0, days, costs);
		
		int[] DP = new int[days.length];
		int result = solveDP(0, days, costs, DP);
		return result;
    }
	
	private static int solve(int i, int last, int cost, int[] D, int[] C) {
		
		if(i == D.length || last > 365)
			return cost;
		
		if(last < D[i]) {
			
			int min = Math.min(solve(i+1, 1+D[i]-1, cost+C[0], D, C), 
							Math.min(solve(i+1, 7+D[i]-1, cost+C[1], D, C), 
									solve(i+1, 30+D[i]-1, cost+C[2], D, C)));
			
			return min;
		}
		else {
			return solve(i+1, last, cost, D, C);
		}		
	}
	
	private static int solveDP(int i, int[] D, int[] C, int[] DP) {
		
		if(i >= D.length)
			return 0;
		
		if(DP[i] > 0) 
			return DP[i];
		
		int oneDay = C[0] + solveDP(i+1, D, C, DP);
		
		int j = i;
		while(j < D.length) {
			if(D[j] >= D[i] + 7)
				break;
			j++;
		}		
		int sevenDay = C[1] + solveDP(j, D, C, DP);
		
		while(j < D.length) {
			if(D[j] >= D[i] + 30)
				break;
			j++;
		}
		int month = C[2] + solveDP(j, D, C, DP);
		
		DP[i] = Math.min(oneDay, Math.min(sevenDay, month));
		return DP[i];
	}
}
