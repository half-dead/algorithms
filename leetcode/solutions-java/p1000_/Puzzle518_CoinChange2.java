package p1000_;

/**
 * https://leetcode.com/problems/coin-change-2/
 *
 * @author half-dead
 */
public class Puzzle518_CoinChange2 {
    public static void main(String[] args) {
        Puzzle518_CoinChange2 p = new Puzzle518_CoinChange2();
        Solution s = p.new Solution();
        System.out.println(s.change(500, new int[]{1, 2, 5}));
    }

    class Solution {
        public int change(int amount, int[] coins) {
            int[] dp = new int[amount + 1];
            dp[0] = 1;
            for (int coin : coins)
                for (int j = coin; j <= amount; j++)
                    dp[j] += dp[j - coin];
            return dp[amount];
        }
    }
}
