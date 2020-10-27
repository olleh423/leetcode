package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 26-10-2020
 */
public class RangeSumQueryImmutable {

    public static void main(String[] args) {

        RangeSumQueryImmutable obj = new RangeSumQueryImmutable();
    }

    private static class NumArray {

        private int[] sum;

        public NumArray(int[] nums) {

            sum = new int[nums.length];

            int total = 0;
            for(int i=0 ; i<nums.length ; i++) {
                total += nums[i];
                sum[i] = total;
            }
        }

        public int sumRange(int a, int b) {

            int leftSum = a == 0 ? 0 : sum[a-1];
            return sum[b] - leftSum;
        }
    }
}
