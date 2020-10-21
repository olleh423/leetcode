package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class NumberOfDiceRollWithTargetSum {

    public static void main(String[] args) {

        NumberOfDiceRollWithTargetSum obj = new NumberOfDiceRollWithTargetSum();
        int d = 2;
        int f = 6;
        int target = 7;
        System.out.println(obj.numRollsToTarget(d, f, target));
    }

    public int numRollsToTarget (int d, int f, int target) {

        int[][] DP = new int[d + 1][target + 1];

        for (int i = 0; i <= d; i++)
            Arrays.fill (DP[i], -1);

        return getWays (d, f, target, DP);
    }

    private int getWays (int dice, int faces, int target, int[][] DP) {

        if (dice == 0 && target == 0) return 1;

        if (dice < 0 || target < 0) return 0;

        if (DP[dice][target] != -1) return DP[dice][target];

        int ways = 0;
        for (int face = 1; face <= faces; face++) {
            ways += getWays (dice - 1, faces, target - face, DP);
            ways %= 1000000007;
        }
        return DP[dice][target] = ways;
    }
}
