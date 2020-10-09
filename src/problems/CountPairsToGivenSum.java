package problems;

import java.util.HashMap;

import java.util.Map;

/*
 * 
 * input 1 : arr = {0, 1, 7, -1, 2, 5, 6, 4}
 * 			 target = 6
 * 
 * 			 output = 4  // (0, 6) (1, 5) (7, -1) (4, 2)
 * 
 * input 1 : arr = {2, 2, 2, 2}
 * 			 target = 4
 * 
 * 			 output = 6  //  (2, 2) (2, 2) (2, 2) (2, 2) (2, 2) (2, 2)
 * 
 */

public class CountPairsToGivenSum {

	public int countPairs(int[] arr, int n, int target) {
		
		if(arr == null)
			return 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		
		for(int i=0 ; i<n ; i++)
			map.put(arr[i], map.containsKey(arr[i]) ? map.get(arr[i]) + 1 : 1);
		
		int totalCount = 0;
		
		for(int i=0 ; i<n ; i++) {
			
			if(map.containsKey(target - arr[i]))
				totalCount += map.get(target - arr[i]);
			
			if(target - arr[i] == arr[i])
				totalCount--;
		}
		
		return totalCount / 2;
	}
	
	public static void main(String[] args) {
		
		int[] arr = {2, 2, 2, 2};
		int target = 4;
		
		CountPairsToGivenSum obj = new CountPairsToGivenSum();
		
		int totalPairs = obj.countPairs(arr, arr.length, target);
		
		System.out.println("Total Pairs of target " + target + " are : " + totalPairs);
	}
}
