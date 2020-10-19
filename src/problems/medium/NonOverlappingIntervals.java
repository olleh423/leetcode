package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class NonOverlappingIntervals {

    public static void main(String[] args) {

        NonOverlappingIntervals obj = new NonOverlappingIntervals();
        int[][] intervals = {{1, 2}, {2, 3}, {3, 4}, {1, 3}};
        System.out.println(obj.eraseOverlapIntervals(intervals));
    }

    public int eraseOverlapIntervals(int[][] intervals) {

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
