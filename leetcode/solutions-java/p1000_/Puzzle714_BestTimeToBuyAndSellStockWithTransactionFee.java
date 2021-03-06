/*
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/

Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i;
and a non-negative integer fee representing a transaction fee.

You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)

Return the maximum profit you can make.

Example 1:
    Input: prices = [1, 3, 2, 8, 4, 9], fee = 2
    Output: 8
    Explanation: The maximum profit can be achieved by:
    Buying at prices[0] = 1
    Selling at prices[3] = 8
    Buying at prices[4] = 4
    Selling at prices[5] = 9
    The total profit is ((8 - 1) - 2) + ((9 - 4) - 2) = 8.
Note:
    0 < prices.length <= 50000.
    0 < prices[i] < 50000.
    0 <= fee < 50000.
 */

package p1000_;

/**
 * @author half-dead
 */
public class Puzzle714_BestTimeToBuyAndSellStockWithTransactionFee {
    class Solution {
        public int maxProfit(int[] prices, int fee) {
            int hold = -prices[0], sold = 0;
            for (int i : prices) {
                int newSold = Math.max(sold, hold + i - fee);
                hold = Math.max(hold, sold - i);
                sold = newSold;
            }
            return Math.max(hold, sold);
        }
    }

    class Solution1 {
        public int maxProfit(int[] prices, int fee) {
            if (prices == null || prices.length <= 1) {
                return 0;
            }

            int profit = 0;
            int start = prices[0];
            int end = start + fee;

            for (int i = 1; i < prices.length; i++) {
                int current = prices[i];

                if (current > end) {
                    end = current;
                } else if (current < end - fee) {
                    profit += end - start - fee;
                    start = current;
                    end = start + fee;
                }
            }

            profit += end - start - fee;
            return profit;
        }
    }
}
