package problems;

/*
 * Kadane's Algorithm to find max sum sub array.
 */

public class MaxSumSubArrayKadane {
	
	public static void maxSum(int[] arr) {
		
		int maxSoFar = Integer.MIN_VALUE, currentMax = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			
			currentMax += arr[i];
			if(currentMax > 0)
				maxSoFar = maxSoFar < currentMax ? currentMax : maxSoFar;
			else
				currentMax = 0;
		}
		
		System.out.println("Maximum : " + maxSoFar);
	}

	public static void getMax(int[] arr) {
		
		int maxSoFar = Integer.MIN_VALUE, currentMax = 0;
		int start, end, s;
		start = end = s = 0;
		
		for(int i=0 ; i<arr.length ; i++) {
			
			currentMax += arr[i];
			if(maxSoFar < currentMax) {
				maxSoFar = currentMax;
				start = s;
				end = i;
			}
			if(currentMax < 0) {
				currentMax = 0;
				s = i+1;
			}
		}
		
		System.out.println("Maximum sum is : " + maxSoFar);
		System.out.println("Left : " + start + ", Right = " + end + "");
	}
	
	public static void main(String[] args) {
		
		//int[] arr = {4, -3, -2, 2, 3, 1, -2, -3, 4, 2, -6, -3, -1, 3, 1, 2};
		int[] arr = {-3, -2, 4, -1, -2, 1, 5, -3};
		
		getMax(arr);
		maxSum(arr);
	}
}
