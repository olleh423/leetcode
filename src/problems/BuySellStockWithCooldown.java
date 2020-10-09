package problems;

/*
 * 
Say you have an array for which the ith element is the price of a given stock on day i.

	Design an algorithm to find the maximum profit. You may complete as many transactions as you like 
	(ie, buy one and sell one share of the stock multiple times) with the following restrictions:

	You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 */

public class BuySellStockWithCooldown {

	public static void main(String[] args) {
		
		int[] prices = {1, 2, 3, 0, 2};
		
		int profit = getMaxProfit(prices);
		System.out.println(profit);
	}
	
	private static int getMaxProfit(int[] prices) {
		
		if(prices == null)
			return 0;
		
		int n = prices.length;
		if(n <= 1)
			return 0;
		if(n == 2 && prices[1] >= prices[0])
			return prices[1] - prices[0];
		if(n == 2 && prices[1] < prices[0])
			return 0;
		
		int A = -prices[0];
		int B = 0;
		int C = Math.max(A, B - prices[1]);
		int D = Math.max(B, A + prices[1]);
		
		for(int i=2 ; i<n ; i++) {
			int v1 = Math.max(C, B - prices[i]);
			int v2 = Math.max(D, C + prices[i]);
			A = C; B = D; C = v1; D = v2;
		}
				
		return D;
	}
}
