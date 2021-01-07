package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 05-01-2021
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {

        FindMinimumInRotatedSortedArray obj = new FindMinimumInRotatedSortedArray();

        int[] arr = {5,6,7,0,1,2,3,4};
        System.out.println(obj.findMin(arr));
    }

    public int findMin(int[] nums) {

        int low = 0;
        int high = nums.length-1;

        while(low <= high) {

            int mid = (low + high) / 2;
            int left = mid == 0 ? Integer.MAX_VALUE : nums[mid-1];
            int right = mid == nums.length-1 ? Integer.MAX_VALUE : nums[mid+1];

            if(nums[mid] < left && nums[mid] < right)
                return nums[mid];

            if(nums[mid] < nums[high]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
