package problems.medium;

import java.util.*;

/*
 * Author : Vijay Sharma 19-10-2020
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    public static void main(String[] args) {

        BestTimeToBuyAndSellStockWithCooldown obj = new BestTimeToBuyAndSellStockWithCooldown();

        int[] prices = {1, 2, 3, 0, 2};
        System.out.println(obj.maxProfit(prices));
    }

    public int maxProfit(int[] prices) {

        if(prices == null)
            return 0;

        int n = prices.length;
        if(n <= 1)
            return 0;
        if(n == 2 && prices[0] <= prices[1])
            return prices[1] - prices[0];
        if(n == 2 && prices[0] < prices[1])
            return 0;

        int A = -prices[0];
        int B = 0;
        int C = Math.max(-prices[1], A);
        int D = Math.max(A + prices[1], B);

        for(int i=2 ; i<n ; i++) {
            int haveStockOnIthDay = Math.max(B - prices[i], C);
            int dontHaveStockOnIthDay = Math.max(C + prices[i], D);
            A = C; B = D; C = haveStockOnIthDay; D = dontHaveStockOnIthDay;
        }

        return D;
    }
}
