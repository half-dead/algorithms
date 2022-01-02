package p1500_;

/**
 * https://leetcode.com/problems/path-with-maximum-gold/
 *
 * @author half-dead
 */
public class Puzzle1219 {
    public static void main(String[] args) {
        Solution s = new Puzzle1219().new Solution();
        System.out.println(s.getMaximumGold(new int[][]{{0, 6, 0}, {5, 8, 7}, {0, 9, 0}}));
        System.out.println(s.getMaximumGold(new int[][]{{1, 0, 7}, {2, 0, 6}, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}}));
    }

    class Solution {
        public int getMaximumGold(int[][] grid) {
            int rows = grid.length, cols = grid[0].length, minNeighbors = 4;
            int[][] neighbors = new int[rows][cols];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++) {
                    if (grid[r][c] > 0) {
                        int count = 0;
                        if (r > 0 && grid[r - 1][c] > 0) count++;
                        if (c > 0 && grid[r][c - 1] > 0) count++;
                        if (r + 1 < rows && grid[r + 1][c] > 0) count++;
                        if (c + 1 < cols && grid[r][c + 1] > 0) count++;
                        if (count > 0) minNeighbors = Math.min(minNeighbors, (neighbors[r][c] = count));
                    }
                }

            int[] res = new int[1];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    if (neighbors[r][c] <= minNeighbors && grid[r][c] > 0) backtracking(grid, r, c, 0, res);
            return res[0];
        }

        private void backtracking(int[][] grid, int r, int c, int gold, int[] res) {
            if (r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] <= 0) {
                res[0] = Math.max(res[0], gold);
                return;
            }
            gold += grid[r][c];
            grid[r][c] = -grid[r][c];
            backtracking(grid, r - 1, c, gold, res);
            backtracking(grid, r + 1, c, gold, res);
            backtracking(grid, r, c + 1, gold, res);
            backtracking(grid, r, c - 1, gold, res);
            grid[r][c] = -grid[r][c];
        }
    }

}
