package problems;

import java.util.Arrays;

/*
 * 435. Non-overlapping Intervals ------- LeetCode
 */

public class NonOverlappingIntervals {

	public static void main(String[] args) {
		
		//int[][] intervals = {{4,6},{3,4}, {3,5}, {2,3}, {1,3}, {1,2}, {2,3}};
		//int[][] intervals = {{1,3},{2,3}, {1,2}};
		//int[][] intervals = {{2,3},{2,3},{2,3}};
		int[][] intervals = {{1,100}, {11,22}, {1,11}, {2,12}};
		System.out.println(getMinimumIntervalToRemove(intervals));
	}
	
	private static int getMinimumIntervalToRemove(int[][] intervals) {
		
		if(intervals == null || intervals.length == 0)
            return 0;
        
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int min = 0;
        int prevEnd = Integer.MIN_VALUE;
        for(int[] inter : intervals) {
            if(prevEnd > inter[0])
                min++;
            else 
                prevEnd = inter[1];
        }
        
        return min;
	}
}
