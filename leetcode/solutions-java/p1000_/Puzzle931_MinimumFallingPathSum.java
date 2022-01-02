package p1000_;

/**
 * https://leetcode.com/problems/minimum-falling-path-sum/
 *
 * @author half-dead
 */
public class Puzzle931_MinimumFallingPathSum {
    class Solution {
        public int minFallingPathSum(int[][] arr) {
            int rows = arr.length;
            int cols = arr[0].length;
            int[][] dp = new int[rows][cols];
            System.arraycopy(arr[0], 0, dp[0], 0, cols);

            for (int i = 1; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int prev = dp[i - 1][j];
                    if (j > 0) {
                        prev = Math.min(prev, dp[i - 1][j - 1]);
                    }
                    if (j < cols - 1) {
                        prev = Math.min(prev, dp[i - 1][j + 1]);
                    }
                    dp[i][j] = arr[i][j] + prev;
                }
            }

            int min = dp[rows - 1][0];
            for (int i : dp[rows - 1]) {
                if (min > i) {
                    min = i;
                }
            }
            return min;
        }
    }
}
