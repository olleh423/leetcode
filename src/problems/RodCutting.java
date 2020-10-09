package problems;

/*

	Given a rod of length n inches and an array of prices that contains prices of all pieces of size smaller than n. 
	Determine the maximum value obtainable by cutting up the rod and selling the pieces. For example, 
	if length of the rod is 8 and the values of different pieces are given as following, 
	then the maximum obtainable value is 22 (by cutting in two pieces of lengths 2 and 6)
	
	
	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 1   5   8   9  10  17  17  20
	
	And if the prices are as following, 
	then the maximum obtainable value is 24 (by cutting in eight pieces of length 1)
	
	length   | 1   2   3   4   5   6   7   8  
	--------------------------------------------
	price    | 3   5   8   9  10  17  17  20

*/

public class RodCutting {

	static class Rod {
		int length;
		int price;
		Rod(int length, int price) {
			this.length = length;
			this.price = price;
		}
	}
	
	/*
	 * Dynamic programming
	 */
	private int solveDP(Rod[] arr, int n, int[] DP) {
		
		if(n <= 0)
			return 0;
		
		if(DP[n-1] != -1)
			return DP[n-1];
		
		for(int i=0 ; i<n ; i++) {
			DP[n-1] = Math.max(DP[n-1], arr[i].price + solveDP(arr, n-i-1, DP));
		}
		
		return DP[n-1];
	}
	
	/*
	 * Recursive solution
	 */
	private int solve(Rod[] arr, int n) {
		
		if(n <= 0)
			return 0;
		
		int max = 0;
		for(int i=0 ; i<n ; i++) {
			max = Math.max(max, arr[i].price + solve(arr, n-i-1));
		}
		
		return max;
	}
	
	public void getMaxProfit(Rod[] arr, int length) {
		
		int[] DP = new int[length];
		for(int i=0 ; i<length ; i++)
			DP[i] = -1;
		
		//int result = solve(arr, length);
		int result = solveDP(arr, length, DP);
		
		System.out.println(result);
	}
	
	public static void main(String[] args) {
		
		int l = 8;
		Rod[] arr = new Rod[l];
		
		arr[0] = new Rod(1, 1);
		arr[1] = new Rod(2, 5);
		arr[2] = new Rod(3, 8);
		arr[3] = new Rod(4, 9);
		arr[4] = new Rod(5, 10);
		arr[5] = new Rod(6, 17);
		arr[6] = new Rod(7, 17);
		arr[7] = new Rod(8, 20);
		
		/*
		
		int l = 3;
		Rod[] arr = new Rod[l];
		arr[0] = new Rod(1, 3);
		arr[1] = new Rod(2, 5);
		arr[2] = new Rod(3, 8);
		
		*/
		
		RodCutting rc = new RodCutting();
		
		rc.getMaxProfit(arr, l);
	}
}
