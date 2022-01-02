package p0500_;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// Design an algorithm to find the maximum profit.
// You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times).
// However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
 */
public class Puzzle122_BestTimeToBuyAndSellStockII {

    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int s = 0, e = prices.length - 1, profit = 0;
            while (s < e) {
                int next = s + 1;
                if (prices[s] < prices[next]) {
                    profit += prices[next] - prices[s];
                }
                s++;
            }
            return profit;
        }
    }

}
