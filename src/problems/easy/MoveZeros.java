package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class MoveZeros {

    public static void main(String[] args) {

        MoveZeros obj = new MoveZeros();

        int[] nums = {0, 1, 0, 3, 12};
        obj.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void moveZeroes(int[] nums) {

        if(nums == null) return;

        int index = 0;
        for(int i=0 ; i<nums.length ; i++) {
            if(nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }

        for(int i=index ; i<nums.length ; i++) {
            nums[i] = 0;
        }
    }
}
