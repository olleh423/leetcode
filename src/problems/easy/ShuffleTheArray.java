package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class ShuffleTheArray {

    public static void main(String[] args) {

        ShuffleTheArray obj = new ShuffleTheArray();
    }

    public int[] shuffle(int[] nums, int n) {

        int[] arr = new int[2*n];
        int i=0;
        for(int j=0 ; j<nums.length ; j+=2,i++) {
            arr[j] = nums[i];
            arr[j+1] = nums[i+n];
        }
        return arr;
    }
}
