package p1500_;

/**
 * https://leetcode.com/problems/maximum-side-length-of-a-square-with-sum-less-than-or-equal-to-threshold/
 *
 * @author half-dead
 */
public class Puzzle1292 {
    class Solution {
        public int maxSideLength(int[][] mat, int threshold) {
            int m = mat.length, n = mat[0].length, res = 0;
            int[][] dp = new int[m + 1][n + 1];
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    dp[r + 1][c + 1] = dp[r][c + 1] + dp[r + 1][c] - dp[r][c] + mat[r][c];

                    int edge = Math.min(r, c) + 1, len = res + 1;
                    while (len <= edge) {
                        int sum = dp[r + 1][c + 1] - dp[r + 1 - len][c + 1] - dp[r + 1][c + 1 - len] + dp[r + 1 - len][c + 1 - len];
                        if (sum <= threshold) res = Math.max(res, len++);
                        else break;
                    }
                }
            }
            return res;
        }
    }
}
