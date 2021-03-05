package problems.medium;/*
 * Author : Vijay Sharma 05-03-2021
 */

public class SingleElementInASortedArray {

    public static void main(String[] args) {

        SingleElementInASortedArray obj = new SingleElementInASortedArray();

        int[] nums = {3, 3, 7, 7, 11, 12, 12};
        System.out.println(obj.singleNonDuplicate(nums));
    }

    public int singleNonDuplicate(int[] nums) {

        if(nums.length == 1)
            return nums[0];

        int index = solve(nums, 0, nums.length-1);
        return nums[index];
    }


    private int solve(int[] nums, int i, int j) {

        if(i == j) return i;
        if(i > j || i+1 == j) return -1;

        int mid = (i + j) / 2;
        if(nums[mid] != nums[mid-1] && nums[mid] != nums[mid+1])
            return mid;

        int left = nums[mid] == nums[mid-1] ? solve(nums, i, mid-2) : solve(nums, i, mid-1);
        if(left != -1) return left;

        return nums[mid] == nums[mid+1] ? solve(nums, mid+2, j) : solve(nums, mid+1, j);
    }
}
