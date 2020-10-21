package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class FindRightInterval {

    public static void main(String[] args) {

        FindRightInterval obj = new FindRightInterval();

        int[][] intervals = {{3, 4}, {2, 3}, {1, 2}};
        int[] result = obj.findRightInterval(intervals);
        System.out.println(Arrays.toString(result));
    }

    public int[] findRightInterval(int[][] intervals) {

        if(intervals == null)
            return null;

        int n = intervals.length;
        int[] result = new int[n];
        int[][] startWithPosition  = new int[n][2];

        for(int i=0 ; i<intervals.length ; i++) {
            startWithPosition[i][0] = intervals[i][0];
            startWithPosition[i][1] = i;
        }

        Arrays.sort(startWithPosition, (a, b) -> a[0] - b[0]);

        for(int i=0 ; i<n ; i++) {
            int index = findRightClosestIndex(intervals[i][1], startWithPosition);
            result[i] = index == -1 ? -1 : startWithPosition[index][1];
        }

        return result;
    }

    private int findRightClosestIndex(int T, int[][] arr) {

        int low = 0, high = arr.length - 1;
        int index = -1;
        while(low <= high) {
            int mid = low + (high - low) / 2;
            if(arr[mid][0] == T)
                return mid;

            if(arr[mid][0] < T) {
                low = mid + 1;
            }
            else {
                index = mid;
                high = mid - 1;
            }
        }
        return index;
    }
}
