package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class FindPeekElement {

    public static void main(String[] args) {

        FindPeekElement obj = new FindPeekElement();

        int[] nums = {1, 2, 1, 3, 5, 6, 4};
        System.out.println(obj.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while(left < right) {

            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[mid + 1])
                left = mid + 1;
            else
                right = mid;
        }

        return left;
    }
}
