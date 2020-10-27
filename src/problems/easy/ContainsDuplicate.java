package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ContainsDuplicate {

    public static void main(String[] args) {

        ContainsDuplicate obj = new ContainsDuplicate();
    }

    public boolean containsDuplicate(int[] nums) {

        if(nums == null || nums.length == 0)
            return false;

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++) {
            if(set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }

        return false;
    }
}
