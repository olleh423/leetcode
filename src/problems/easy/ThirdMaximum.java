package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class ThirdMaximum {

    public static void main(String[] args) {

        ThirdMaximum obj = new ThirdMaximum();

        int[] arr = {2, 2, 3, 1};
        System.out.println(obj.thirdMax(arr));
    }

    public int thirdMax(int[] nums) {

        if(nums.length == 1)
            return nums[0];
        if(nums.length == 2)
            return Math.max(nums[0], nums[1]);

        Set<Integer> set = new HashSet<>();
        for(int i=0 ; i<nums.length ; i++) {

            set.add(nums[i]);
            if(set.size() > 3) {
                set.remove(Collections.min(set));
            }
        }

        return set.size() < 3 ? Collections.max(set) : Collections.min(set);
    }
}
