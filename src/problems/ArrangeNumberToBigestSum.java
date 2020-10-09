package problems;

import java.util.Arrays;
import java.util.Comparator;

/*
 * Given an array of numbers, arrange them in a way that yields the largest value. 
 * For example, if the given numbers are {54, 546, 548, 60}, the arrangement 6054854654 gives the largest value. 
 * And if the given numbers are {1, 34, 3, 98, 9, 76, 45, 4}, then the arrangement 998764543431 gives the largest value.
 */

public class ArrangeNumberToBigestSum {

	public static void main(String[] args) {
		
		Integer[] arr = {1, 34, 3, 98, 9, 76, 45, 4};
		
		Arrays.sort(arr, new Comparator<Integer>() {
			
			@Override
			public int compare(Integer a, Integer b) {
				
				String one = String.valueOf(a) + String.valueOf(b);
				String two = String.valueOf(b) + String.valueOf(a);
				
				return two.compareTo(one);
			}
		});
		
		for(int A : arr)
			System.out.print(A);
	}
}
