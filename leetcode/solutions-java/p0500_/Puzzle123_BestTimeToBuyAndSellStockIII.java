package p0500_;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 * @author half-dead
 */
public class Puzzle123_BestTimeToBuyAndSellStockIII {
    public static void main(String[] args) {
        Puzzle123_BestTimeToBuyAndSellStockIII p = new Puzzle123_BestTimeToBuyAndSellStockIII();
        Solution s = p.new Solution();
        System.out.println(s.maxProfit(new int[]{3, 3, 5, 0, 0, 3, 1, 4}));
        System.out.println(s.maxProfit(new int[]{1, 2, 3, 4, 5}));
        System.out.println(s.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }

    // O(k*n) space
    class Solution {
        public int maxProfit(int[] prices) {
            int len = prices.length;
            if (len == 0) return 0;
            // 0: count=0, not holding, 1: count=0, holding
            // 2: count=1, not holding, 3: count=1, holding
            // 4: count=2, not holding
            int[][] dp = new int[len][5];
            dp[0][1] = -prices[0];
            dp[0][3] = -prices[0];
            for (int i = 1; i < len; i++) {
                int[] prev = dp[i - 1];
                dp[i][0] = prev[0];
                dp[i][1] = Math.max(prev[0] - prices[i], prev[1]);
                dp[i][2] = Math.max(prev[1] + prices[i], prev[2]);
                dp[i][3] = Math.max(prev[2] - prices[i], prev[3]);
                dp[i][4] = Math.max(prev[3] + prices[i], prev[4]);
            }
            return Math.max(dp[len - 1][0], Math.max(dp[len - 1][2], dp[len - 1][4]));
        }
    }
}
