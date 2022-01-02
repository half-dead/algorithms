package p1500_;

/**
 * https://leetcode.com/problems/largest-1-bordered-square/
 *
 * @author half-dead
 */
public class Puzzle1139 {
    class Solution {
        public int largest1BorderedSquare(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int[][] left = new int[rows][cols], top = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] == 1) {
                        left[r][c] = c > 0 ? left[r][c - 1] + 1 : 1;
                        top[r][c] = r > 0 ? top[r - 1][c] + 1 : 1;
                    }
                }
            }

            for (int len = Math.min(rows, cols); len >= 1; len--) {
                for (int r = 0, maxR = rows - len + 1; r < maxR; r++) {
                    for (int c = 0, maxC = cols - len + 1; c < maxC; c++) {
                        int r2 = r + len - 1, c2 = c + len - 1;
                        if (left[r][c2] >= len && left[r2][c2] >= len && top[r2][c] >= len && top[r2][c2] >= len) {
                            return len * len;
                        }
                    }
                }
            }
            return 0;
        }
    }
}
