package problems;

import java.util.Arrays;

public class ShortestUnsortedContinuousSubArray {

    public static void main(String[] args) {
        int[] nums = {2, 6, 4, 9, 7, 10, 15};
        ShortestUnsortedContinuousSubArray obj = new ShortestUnsortedContinuousSubArray();
        System.out.println(obj.findUnsortedLength(nums));
    }
    /*
     * Run time O(n), Space O(1)
     */
    private int findUnsortedLength(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1)
            return 0;

        int n = nums.length;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;

        for(int i=0 ; i<nums.length-1 ; i++) {
            if(nums[i] > nums[i+1]) {
                min = Math.min(min, nums[i+1]);
            }
        }

        if(min == Integer.MIN_VALUE) return 0;

        for(int i=n-1 ; i>0 ; i--) {
            if(nums[i] < nums[i-1]) {
                max = Math.max(max, nums[i-1]);
            }
        }

        int l=0, r=0;
        for(int i=0 ; i<n ; i++) {
            if(nums[i] > min) {
                l = i; break;
            }
        }

        for(int i=n-1 ; i>=0 ; i--) {
            if(nums[i] < max) {
                r = i; break;
            }
        }

        return r-l > 0 ? r-l+1 : 0;
    }

    /*
     * Run time O(nLog(n)), Space O(n)
     */
    private int findUnsortedSubarray(int[] nums) {

        if(nums == null || nums.length == 0) return 0;

        int[] copy = new int[nums.length];
        for(int i=0 ; i<nums.length ; i++)
            copy[i] = nums[i];

        Arrays.sort(copy);

        int left = -1, right = -1;
        int i=0, j=nums.length-1;
        while(i < j) {
            if(left == -1 && copy[i] != nums[i]) {
                left = i;
            }
            if(right == -1 && copy[j] != nums[j]) {
                right = j;
            }
            if(left != -1 && right != -1)
                break;

            if(left == -1) i++;
            if(right == -1) j--;
        }

        return left == -1 || right == -1 ? 0 : right - left + 1;
    }
}
