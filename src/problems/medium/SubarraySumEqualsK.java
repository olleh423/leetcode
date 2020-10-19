package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class SubarraySumEqualsK {

    public static void main(String[] args) {

        SubarraySumEqualsK obj = new SubarraySumEqualsK();

        int[] arr = {1, 1, 1};
        int k = 2;

        System.out.println(obj.subarraySum(arr, k));
    }

    public int subarraySum(int[] nums, int k) {

        if(nums == null)
            return -1;

        int n = nums.length;

        int[] leftSum = new int[n];
        leftSum[0] = nums[0];
        for(int i=1 ; i<n ; i++)
            leftSum[i] = leftSum[i-1] + nums[i];

        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int i=0 ; i<n ; i++) {

            int key = leftSum[i] - k;
            if(map.containsKey(key)) {
                count += map.get(key);
            }

            int value = map.getOrDefault(leftSum[i], 0);
            map.put(leftSum[i], value+1);
        }

        return count;
    }
}
