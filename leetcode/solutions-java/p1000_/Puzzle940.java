package p1000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/distinct-subsequences-ii/
 *
 * @author half-dead
 */
public class Puzzle940 {

    // dp, O(N) time, O(N) space
    class Solution {
        public int distinctSubseqII(String s) {
            int n = s.length(), mod = (int) 1e9 + 7;

            long[] dp = new long[n + 1], ps = new long[n + 1];
            dp[0] = ps[0] = 1L;

            int[] last = new int[128];
            Arrays.fill(last, -1);

            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);

                long curr = ps[i];
                if (last[c] >= 0) curr -= ps[last[c]];

                dp[i + 1] = (curr + mod) % mod;
                ps[i + 1] = (ps[i] + dp[i + 1]) % mod;
                last[c] = i;
            }

            long res = 0L;
            for (int i = 1; i <= n; i++) res = (res + dp[i]) % mod;
            return (int) res;
        }
    }

    // further improved dp, O(N) time, O(1) space
    class Solution1 {
        public int distinctSubseqII(String s) {
            int n = s.length(), mod = (int) 1e9 + 7, res = 0;
            int[] dp = new int[26];
            for (int i = 0; i < n; i++) {
                int j = s.charAt(i) - 'a';
                int cur = (1 + res - dp[j] + mod) % mod;
                res = (res + cur) % mod;
                dp[j] = (dp[j] + cur) % mod;
            }
            return res;
        }
    }
}
