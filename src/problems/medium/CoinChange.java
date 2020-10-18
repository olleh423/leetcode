package problems.medium;

import java.util.Arrays;

/*
 * Author : Vijay Sharma 17-10-2020
 */
public class CoinChange {

    public static void main(String[] args) {

        CoinChange obj = new CoinChange();
        int[] coins = {1, 2, 5};
        int amount = 11;

        System.out.println(obj.coinChange(coins, amount));
    }

    //find fewest number of coins to create amount
    public int coinChange(int[] coins, int amount) {

        if(coins == null) return 0;

        int[] DP = new int[amount + 1];
        Arrays.fill(DP, DP.length);

        DP[0] = 0;
        for(int i=1 ; i < DP.length ; i++) {

            int min = DP[i];
            for(int j=0 ; j<coins.length ; j++) {
                int value = i - coins[j] >= 0 ? DP[i - coins[j]] : DP.length;
                min = Math.min(min, 1 + value);
            }
            DP[i] = min;
        }

        return DP[amount] == DP.length ? -1 : DP[amount];
    }
}
