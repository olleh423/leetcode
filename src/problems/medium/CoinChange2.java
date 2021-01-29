package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 29-01-2021
 */
public class CoinChange2 {

    public static void main(String[] args) {

        CoinChange2 obj = new CoinChange2();
    }

    public int changeIterative(int amount, int[] coins) {

        if(coins == null)
            return 0;

        int n = coins.length;
        int[][] DP = new int[n+1][amount+1];

        for(int i=0 ; i<=amount ; i++)
            DP[0][i] = 0;

        for(int i=0 ; i<=n ; i++)
            DP[i][0] = 1;

        for(int i=1 ; i<DP.length ; i++) {
            for(int j=1 ; j<DP[i].length ; j++) {
                DP[i][j] = DP[i-1][j];
                if(j >= coins[i-1])
                    DP[i][j] += DP[i][j-coins[i-1]];
            }
        }

        return DP[n][amount];
    }

    public int change(int amount, int[] coins) {

        int[][] DP = new int[coins.length][amount+1];
        for(int i=0 ; i<DP.length ; i++)
            for(int j=0 ; j<DP[i].length ; j++)
                DP[i][j] = -1;

        return solve(0, amount, coins, DP);
    }

    private int solve(int i, int amount, int[] coins, int[][] DP) {

        if(amount == 0) return 1;
        if(amount < 0 || i == coins.length) return 0;
        if(DP[i][amount] != -1) return DP[i][amount];

        DP[i][amount] = solve(i, amount - coins[i], coins, DP) + solve(i + 1, amount, coins, DP);
        return DP[i][amount];
    }
}
