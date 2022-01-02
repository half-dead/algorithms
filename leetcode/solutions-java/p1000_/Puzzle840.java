package p1000_;

/**
 * https://leetcode.com/problems/magic-squares-in-grid/
 *
 * @author half-dead
 */
public class Puzzle840 {
    class Solution {
        final String a = "438167294381672", b = "492761834927618";

        public int numMagicSquaresInside(int[][] grid) {
            int cnt = 0;
            for (int r = 1; r < grid.length - 1; r++)
                for (int c = 1; c < grid[0].length - 1; c++)
                    if (grid[r][c] == 5 && isMagic(grid, r, c)) cnt++;
            return cnt;
        }

        private boolean isMagic(int[][] grid, int r, int c) {
            String s = "" + grid[r - 1][c - 1] + grid[r - 1][c] + grid[r - 1][c + 1] + grid[r][c + 1] + grid[r + 1][c + 1] + grid[r + 1][c] + grid[r + 1][c - 1] + grid[r][c - 1];
            return a.contains(s) || b.contains(s);
        }
    }
}
