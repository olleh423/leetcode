package problems.hard;

import java.util.Arrays;

public class JumpGame2 {

    public static void main(String[] args) {

        int[] nums = {2,3,1,1,4};

        JumpGame2 obj = new JumpGame2();
        System.out.println(obj.jump(nums));
    }

    public int jump(int[] nums) {

        if(nums == null || nums.length == 1)
            return 0;

        int n = nums.length;
        int[] DP = new int[n];
        Arrays.fill(DP, Integer.MAX_VALUE);
        DP[n-1] = 0;

        for(int i=n-2 ; i>=0 ; i--) {

            int min = Integer.MAX_VALUE;
            for(int j=1 ; j<=nums[i] && j < n ; j++) {
                min = Math.min(min, j+i < n ? DP[j+i] : Integer.MAX_VALUE);
            }
            DP[i] = min == Integer.MAX_VALUE ? min : min + 1;
        }

        return DP[0];
    }
}
