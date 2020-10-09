package problems;

/*
	Consider a row of n coins of values v1 . . . vn, where n is even. 
	We play a game against an opponent by alternating turns. 
	In each turn, a player selects either the first or last coin from the row, 
	removes it from the row permanently, and receives the value of the coin. 
	Determine the maximum possible amount of money we can definitely win if we move first.
*/

public class OptimalGameStratagy {
	
	/*
	 * Optimized solution with Dynamic Programming
	 */
	private static int getMaxPossible(int[] arr, int i, int j, int[][] res)	{

		if(i == j) return arr[i];
		
		if(i + 1 == j) return Math.max(arr[i], arr[j]);
		
		if(res[i][j] != 0) return res[i][j];
		
		res[i][j] = Math.max(arr[i] + Math.min(getMaxPossible(arr, i+2, j, res), getMaxPossible(arr, i+1, j-1, res)),
							 arr[j] + Math.min(getMaxPossible(arr, i, j-2, res), getMaxPossible(arr, i+1, j-1, res)));
		
		return res[i][j];
	}
	
	/* 
	 * Recursive brute force solution
	 */
	private static int getMaxPossible(int[] arr, int i, int j) {
		
		if(i == j) return arr[i];
		
		if(i + 1 == j) return Math.max(arr[i], arr[j]);
		
		return Math.max(arr[i] + Math.min(getMaxPossible(arr, i+2, j), getMaxPossible(arr, i+1, j-1)),
						arr[j] + Math.min(getMaxPossible(arr, i, j-2), getMaxPossible(arr, i+1, j-1)));
	}
	
	public static int getMaxProfit(int[] arr) {
		
		//return getMaxPossible(arr, 0, arr.length-1);
		return getMaxPossible(arr, 0, arr.length-1, new int[arr.length][arr.length]);
	}
	
	public static void main(String[] args) {
		
		int[] arr = {8, 15, 3, 7, 8, 5, 8, 9, 6, 13, 6, 4, 8, 9, 6, 13, 6, 4, 5, 2, 3, 25};
		System.out.println(getMaxProfit(arr));
	}
}
