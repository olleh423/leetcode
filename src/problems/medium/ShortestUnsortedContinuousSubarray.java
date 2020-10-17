package problems.medium;

/*
 * Auther : Vijay Sharma
 */
public class ShortestUnsortedContinuousSubarray {

    public static void main(String[] args) {

        ShortestUnsortedContinuousSubarray obj = new ShortestUnsortedContinuousSubarray();

        int[] arr = {2, 6, 4, 8, 10, 9, 15};
        System.out.println(obj.findUnsortedSubarray(arr));
    }

    public int findUnsortedSubarray(int[] nums) {

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

        return r - l > 0 ? r - l + 1 : 0;
    }
}
