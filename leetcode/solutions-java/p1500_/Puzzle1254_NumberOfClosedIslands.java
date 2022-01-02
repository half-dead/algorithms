package p1500_;

/**
 * https://leetcode.com/problems/number-of-closed-islands/
 *
 * @author half-dead
 */
public class Puzzle1254_NumberOfClosedIslands {
    public static void main(String[] args) {
        Solution s = new Puzzle1254_NumberOfClosedIslands().new Solution();
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 1, 0},
                {1, 0, 1, 0, 1, 1, 1, 0},
                {1, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0}
        };
        int r = s.closedIsland(grid);
        System.out.println(r);
    }

    class Solution {
        public int closedIsland(int[][] grid) {
            int rows = grid.length, cols = grid[0].length, count = 0;
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (grid[i][j] == 0 && dfs(grid, i, j, rows, cols))
                        count++;
            return count;
        }

        private boolean dfs(int[][] grid, int i, int j, int rows, int cols) {
            grid[i][j] = 1;
            boolean b = i > 0 && j > 0 && i < rows - 1 && j < cols - 1;
            if (i - 1 >= 0 && grid[i - 1][j] == 0) b &= dfs(grid, i - 1, j, rows, cols);
            if (i + 1 < rows && grid[i + 1][j] == 0) b &= dfs(grid, i + 1, j, rows, cols);
            if (j - 1 >= 0 && grid[i][j - 1] == 0) b &= dfs(grid, i, j - 1, rows, cols);
            if (j + 1 < cols && grid[i][j + 1] == 0) b &= dfs(grid, i, j + 1, rows, cols);
            return b;
        }
    }
}
