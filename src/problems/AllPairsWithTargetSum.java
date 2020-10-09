package problems;

import java.util.HashMap;
import java.util.Map;

public class AllPairsWithTargetSum {
	
	public static int countPairs(int[] arr, int target) {
		
		if(arr == null || target == 0)
			return 0;
		
		int count = 0;
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0 ; i<arr.length ; i++) {
			map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
		}
		
		for(int i=0 ; i<arr.length ; i++) {
			
			map.put(arr[i], map.get(arr[i]) - 1);
			int diff = target - arr[i];
			if(map.containsKey(diff)) {
				count += map.get(diff);
			}
		}
		
		return count;
	}

	public static void main(String[] args) {
		
		int[] arr = {3 ,1 ,8, -4, 4, 0, 2, 2}; //{2, 2, 2, 2}; //{1, 1, 2, 2, 2, 3, 3};
		int target = 4;
		
		System.out.println(countPairs(arr, target) + " Pairs available.");
	}
}
