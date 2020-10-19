package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class MergeIntervals {

    public static void main(String[] args) {

        MergeIntervals obj = new MergeIntervals();

        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] merged = obj.merge(intervals);
        for(int[] in : merged)
            System.out.println(Arrays.toString(in));
    }

    public int[][] merge(int[][] intervals) {

        if(intervals == null) return null;
        if(intervals.length == 0) return new int[0][0];

        Arrays.sort(intervals, (a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);
        List<int[]> results = new ArrayList<>();

        int[] arr = {intervals[0][0], intervals[0][1]};
        int i=1;

        while(i < intervals.length) {
            if(intervals[i][0] > arr[1]) {
                results.add(arr);
                arr = new int[]{intervals[i][0], intervals[i][1]};
            }
            else {
                arr[1] = Math.max(intervals[i][1], arr[1]);
                i++;
            }
        }

        results.add(arr);

        int[][] merged = new int[results.size()][results.size()];
        for(int j=0 ; j<results.size() ; j++) {
            merged[j] = results.get(j);
        }

        return merged;
    }
}
