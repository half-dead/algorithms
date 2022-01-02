/*
https://leetcode.com/problems/unique-paths-ii/description/

A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
The robot can only move either down or right at any point in time.
The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
Now consider if some obstacles are added to the grids. How many unique paths would there be?
An obstacle and empty space is marked as 1 and 0 respectively in the grid.

Note: m and n will be at most 100.

Example 1:
    Input:
        [
          [0,0,0],
          [0,1,0],
          [0,0,0]
        ]
    Output: 2
    Explanation:
        There is one obstacle in the middle of the 3x3 grid above.
        There are two ways to reach the bottom-right corner:
        1. Right -> Right -> Down -> Down
        2. Down -> Down -> Right -> Right
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle063_UniqPathsII {

    public static void main(String[] args) {
        Solution s = new Puzzle063_UniqPathsII().new Solution();
        System.out.println(s.uniquePathsWithObstacles(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

    class Solution {
        public int uniquePathsWithObstacles(int[][] obstacleGrid) {
            int rows = obstacleGrid.length;
            int cols = obstacleGrid[0].length;
            int[][] dp = new int[rows][cols];
            dp[0][0] = 1;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (obstacleGrid[i][j] != 1) {
                        int step = dp[i][j];
                        if (i > 0) {
                            step += dp[i - 1][j];
                        }
                        if (j > 0) {
                            step += dp[i][j - 1];
                        }
                        dp[i][j] = step;
                    } else {
                        dp[i][j] = 0;
                    }
                }
            }
            return dp[rows - 1][cols - 1];
        }
    }
}
