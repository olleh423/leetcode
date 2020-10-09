package problems;

public class MatrixChainMultiplication {

	private int solveDynamic(int[] arr, int i, int j, int[][] DP) {
		
		if(i == j)
			return 0;
		
		if(DP[i][j] != -1)
			return DP[i][j];
		
		int MIN = Integer.MAX_VALUE;
		for(int k=i ; k<j ; k++) {
			
			int total = solveDynamic(arr, i, k, DP) + solveDynamic(arr, k+1, j, DP) + (arr[i-1] * arr[k] * arr[j]);
			MIN = MIN > total ? total : MIN;
		}
		
		DP[i][j] = MIN;
		return DP[i][j];
	}

	private int solve(int[] arr, int i, int j) {
		
		if(i == j) 
			return 0;
		
		int MIN = Integer.MAX_VALUE;
		for(int k=i ; k<j ; k++) {
			
			int total = solve(arr, i, k) + solve(arr, k+1, j) + (arr[i-1] * arr[k] * arr[j]);
			MIN = MIN > total ? total : MIN;
		}
		
		return MIN;
	}
	
	public void minimiseMultiplications(int[] arr) {
		
		int[][] DP = new int[arr.length][arr.length];
		for(int i=0 ; i<DP.length ; i++)
			for(int j=0 ; j<DP[i].length ; j++)
				DP[i][j] = -1;
		
		//int result = solve(arr, 1, arr.length - 1);
		int result = solveDynamic(arr, 1, arr.length - 1, DP);
		
		System.out.println("Minimum number of multiplication required : " + result);
	}
	
	public static void main(String[] args) {
		
		//int[] arr = {2, 3, 4, 2, 3};
		int[] arr = {1, 2, 3, 4, 3, 2, 3, 4, 2, 3};
		
		MatrixChainMultiplication mcm = new MatrixChainMultiplication();
		mcm.minimiseMultiplications(arr);
	}
}
