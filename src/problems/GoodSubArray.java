package problems;

public class GoodSubArray {
	
	/*
	 * Good sub array is a sub array good if its first element is greater than or equal to the last element.
	 */
	
	public static int findMaxLengthOfGoodSubArray(int[] arr) {
		
		int max = 0;
		for(int i=1 ; i<arr.length ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(arr[i] < arr[j] && (i-j+1) > max) {
					max = i - j + 1;
					break;
				}
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {4, 4, 6, 3, 4, 7, 3, 5, 5};
		//int[] arr = {2, 5, 1, 6, 4, 7};
		System.out.println(findMaxLengthOfGoodSubArray(arr));
	}
}
