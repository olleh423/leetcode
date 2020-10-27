package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BestTimeToBuyAndSellStocks {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStocks obj = new BestTimeToBuyAndSellStocks();

        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length == 0)
            return 0;

        int minIndex = 0;
        int profit = 0;

        for(int i=1 ; i<prices.length ; i++) {

            if(prices[minIndex] > prices[i])
                minIndex = i;
            if(prices[minIndex] < prices[i])
                profit = Math.max(profit, prices[i] - prices[minIndex]);
        }

        return profit;
    }
}
