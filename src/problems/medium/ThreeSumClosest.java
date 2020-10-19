package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class ThreeSumClosest {

    public static void main(String[] args) {

        ThreeSumClosest obj = new ThreeSumClosest();

        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        System.out.println(obj.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {

        if(nums == null)
            return 0;

        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for(int i=0 ; i<nums.length-2 ; i++) {

            int s = i+1, e=nums.length-1;
            while(s < e) {

                int sum = nums[i] + nums[s] + nums[e];

                if(Math.abs(sum - target) < Math.abs(result - target))
                    result = sum;

                if(sum < target) s++;
                else e--;

            }
        }

        return result;
    }
}
