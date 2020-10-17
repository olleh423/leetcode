package problems.medium;

import java.util.Arrays;

public class ContainsDuplicate3 {

    public static void main(String[] args) {


    }

    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        if(nums == null)
            return false;

        //Pair of value and index [v][i]
        int n = nums.length;
        int[][] pair = new int[n][2];

        for(int i=0 ; i<n ; i++) {
            pair[i][0] = nums[i];
            pair[i][1] = i;
        }

        Arrays.sort(pair, (a, b) -> a[0] != b[0] ? a[0] > b[0] ? 1 : -1 : a[1] > b[1] ? 1 : -1);

        int i=0, j=1;
        while(j < n) {
            long val = (long) pair[j][0] - pair[i][0];
            if(val > t && pair[i][1] != pair[j][1])
                i++;
            else if(i == j || Math.abs(pair[i][1] - pair[j][1]) > k)
                j++;
            else
                return true;
        }

        return false;
    }
}
