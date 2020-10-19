package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class MaximumSizeSubArraySumEqualsK {

    public static void main(String[] args) {

        MaximumSizeSubArraySumEqualsK obj = new MaximumSizeSubArraySumEqualsK();
        int[] nums = {1, -1, 5, -2, 3};
        int k = 3;
        System.out.println(obj.maxSubArrayLen(nums, k));
    }

    public int maxSubArrayLen(int[] arr, int k) {

        if(arr == null) return 0;

        Map<Integer, Integer> map = new HashMap<>();
        int max = 0, total = 0;
        for(int i=0 ; i<arr.length ; i++) {
            total += arr[i];
            if(total == k) {
                max = i + 1;
            }
            if(!map.containsKey(total))
                map.put(total, i);

            if(map.containsKey(total - k))
                max = Math.max(max, i - map.get(total - k));
        }
        return max;
    }
}
