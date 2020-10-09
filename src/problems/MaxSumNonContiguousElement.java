package problems;

public class MaxSumNonContiguousElement {

	/*
	 * iterative DP
	 */
	public static int maxSumNonContiguous(int[] arr) {
		
		int select = 0, notSelect = 0;
		for(int i = 0 ; i < arr.length ; i++) {
			int temp = select;
			select = arr[i] + notSelect > select ? arr[i] + notSelect : select;
			notSelect = temp;
		}		
		return Integer.max(select, notSelect);
	}
	
	/*
	 * recursive brute force
	 */
	public static int findMax(int[] arr, int i) {
		
		if(i == arr.length-1) return arr[i];
		if(i >= arr.length) return 0;
		
		return Math.max(arr[i] + findMax(arr, i+2), findMax(arr, i+1));
	}
	
	public static void main(String[] args) {
		
		int[] arr = {6, 3, 2, 5, 8, 3, 7, 8, 2, 5};
		
		System.out.println("Max sum is : " + maxSumNonContiguous(arr));
		System.out.println("Max sum is : " + findMax(arr, 0));
	}
}
