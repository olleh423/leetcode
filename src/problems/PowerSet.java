package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
 
 Input = {1, 2, 3}
 
 Powerset of input = [{}, {1}, {2}, {3}, {1,2}, {1,3}, {2,3}, {1,2,3}]
 
 */

public class PowerSet {

	private static void powerSet(List<Integer> arr, List<List<Integer>> result, List<Integer> current, int i) {
		
		if(i == arr.size()) {
			result.add(new ArrayList<Integer>(current));
			return;
		}
		
		//call without adding the current element into list
		powerSet(arr, result, current, i+1);
		
		//call after adding the current element into the list
		current.add(arr.get(i));
		powerSet(arr, result, current, i+1);
		
		//remove recently added element from current list
		current.remove(current.size()-1);
	}
	
	public static List<List<Integer>> powerSet(List<Integer> input) {
		
		List<List<Integer>> result = new ArrayList<>();
		
		if(input == null)
			return null;
		
		powerSet(input, result, new ArrayList<Integer>(), 0);
		return result;
	}
	
	public static void main(String[] args) {
		
		List<Integer> input = Arrays.asList(1, 2, 3);
		
		List<List<Integer>> powerSet = powerSet(input);
		
		System.out.println(powerSet);
	}
}
