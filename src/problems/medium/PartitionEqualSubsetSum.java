package problems.medium;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {

        PartitionEqualSubsetSum obj = new PartitionEqualSubsetSum();
        int[] nums = {1, 5, 11, 5};
        System.out.println(obj.canPartition(nums));
    }

    public boolean canPartition(int[] nums) {

        if(nums == null || nums.length == 0 || nums.length == 1)
            return false;

        int total = 0;
        for(int i=0 ; i<nums.length ; i++)
            total += nums[i];

        if(total % 2 == 1) return false;

        int half = total / 2;
        int[][] DP = new int[nums.length+1][half+1];

        for(int i=0 ; i<DP.length ; i++)
            for(int j=0 ; j<DP[i].length ; j++)
                DP[i][j] = -1;

        return subsetSum(0, half, nums, DP);
    }

    private boolean subsetSum(int i, int n, int[] arr, int[][] DP) {

        if(n == 0) return true;
        if(i == arr.length || n < 0) return false;
        if(DP[i][n] != -1) return DP[i][n] == 1;

        DP[i][n] = subsetSum(i+1, n-arr[i], arr, DP) || subsetSum(i+1, n, arr, DP) ? 1 : 0;
        return DP[i][n] == 1;
    }
}
