package p1000_;

/**
 * https://leetcode.com/problems/k-inverse-pairs-array/
 *
 * @author half-dead
 */
public class Puzzle629 {

    // bottom-up dp
    class Solution {
        public int kInversePairs(int n, int k) {
            int mod = (int) 1e9 + 7;
            long[] dp = new long[k + 1], next;
            dp[0] = 1;
            for (int i = 2; i <= n; i++) {
                next = new long[k + 1];
                long sum = 0L;
                for (int j = 0; j <= Math.min(k, i * (i - 1) / 2); j++) {
                    sum += dp[j];
                    if (j >= i) sum -= dp[j - i];
                    next[j] = sum % mod;
                }
                dp = next;
            }
            return (int) (dp[k] % mod);
        }
    }
}
