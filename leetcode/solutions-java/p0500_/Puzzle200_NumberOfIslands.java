package p0500_;

/**
 * https://leetcode.com/problems/number-of-islands/
 *
 * @author half-dead
 */
public class Puzzle200_NumberOfIslands {

    class Solution {
        private int rows, cols;

        public int numIslands(char[][] grid) {
            if (grid == null || grid.length < 1 || grid[0].length < 1) {
                return 0;
            }
            this.rows = grid.length;
            this.cols = grid[0].length;
            int count = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == '1') {
                        dfs(grid, i, j);
                        count++;
                    }
                }
            }
            return count;
        }

        void dfs(char[][] grid, int i, int j) {
            if (i < 0 || j < 0 || i >= rows || j >= cols || grid[i][j] == '0') {
                return;
            }
            grid[i][j] = '0';
            dfs(grid, i - 1, j);
            dfs(grid, i + 1, j);
            dfs(grid, i, j - 1);
            dfs(grid, i, j + 1);
        }
    }
}
