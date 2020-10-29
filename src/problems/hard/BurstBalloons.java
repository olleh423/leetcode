package problems.hard;

import java.util.*;

/*
 * Author : Vijay Sharma 29-10-2020
 */
public class BurstBalloons {

    public static void main(String[] args) {

        BurstBalloons obj = new BurstBalloons();

        int[] nums = {3, 1, 5, 8};
        System.out.println(obj.maxCoins(nums));
    }

    public int maxCoins(int[] nums) {

        if(nums == null || nums.length == 0)
            return 0;

        int n = nums.length;
        int[][] DP = new int[n][n];

        for(int w=0 ; w<n ; w++) {
            for(int i=0 ; i+w < n ; i++) {
                int j = i+w;
                for(int k=i ; k<=j ; k++) {

                    int leftNumber = i == 0 ? 1 : nums[i-1];
                    int rightNumber = j == n-1 ? 1 : nums[j+1];

                    int leftResult = k == i ? 0 : DP[i][k-1];
                    int rightResult = k == j ? 0 : DP[k+1][j];

                    DP[i][j] = Math.max(DP[i][j], leftNumber * nums[k] * rightNumber + leftResult + rightResult);
                }
            }
        }

        return DP[0][n-1];
    }
}
