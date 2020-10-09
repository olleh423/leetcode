package problems;

/*
 * 
	Given a number d and size of array N. 
	Print all combination of element in the array such that first element 
	of array is d and next element in the array can be +1 or -1 the previous element in the array. Code was required.
	
	E.g. Input: d=4 N=3
	Output:
	  4 3 2
	  4 3 4
	  4 5 4
	  4 5 6
 * 
 */

public class PlusMinusCombinationArray {

	private static void showArray(int[] arr) {
		
		for(int n : arr) 
			System.out.print(n + " ");
		System.out.println();
	}
	
	private static void print(int[] arr, int n, int i) {
		
		if(i == n) {
			showArray(arr);
			return;
		}
		
		arr[i] = arr[i-1] - 1;
		print(arr, n, i+1);
		arr[i] = arr[i-1] + 1;
		print(arr, n, i+1);
	}
	
	public static void printCombinations(int d, int n) {
		
		int[] arr = new int[n];
		arr[0] = d;
		print(arr, n, 1);
	}
	
	public static void main(String [] args) {

		int n = 4;
		int d = 4;
		
		printCombinations(d, n);
	}
}
