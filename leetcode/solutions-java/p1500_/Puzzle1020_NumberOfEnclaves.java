package p1500_;

/**
 * https://leetcode.com/problems/number-of-enclaves/
 *
 * @author half-dead
 */
public class Puzzle1020_NumberOfEnclaves {
    public static void main(String[] args) {
        Puzzle1020_NumberOfEnclaves p = new Puzzle1020_NumberOfEnclaves();
        Solution s = p.new Solution();
        System.out.println(s.numEnclaves(new int[][]{
                {0, 1, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 0},
        }));
    }

    class Solution {
        public int numEnclaves(int[][] grid) {
            int rows = grid.length, cols = grid[0].length, rows1 = rows - 1, cols1 = cols - 1;
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if ((i == 0 || j == 0 || i == rows1 || j == cols1) && grid[i][j] == 1) dfs(grid, rows, cols, i, j);
            int count = 0;
            for (int i = 0; i < rows; i++) for (int j = 0; j < cols; j++) if (grid[i][j] == 1) count++;
            return count;
        }

        private void dfs(int[][] grid, int rows, int cols, int r, int c) {
            if (r < 0 || c < 0 || r == rows || c == cols || grid[r][c] == 0) return;
            grid[r][c] = 0;
            dfs(grid, rows, cols, r - 1, c);
            dfs(grid, rows, cols, r + 1, c);
            dfs(grid, rows, cols, r, c - 1);
            dfs(grid, rows, cols, r, c + 1);
        }
    }
}
