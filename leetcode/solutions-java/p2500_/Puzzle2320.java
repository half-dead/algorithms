package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/count-number-of-ways-to-place-houses/
 *
 * @author half-dead
 */
public class Puzzle2320 {

    class Solution {
        public int countHousePlacements(int n) {
            int mod = (int) (1e9 + 7);
            long sum = 0L;

            long[] dp = new long[4];
            Arrays.fill(dp, 1L);

            for (int i = 2; i <= n; i++) {
                long[] next = new long[4];
                Arrays.fill(next, dp[0]);
                next[0] += dp[1];
                next[2] += dp[1];
                next[0] += dp[2];
                next[1] += dp[2];
                next[0] += dp[3];

                dp = next;
                for (int j = 0; j < 4; j++) {
                    dp[j] %= mod;
                }
            }

            for (long x : dp) sum += x;
            return (int) (sum % mod);
        }
    }

    class FibonacciSolution {
        public int countHousePlacements(int n) {
            int a = 1, b = 1, c, mod = (int) 1e9 + 7;
            for (int i = 0; i < n; ++i) {
                c = (a + b) % mod;
                a = b;
                b = c;
            }
            return (int) ((long) b * b % mod);
        }
    }
}
