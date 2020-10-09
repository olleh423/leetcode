package problems;

public class MinimumSingleDigitPrimeNumber {

	private static int solve(int[] arr, int n, int k, int total) {
	
		if(n == 0) return total;		
		for(int i = k ; i < arr.length ; i++) {
			if(arr[i] <= n) {				
				int value = solve(arr, n % arr[i], k+1, total + n / arr[i]);
				if(value != -1) return value;
			}
		}		
		return -1;
	}
	
	private static int getMinimum(int n) {
		
		return solve(new int[]{7, 5, 3, 2}, n, 0, 0);
	}
	
	public static void main(String[] args) {
		
		int n = 11;
		System.out.println(getMinimum(n));
	}
}
