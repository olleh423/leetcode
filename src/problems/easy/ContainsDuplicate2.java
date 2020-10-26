package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ContainsDuplicate2 {

    public static void main(String[] args) {

        ContainsDuplicate2 obj = new ContainsDuplicate2();
        int[] nums = {1, 2, 3, 1};
        int  k = 3;
        System.out.println(obj.containsNearbyDuplicate(nums, k));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        if(nums == null || nums.length == 0)
            return false;

        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0 ; i<nums.length ; i++) {

            if(map.containsKey(nums[i]) && i - map.get(nums[i]) <= k)
                return true;
            else
                map.put(nums[i], i);
        }

        return false;
    }
}
