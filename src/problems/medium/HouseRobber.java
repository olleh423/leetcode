package problems.medium;

/*
 * Author : Vijay Sharma 25-10-2020
 */
public class HouseRobber {

    public static void main(String[] args) {

        HouseRobber obj = new HouseRobber();
        int[] arr = {2, 7, 9, 3, 1};
        System.out.println(obj.rob(arr));
    }

    public int rob(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int DP1 = nums[0];
        int DP2 = 0;

        for(int i=1 ; i<nums.length ; i++) {

            int A = Math.max(DP1, nums[i] + DP2);
            int B = DP1;
            DP1 = A;
            DP2 = B;
        }

        return Math.max(DP1, DP2);
    }
}
