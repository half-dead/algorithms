package p2500_;

/**
 * https://leetcode.com/problems/number-of-ways-to-reach-a-position-after-exactly-k-steps/
 *
 * @author half-dead
 */
public class Puzzle2400 {

    public static void main(String[] args) {
        Solution s = new Puzzle2400().new Solution();
        for (int k = 2; k <= 1000; k += 2) {
            System.out.println(s.numberOfWays(1, 1, k));
        }
    }

    // dumb dp
    class Solution {
        public int numberOfWays(int start, int end, int k) {
            int n = 3000, x = 1000, j = 0, mod = (int) (1e9 + 7);
            long[] dp = new long[n];
            dp[start + x] = 1;
            while (j < k) {
                long[] next = new long[n];
                for (int i = start + x - j; i <= start + x + j; i++) {
                    if (i - 1 >= 0) {
                        next[i - 1] += dp[i];
                    }
                    if (i + 1 < n) {
                        next[i + 1] += dp[i];
                    }
                }
                dp = next;
                for (int i = start + x - j; i <= start + x + j; i++) {
                    dp[i] %= mod;
                }
                j++;
            }
            return (int) (dp[end + x] % mod);
        }
    }

    // combinatorics
    class MathSolution {
        final int mod = (int) (1e9 + 7);

        public int numberOfWays(int a, int b, int k) {
            if (Math.abs(a - b) > k) return 0;
            if ((a - b - k) % 2 != 0) return 0;

            long res = 1L;
            for (int i = 0; i < (b - a + k) / 2; ++i) {
                res = res * (k - i) % mod;
                res = res * inv(i + 1) % mod;
            }
            return (int) res;
        }

        // Modular multiplicative inverse
        // https://en.wikipedia.org/wiki/Modular_multiplicative_inverse
        private long inv(long a) {
            if (a == 1) return 1;
            return (mod - mod / a) * inv(mod % a) % mod;
        }
    }
}
