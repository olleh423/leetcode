package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class MaxSumIncreasingSubsequence {
	
	public static ArrayList<ArrayList<Integer>> getMaxSequence(int[] arr) {
		
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		
		if(arr == null || arr.length == 0)
			return result;
		
		int[] total = new int[arr.length];
		int[] seq = new int[arr.length];
		Arrays.fill(seq, -1);
		int maxIndex = 0;
		
		int max = Integer.MIN_VALUE;
		for(int i=0 ; i<arr.length ; i++) {
			total[i] = arr[i];
			
			if(max < total[i]) {
				max = total[i];
				maxIndex = i;
			}
		}
		
		for(int i=1 ; i<arr.length ; i++) {
			for(int j=0 ; j<i ; j++) {
				if(arr[i] > arr[j] && total[i] < total[j] + arr[i]) {
					total[i] = total[j] + arr[i];
					seq[i] = j;
					if(max < total[i]) {
						max = total[i];
						maxIndex = i;
					}
				}
			}
		}
		
		ArrayList<Integer> one = new ArrayList<>();
		one.add(max);
		
		ArrayList<Integer> two = new ArrayList<>();
		while(maxIndex != -1) {
			two.add(arr[maxIndex]);
			maxIndex = seq[maxIndex];
		}
		Collections.reverse(two);
		
		result.add(one);
		result.add(two);
		return result;
	}

	public static void main(String[] args) {
		
		//int[] arr = {10, 70, 20, 30, 50, 11, 30};
		int[] arr = {-1, 1};
		
		System.out.println(getMaxSequence(arr));
	}
}
