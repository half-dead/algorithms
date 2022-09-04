package p2500_;

/**
 * https://leetcode.com/problems/number-of-people-aware-of-a-secret/
 *
 * @author half-dead
 */
public class Puzzle2327 {

    class Solution {
        public int peopleAwareOfSecret(int n, int delay, int forget) {
            int mod = (int) 1e9 + 7, ans = 1;
            int[] dp = new int[n + 1];
            dp[1] = 1;
            for (int i = 2; i <= n; i++) {
                for (int a = Math.max(1, i - forget + 1); a <= i - delay; a++) {
                    dp[i] += dp[a];
                    dp[i] %= mod;
                }
                ans = (ans + dp[i]) % mod;
                ans = (ans - dp[Math.max(0, i - forget)] + mod) % mod;

            }
            return ans;
        }
    }
}
