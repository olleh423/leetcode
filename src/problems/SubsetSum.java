package problems;

public class SubsetSum {

	/*
	 * iterative process
	 */
	public boolean isSubsetAvailable(int[] arr, int n) {
		
		boolean[][] res = new boolean[arr.length][n+1];
		
		for(int i=0 ; i<=n ; i++) 
			res[0][i] = (i == 0 || arr[0] == i);
		
		for(int i=1 ; i<arr.length ; i++) {
			
			for(int j=0 ; j<=n ; j++) {
				
				if(j == 0) 
					res[i][j] = true;
				else if(j < arr[i]) 
					res[i][j] = res[i-1][j];
				else
					res[i][j] = res[i-1][j-arr[i]] ? res[i-1][j-arr[i]] : res[i-1][j];
			}
		}
		
		return res[arr.length-1][n];
	}
	
	/*
	 * recursive process
	 */
	public boolean hasSubSet(int[] arr, int i, int n) {
		
		if(n == 0) return true;
		if(n < 0 || i == arr.length) return false;
		
		return hasSubSet(arr, i+1, n-arr[i]) || hasSubSet(arr, i+1, n);
	}
	
	/*
	 * recursive process with DP
	 */
	public boolean hasSubSet(int[] arr, int i, int n, int[][] DP) {
	
		if(n == 0) return true;
		if(n < 0 || i == arr.length) return false;
		
		if(DP[i][n] != -1) 
			return DP[i][n] == 1;
		
		DP[i][n] = (hasSubSet(arr, i+1, n-arr[i], DP) || hasSubSet(arr, i+1, n, DP)) ? 1 : 0;
		return DP[i][n] == 1;
	}
	
	public static void main(String... args) {
		
		int [] arr = {2, 3, 4, 5};
		int n = 10;
		
		//to store intermediate results
		int[][] DP = new int[arr.length][n+1];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		SubsetSum ss = new SubsetSum();
		System.out.println(ss.isSubsetAvailable(arr, n));
		System.out.println(ss.hasSubSet(arr, 0, n));
		System.out.println(ss.hasSubSet(arr, 0, n, DP));
	}
}
