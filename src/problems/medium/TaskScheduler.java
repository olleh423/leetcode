package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class TaskScheduler {

    public static void main(String[] args) {

        TaskScheduler obj = new TaskScheduler();
        
        char[] chars = {'A','A','A','B','B','B'};
        int n = 2;
        System.out.println(obj.leastInterval(chars, n));
    }

    public int leastInterval(char[] tasks, int n) {

        int[] counts = new int[26];

        for (char ch : tasks)
            counts[ch - 'A']++;
        int max = Integer.MIN_VALUE;

        for (int count : counts)
            max = Math.max(max, count);

        max--;
        int spaces = max * n + max;

        for (int count : counts)
            spaces -= Math.min(count, max);

        return spaces > 0 ? tasks.length + spaces : tasks.length;
    }
}
