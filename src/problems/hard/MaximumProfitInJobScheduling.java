package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 03-02-2021
 */
public class MaximumProfitInJobScheduling {

    public static void main(String[] args) {

        MaximumProfitInJobScheduling obj = new MaximumProfitInJobScheduling();

        int[] start = {1, 2, 3, 4, 6};
        int[] end = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};

        System.out.println(obj.jobScheduling(start, end, profit));
    }

    private static class Job {
        int start, end, profit;
        Job(int start, int end, int profit) {
            this.start = start;
            this.end = end;
            this.profit = profit;
        }
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        if(startTime == null || endTime == null || profit == null)
            return 0;

        int n = startTime.length;
        Job[] jobs = new Job[n];
        for(int i=0 ; i<n ; i++) {
            jobs[i] = new Job(startTime[i], endTime[i], profit[i]);
        }

        Arrays.sort(jobs, Comparator.comparingInt(a -> a.end));

        int max = jobs[0].profit;
        int[] result = new int[n];
        result[0] = jobs[0].profit;

        for(int i=1; i < n; i++){
            result[i] = Math.max(jobs[i].profit, result[i-1]);
            int index = getFirstSmallerTimeIndex(0, i-1, jobs[i].start, jobs);
            if(index != -1) {
                result[i] = Math.max(result[i], result[index] + jobs[i].profit);
            }
            max = Math.max(max, result[i]);
        }

        return max;
    }

    private int getFirstSmallerTimeIndex(int low, int high, int startTime, Job[] jobs) {
        int index = -1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(jobs[mid].end <= startTime) {
                index = mid;
                low = mid + 1;
            }
            if(jobs[mid].end > startTime)
                high = mid - 1;
            else
                low = mid + 1;
        }
        return index;
    }
}
