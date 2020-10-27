package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class TwoSum {

    public static void main(String[] args) {

        TwoSum obj = new TwoSum();
    }

    public int[] twoSum(int[] nums, int target) {

        int[] res = {-1, -1};
        if(nums == null) return res;

        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(!map.containsKey(nums[i]))
                map.put(nums[i], i);
        }

        for(int i=0 ; i<nums.length ; i++) {

            int r = target - nums[i];
            if(map.containsKey(r) && map.get(r) != i) {
                res[0] = i;
                res[1] = map.get(r);
                break;
            }
        }

        return res;
    }
}
