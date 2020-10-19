package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class IncreasingTripletSubsequence {

    public static void main(String[] args) {

        IncreasingTripletSubsequence obj = new IncreasingTripletSubsequence();

        int[] arr = {5, 8, 1, 3, 4};
        System.out.println(obj.increasingTriplet(arr));
    }

    public boolean increasingTriplet(int[] nums) {

        if(nums == null || nums.length < 3)
            return false;

        int A = Integer.MAX_VALUE, B = Integer.MAX_VALUE;
        for(int n : nums) {
            if(n < A) A = n;
            else if(n > A && n < B) B = n;
            else if(n > B) return true;
        }

        return false;
    }
}
