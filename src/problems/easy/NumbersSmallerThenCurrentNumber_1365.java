package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class NumbersSmallerThenCurrentNumber_1365 {

    public static void main(String[] args) {

        NumbersSmallerThenCurrentNumber_1365 obj = new NumbersSmallerThenCurrentNumber_1365();
    }

    public int[] smallerNumbersThanCurrent(int[] nums) {

        int[] result = new int[nums.length];

        for(int i=0 ; i<nums.length ; i++) {
            for(int j=0 ; j<nums.length ; j++) {
                if(i != j && nums[i] > nums[j])
                    result[i]++;
            }
        }

        return result;
    }
}
