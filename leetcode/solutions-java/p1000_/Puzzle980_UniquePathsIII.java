package p1000_;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 *
 * @author half-dead
 */
public class Puzzle980_UniquePathsIII {

    public static void main(String[] args) {
        Puzzle980_UniquePathsIII p = new Puzzle980_UniquePathsIII();
        Solution s = p.new Solution();
        int r = s.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});
        System.out.println(r);
    }

    class Solution {
        int count;

        public int uniquePathsIII(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;
            int total = rows * cols;
            int r = 0, c = 0;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (grid[i][j] == 1) {
                        r = i;
                        c = j;
                        break;
                    } else if (grid[i][j] == -1) {
                        total--;
                    }
                }
            }
            dfs(grid, r, c, rows, cols, total);
            return count;
        }

        void dfs(int[][] grid, int r, int c, int rows, int cols, int steps) {
            if (grid[r][c] == 2 && steps == 1) {
                count++;
                return;
            }
            int v = grid[r][c];
            grid[r][c] = -1;
            steps--;
            if (r > 0 && grid[r - 1][c] >= 0) dfs(grid, r - 1, c, rows, cols, steps);
            if (r + 1 < rows && grid[r + 1][c] >= 0) dfs(grid, r + 1, c, rows, cols, steps);
            if (c > 0 && grid[r][c - 1] >= 0) dfs(grid, r, c - 1, rows, cols, steps);
            if (c + 1 < cols && grid[r][c + 1] >= 0) dfs(grid, r, c + 1, rows, cols, steps);
            grid[r][c] = v;
        }
    }
}
