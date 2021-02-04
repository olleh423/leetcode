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

        Arrays.sort(jobs, (a, b) -> a.end - b.end);

        int max = jobs[0].profit;
        int[] result = new int[n];
        result[0] = jobs[0].profit;

        for(int i=1; i < n; i++){
            result[i] = Math.max(jobs[i].profit, result[i-1]);
            for(int j=i-1 ; j >=0 ; j--){
                if(jobs[j].end <= jobs[i].start){
                    result[i] = Math.max(result[i], jobs[i].profit + result[j]);
                    break;
                }
            }
            max = Math.max(max, result[i]);
        }

        return max;
    }
}
