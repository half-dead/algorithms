package p1500_;

/**
 * https://leetcode.com/problems/count-square-submatrices-with-all-ones/
 *
 * @author half-dead
 */
public class Puzzle1277 {

    class Solution {
        public int countSquares(int[][] m) {
            int res = 0, rows = m.length, cols = m[0].length;
            for (int r = 0; r < rows; ++r) {
                for (int c = 0; c < cols; ++c) {
                    if (m[r][c] > 0 && r > 0 && c > 0)
                        m[r][c] = Math.min(m[r - 1][c - 1], Math.min(m[r - 1][c], m[r][c - 1])) + 1;
                    res += m[r][c];
                }
            }
            return res;
        }
    }

    // Brute Force
    class BFSolution {
        public int countSquares(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            int[][] dp = new int[rows + 1][cols + 1];
            int ans = 0;
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (matrix[r][c] == 1) ans++;
                    dp[r + 1][c + 1] = dp[r + 1][c] + dp[r][c + 1] + matrix[r][c] - dp[r][c];
                }
            }

            int len = 2, max = Math.min(rows, cols);
            while (len <= max) {
                int expected = len * len;
                for (int r = len; r <= rows; r++) {
                    for (int c = len; c <= cols; c++) {
                        if (dp[r][c] - dp[r - len][c] - dp[r][c - len] + dp[r - len][c - len] == expected) ans++;
                    }
                }
                len++;
            }
            return ans;
        }
    }
}
