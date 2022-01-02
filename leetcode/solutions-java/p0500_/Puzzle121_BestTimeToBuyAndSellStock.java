package p0500_;

// Say you have an array for which the ith element is the price of a given stock on day i.
//
// If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
// design an algorithm to find the maximum profit.

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 */
public class Puzzle121_BestTimeToBuyAndSellStock {

    public class Solution {
        public int maxProfit(int[] prices) {
            if (prices.length < 2) {
                return 0;
            }
            int s = 0, e = prices.length - 1;
            int min = prices[0], profit = 0;
            while (s < e) {
                int next = s + 1;
                if (prices[s] < prices[next]) {
                    profit = Math.max(profit, prices[next] - prices[s]);
                    profit = Math.max(profit, prices[next] - min);
                    min = Math.min(min, prices[s]);
                }
                s++;
            }
            return profit;
        }
    }

    public class Solution2 {
        public int maxProfit(int[] prices) {
            if (prices.length < 1) {
                return 0;
            }
            int min = prices[0], profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < min) {
                    min = prices[i];
                } else {
                    if (prices[i] - min > profit) {
                        profit = prices[i] - min;
                    }
                }
            }
            return profit;
        }
    }

}
