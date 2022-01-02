package p2000_;

/**
 * https://leetcode.com/problems/maximum-score-from-performing-multiplication-operations/
 *
 * @author half-dead
 */
public class Puzzle1770 {

    // top-down dp, O(m^2) space
    class Solution0 {
        int n, m;
        int[] ns, ms;
        Integer[][] dp;

        public int maximumScore(int[] nums, int[] multipliers) {
            n = nums.length;
            m = multipliers.length;
            ns = nums;
            ms = multipliers;
            dp = new Integer[m][m];
            return dfs(0, 0);
        }

        private int dfs(int i, int j) {
            if (j == m) return 0;
            if (dp[i][j] != null) return dp[i][j];

            int head = dfs(i + 1, j + 1), tail = dfs(i, j + 1);
            return dp[i][j] = Math.max(head + ns[i] * ms[j], tail + ns[n - 1 - (j - i)] * ms[j]);
        }
    }

    // bottom-up dp, not quite intuitive, O(m) space
    class Solution {
        public int maximumScore(int[] ns, int[] ms) {
            int n = ns.length, m = ms.length;
            int[] dp = new int[m + 1];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j <= i; j++) {
                    int pf1 = (ms[i] * ns[j]) + dp[j + 1];
                    int pf2 = (ms[i] * ns[n - 1 - (i - j)]) + dp[j];

                    dp[j] = Math.max(pf1, pf2);
                }
            }
            return dp[0];
        }
    }
}
