package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class TwoSumSortedInputArray {

    public static void main(String[] args) {

        TwoSumSortedInputArray obj = new TwoSumSortedInputArray();
    }

    public int[] twoSum(int[] nums, int target) {

        int head = 0;
        int tail = nums.length - 1;

        while(head < tail) {

            int total = nums[head] + nums[tail];
            if(total == target) {

                int[] res = new int[2];
                res[0] = head + 1;
                res[1] = tail + 1;
                return res;
            }
            else if(total > target) {
                tail--;
            }
            else {
                head++;
            }
        }

        return null;
    }
}
