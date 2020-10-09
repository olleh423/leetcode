package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

/*
 * Disk Stacking
	You are given a non-empty array of arrays. Each subarray holds three integers and represents a disk. These integers denote each disk's width, depth, and
	height, respectively. Your goal is to stack up the disks and to maximize the total height of the stack. A disk must have a strictly smaller width, depth, and
	height than any other disk below it. Write a function that returns an array of the disks in the nal stack, starting with the top disk and ending with the
	bottom disk. Note that you cannot rotate disks; in other words, the integers in each subarray must represent [width, depth, height] at all times. Assume that
	there will only be one stack with the greatest total height.
	Sample input: [[2, 1, 2], [3, 2, 3], [2, 2, 8], [2, 3, 4], [1, 3, 1], [4, 4, 5]]
	Sample output: [[2, 1, 2], [3, 2, 3], [4, 4, 5]
 */

public class DiskStacking {

	public static void maxHeightStack(ArrayList<Integer[]> disks) {
	
		Collections.sort(disks, new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] one, Integer[] two) {
				return one[2] - two[2];
			}
		});
		
		int[] heights = new int[disks.size()];
		int[] results = new int[disks.size()];
		Arrays.fill(results, -1);
		int maxHeightIndex = 0;
		
		int maxHeight = Integer.MIN_VALUE;
		
		for(int i=0 ; i<disks.size() ; i++) {
			heights[i] = disks.get(i)[2];
			if(maxHeight < heights[i]) {
				maxHeight = heights[i];
				maxHeightIndex = i;
			}
		}
		
		for(int i=1 ; i<disks.size() ; i++) {
			
			Integer[] current = disks.get(i);
			int j = 0;
			
			while(j < i) {
				Integer[] other = disks.get(j);
				if(current[0] > other[0] && current[1] > other[1] && current[2] > other[2] && heights[j] + current[2] > heights[i]) {
					heights[i] = heights[j] + current[2];
					results[i] = j;
					
					if(maxHeight < heights[i]) {
						maxHeight = heights[i];
						maxHeightIndex = i;
					}
				}
				j++;
			}
		}
		
		ArrayList<Integer[]> data = new ArrayList<>();
		
		while(maxHeightIndex != -1) {
			data.add(disks.get(maxHeightIndex));
			maxHeightIndex = results[maxHeightIndex];
		}
		
		Collections.reverse(data);
		
		for(Integer[] n : data) {
			System.out.println(n[0] + " - " + n[1] + " - " + n[2]);
		}
		
		System.out.println("Height of the possible tallest stack is " + maxHeight);
	}
	
	public static void main(String[] args) {
		
		ArrayList<Integer[]> disks = new ArrayList<>();
		
		disks.add(new Integer[]{2, 1, 2});
		disks.add(new Integer[]{3, 2, 3});
		disks.add(new Integer[]{2, 2, 8});
		disks.add(new Integer[]{2, 3, 4});
		disks.add(new Integer[]{1, 3, 1});
		disks.add(new Integer[]{4, 4, 5});
		
		maxHeightStack(disks);
	}
}
