package problems.easy;

import java.util.*;

/*
 * Author : Vijay Sharma 27-10-2020
 */
public class BestTimeToBuyAndSellStock_2 {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStock_2 obj = new BestTimeToBuyAndSellStock_2();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if(prices == null || prices.length < 2)
            return 0;

        int profit = 0;
        for(int i=0 ; i<prices.length-1 ; i++)
            profit += Math.max(0, prices[i+1] - prices[i]);

        return profit;
    }
}
