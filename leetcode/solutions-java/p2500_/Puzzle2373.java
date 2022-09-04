package p2500_;

/**
 * https://leetcode.com/problems/largest-local-values-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle2373 {
    class Solution {
        public int[][] largestLocal(int[][] grid) {
            int n = grid.length;
            int[][] res = new int[n - 2][n - 2];
            for (int r = 1; r < n - 1; r++) {
                for (int c = 1; c < n - 1; c++) {
                    int max = 0;
                    for (int i = r - 1; i <= r + 1; i++) {
                        for (int j = c - 1; j <= c + 1; j++) {
                            max = Math.max(max, grid[i][j]);
                        }
                    }
                    res[r - 1][c - 1] = max;
                }
            }
            return res;
        }
    }
}
