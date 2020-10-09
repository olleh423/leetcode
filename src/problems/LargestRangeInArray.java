package problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LargestRangeInArray {

	public static int[] largestRange(int[] arr) {
	    
		if(arr == null || arr.length == 0)
			return null;
		
		int[] result = new int[2];
		int max = Integer.MIN_VALUE;
		int left = 0, right = 0;
		
		Map<Integer, Boolean> map = new HashMap<>();
		for(int n : arr)
			map.put(n, true);
		
		for(int i=0 ; i<arr.length ; i++) {
			
			if(map.getOrDefault(arr[i], false)) {
				
				int value = arr[i];
				while(map.containsKey(value)) {
					map.put(value, false);
					value--;
				}
				left = value + 1;
				value = arr[i]+1;
				while(map.containsKey(value)) {
					map.put(value, false);
					value++;
				}
				right = value - 1;
				if(right - left > max) {
					result[0] = left;
					result[1] = right;
					max = right - left;
				}
			}
		}
		
		return result;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {1, 11, 3, 13, 14, 0, 15, 5, 2, 16, 17, 4, 10, 12, 6};
		int[] range = largestRange(arr);
		
		if(range != null)
			System.out.println(range[0] + ", " + range[1]);
		else
			System.out.println("null");
	}
}
