package problems;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class MaxFromSubarraySizeK {
	
	public static List<Integer> getMaxOfAllSubArraysOfSizeK(int[] arr, int k) {
		
		if(arr == null || k == 0)
			return null;

		List<Integer> result = new ArrayList<>(); 
		Deque<Integer> deque = new LinkedList<>();
		
		int i=0;
		while(i < k) {
			
			while(!deque.isEmpty() && deque.peekLast() < arr[i]) {
				deque.removeLast();
			}
			
			deque.addLast(arr[i]);
			i++;
		}
		
		result.add(deque.peekFirst());
		while(i < arr.length) {
			
			while(!deque.isEmpty() && deque.peekLast() < arr[i]) {
				deque.removeLast();
			}
			
			deque.addLast(arr[i]);
			
			if(deque.size() > k)
				deque.removeFirst();
			
			result.add(deque.peekFirst());
			i++;
		}
		
		return result;
	}

	public static void main(String[] args) {
		
		int[] arr = {9, 8, 7, 6, 5, 4, 3, 2, 1}; //{3, 2, 4, 1, 6, 7, 9, 8, 11};
		int k = 4;
		
		System.out.print(getMaxOfAllSubArraysOfSizeK(arr, k));
	}
}
