package problems;

import java.util.HashMap;
import java.util.Map;


/*
 * 	Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * 
	You may assume that each input would have exactly one solution, and you may not use the same element twice.
	
	Example:
	
	Given nums = [2, 7, 11, 15], target = 9,
	
	Because nums[0] + nums[1] = 2 + 7 = 9,
	return [0, 1].
 * 
 */

public class TwoSum {
	
	public static void twoSum() {
		
		//inputs
		int[] nums = {2, 7, 15, 11};
		int target = 9;
		
		//solution
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		int[] res = null;
		boolean found = false;
		for(int i=0 ; i<nums.length ; i++) {
			
			if(map.containsKey(nums[i])) {
				
				System.out.println(map.get(nums[i] + " - " + i));
				found = true;
				break;
			}
			
			map.put(target - nums[i], i);
		}
		
		if(!found)
			System.out.println("not found");
	}
	
	public static void twoSumSorted() {
		
		//inputs
		int[] nums = {2, 7, 15, 11};
		int target = 9;
		
		//solution
		int head = 0;
		int tail = nums.length - 1;
		boolean found = false;
		
		while(head < tail) {
			
			int total = nums[head] + nums[tail];
			if(total == target) {
				System.out.println(head + " - " + tail);
				found = true;
				break;
			}
			else if(total > target) {
				tail--;
			}
			else {
				head++;
			}
		}
	}
	
	public static void main(String[] args) {
		
		twoSum();
		twoSumSorted();
	}
}
