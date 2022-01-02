package p0500_;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/
 *
 * @author half-dead
 */
public class Puzzle188_BestTimeToBuyAndSellStockIV {
    public static void main(String[] args) {
        Puzzle188_BestTimeToBuyAndSellStockIV p = new Puzzle188_BestTimeToBuyAndSellStockIV();
        Solution s = p.new Solution();
        System.out.println(s.maxProfit(2, new int[]{2, 4, 1}));
        System.out.println(s.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }

    class Solution {
        public int maxProfit(int k, int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;

            if (k > len / 2) {
                int profit = 0;
                for (int i = 1; i < len; i++) {
                    int gain = prices[i] - prices[i - 1];
                    if (gain > 0) profit += gain;
                }
                return profit;
            }

            int k2 = k * 2 + 1;
            int[] dp = new int[k2];
            for (int i = 1; i < k2; i += 2) {
                dp[i] = -prices[0];
            }
            for (int i = 1; i < len; i++) {
                for (int j = 1; j < k2; j++) {
                    if (j % 2 != 0) {
                        dp[j] = Math.max(dp[j - 1] - prices[i], dp[j]);
                    } else {
                        dp[j] = Math.max(dp[j - 1] + prices[i], dp[j]);
                    }
                }
            }
            int max = 0;
            for (int i = 0; i < k2; i += 2) {
                max = Math.max(max, dp[i]);
            }
            return max;
        }
    }
}
