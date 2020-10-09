package problems;

import java.util.Arrays;

/*
 * Find next immediate greater number using the same set of digits.
 * 
 * Run time = O(n);
 * 
 * Input = 328431 => output = 331248
 */

public class NextGreaterNumberWithSameDigits {

	private static void swap(int i, int j, int[] arr) {
		
		arr[i] = arr[i] + arr[j];
		arr[j] = arr[i] - arr[j];
		arr[i] = arr[i] - arr[j];
	}
	
	public static int[] findNext(int[] arr) {
		
		if(arr == null)
			return null;
		
		int d = -1;
		int i = arr.length - 1, j = arr.length - 1;
		
		//find first element which is violating the ascending order from right to left and assign its index to d.
		while(i > 0) {
			if(arr[i] > arr[i-1]) {
				d = i - 1;
				break;
			}
			i--;
		}
		
		// d == -1 means all the elements are in the descending order 
		// hence next greater number can not be formed using same digits.
		if(d == -1)
			return null;
		
		// elements from d+1 to n-1 are in the descending order 
		// reverse them to make the order ascending.
		while(i < j) {
			swap(i, j, arr);
			i++; j--;
		}
		
		// swap the d indexed element to the first greater element to its right
		i = d + 1;
		while(i < arr.length) {
			if(arr[d] < arr[i]) {
				swap(d, i, arr);
				break;
			}
			i++;
		}
		
		// return the result
		return arr;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {3, 2, 8, 4, 3, 1};
		System.out.println(Arrays.toString(findNext(arr)));
	}
}
