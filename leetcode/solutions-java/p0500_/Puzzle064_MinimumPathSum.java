/*
https://leetcode.com/problems/minimum-path-sum/description/

Given a m x n grid filled with non-negative numbers,
find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

Example:

    Input:
    [
      [1,3,1],
      [1,5,1],
      [4,2,1]
    ]
    Output: 7
    Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle064_MinimumPathSum {

    class Solution {
        public int minPathSum(int[][] grid) {
            int rows = grid.length;
            int cols = grid[0].length;
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    int step = grid[i][j];
                    if (i == 0) {
                        if (j > 0) {
                            step += dp[i][j - 1];
                        }
                    } else if (j == 0) {
                        step += dp[i - 1][j];
                    } else {
                        step = Math.min(step + dp[i - 1][j], step + dp[i][j - 1]);
                    }
                    dp[i][j] = step;
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
}
