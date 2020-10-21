package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 21-10-2020
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStockWithTransactionFee obj = new BestTimeToBuyAndSellStockWithTransactionFee();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int  fee = 2;
        System.out.println(obj.maxProfit(prices, fee));
    }

    public int maxProfit(int[] prices, int fee) {

        if(prices == null)
            return 0;

        int n = prices.length;
        if(n == 0 || n == 1)
            return 0;
        if(n == 2 && prices[0] >= prices[1])
            return 0;
        if(n == 2 && prices[0] < prices[1])
            return Math.max(prices[1] - prices[0] - fee, 0);

        int A = -prices[0];
        int B = 0;

        for(int i=1 ; i<n ; i++) {

            int C = Math.max(B - prices[i], A);
            int D = Math.max(A + prices[i] - fee, B);
            A = C;
            B = D;
        }

        return B;
    }
}
