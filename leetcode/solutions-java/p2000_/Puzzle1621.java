package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/
 *
 * see this post
 * https://leetcode.com/problems/number-of-sets-of-k-non-overlapping-line-segments/discuss/898830/Python-O(N)-Solution-with-Prove
 *
 * @author half-dead
 */
public class Puzzle1621 {


    // Bottom-Up DP, O(NO) time, O(NK)space
    class Solution {
        public int numberOfSets(int n, int k) {
            int mod = (int) 1e9 + 7;

            int[][] dp = new int[k + 1][n + 1];
            Arrays.fill(dp[0], 1);
            dp[0][0] = 0;

            for (int i = 1; i <= k; i++) {
                int sum = 0;
                for (int j = 1; j <= n; j++) {
                    dp[i][j] = (sum + dp[i][j - 1]) % mod;
                    sum = (sum + dp[i - 1][j]) % mod;
                }
            }
            return dp[k][n];
        }
    }
}
