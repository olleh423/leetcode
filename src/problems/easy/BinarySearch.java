package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BinarySearch {

    public static void main(String[] args) {

        BinarySearch obj = new BinarySearch();
    }

    public int search(int[] nums, int target) {

        if(nums == null)
            return -1;

        int low = 0;
        int high = nums.length - 1;
        while(low <= high) {
            int mid = (low + high) / 2 ;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
