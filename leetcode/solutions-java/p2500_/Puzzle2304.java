package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/minimum-path-cost-in-a-grid/
 *
 * @author half-dead
 */
public class Puzzle2304 {

    public static void main(String[] args) {
        Solution s = new Puzzle2304().new Solution();
        int v = s.minPathCost(new int[][]{
                {5, 3}, {4, 0}, {2, 1}
        }, new int[][]{
                {9, 8}, {1, 5}, {10, 12}, {18, 6}, {2, 4}, {14, 3}
        });
        System.out.println(v);
    }

    class Solution {
        public int minPathCost(int[][] grid, int[][] moveCost) {
            int m = grid.length, n = grid[0].length;
            int[][] dp = new int[m][n];
            System.arraycopy(grid[0], 0, dp[0], 0, n);

            for (int i = 1; i < m; i++) {
                Arrays.fill(dp[i], Integer.MAX_VALUE);
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        int x = dp[i - 1][k] + grid[i][j] + moveCost[grid[i - 1][k]][j];
                        dp[i][j] = Math.min(dp[i][j], x);
                    }
                }
            }

            int res = Integer.MAX_VALUE;
            for (int x : dp[m - 1]) {
                res = Math.min(res, x);
            }
            return res;
        }
    }
}
