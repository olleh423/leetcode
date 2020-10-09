package problems;

/*
 	Given a set of integers, the task is to divide it into two sets S1 and S2 such that 
  	the absolute difference between their sums is minimum.
	If there is a set S with n elements, then if we assume Subset1 has m elements,
 	Subset2 must have n-m elements and the value of abs(sum(Subset1) – sum(Subset2)) should be minimum.

	Example:
	
	Input:  arr[] = {1, 6, 11, 5} 
	Output: 1
	Explanation:
	Subset1 = {1, 5, 6}, sum of Subset1 = 12 
	Subset2 = {11}, sum of Subset2 = 11       
	
 */

public class MinimumPartition {
	
	/*
	 * brute force exponantial solution.
	 */
	private static int part(int[] arr, int i, int total, int current) {
		
		if(i == arr.length-1) 
			return Math.abs((total-current)-current);
		
		return Math.min(part(arr, i+1, total, current + arr[i]), part(arr, i+1, total, current));
	}
	
	public static int getDifference(int[] arr) {
		
		int total = 0;
		int[] DP = new int[arr.length];
		
		return part(arr, 0, total, 0);
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 5, 11, 6};
		System.out.println(getDifference(arr));
	}
}
