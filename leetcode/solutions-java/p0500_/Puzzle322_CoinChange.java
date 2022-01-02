package p0500_;

/**
 * https://leetcode.com/problems/coin-change/
 *
 * @author half-dead
 */
public class Puzzle322_CoinChange {
    public static void main(String[] args) {
        Puzzle322_CoinChange p = new Puzzle322_CoinChange();
        Solution s = p.new Solution();
        System.out.println(s.coinChange(new int[]{1, 2, 5}, 11));
        System.out.println(s.coinChange(new int[]{2}, 3));

    }

    class Solution {
        public int coinChange(int[] coins, int amount) {
            int len = amount + 1;
            int[] dp = new int[len];
            for (int i = 1; i < len; i++) dp[i] = len;

            for (int coin : coins)
                for (int i = 0; i < len - coin; i++)
                    dp[i + coin] = Math.min(dp[i + coin], dp[i] + 1);
            return dp[amount] > amount ? -1 : dp[amount];
        }
    }
}
