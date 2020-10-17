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

        if(coins == null)
            return 0;

        int[] DP = new int[amount + 1];
        Arrays.fill(DP, amount + 1);
        DP[0] = 0;

        for(int i=0 ; i <= amount ; i++) {
            for(int j=0 ; j < coins.length ; j++) {
                if(coins[j] <= i) {
                    DP[i] = Math.min(DP[i], 1 + DP[i - coins[j]]);
                }
            }
        }

        return DP[amount] > amount ? -1 : DP[amount];
    }
}
