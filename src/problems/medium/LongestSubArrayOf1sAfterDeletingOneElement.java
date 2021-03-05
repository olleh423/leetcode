package problems.medium;
/*
 * Author : Vijay Sharma 05-03-2021
 */

public class LongestSubArrayOf1sAfterDeletingOneElement {

    public static void main(String[] args) {

        LongestSubArrayOf1sAfterDeletingOneElement obj = new LongestSubArrayOf1sAfterDeletingOneElement();
        int[] nums = {1, 1, 0, 1, 1, 0, 1, 1, 1};
        System.out.println(obj.longestSubarray(nums));
    }

    public int longestSubarray(int[] nums) {

        int i = 0, j = 0, zeros = 1;
        int max = Integer.MIN_VALUE;

        while(j < nums.length) {
            if(nums[j] == 1) {
                j++;
            }
            else if(zeros > 0) {
                zeros--; j++;
            }
            else {
                max = Math.max(max, j-i-1);
                while(zeros == 0) {
                    if(nums[i] == 0)
                        zeros++;
                    i++;
                }
            }
        }

        return Math.max(max, j-i-1);
    }
}
