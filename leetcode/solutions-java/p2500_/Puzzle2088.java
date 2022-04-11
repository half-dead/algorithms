package p2500_;

/**
 * https://leetcode.com/problems/count-fertile-pyramids-in-a-land/
 *
 * @author half-dead
 */
public class Puzzle2088 {

    public static void main(String[] args) {
        Solution solution = new Puzzle2088().new Solution();
        System.out.println(solution.countPyramids(new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {1, 1, 1, 1, 1},
                {0, 1, 0, 0, 1}
        }));
    }

    // dp
    class Solution {
        public int countPyramids(int[][] grid) {
            int m = grid.length, n = grid[0].length, res = 0;

            int[][] ones = new int[m][n];
            System.arraycopy(grid[0], 0, ones[0], 0, n);
            for (int i = 1; i < m; i++) {
                for (int j = 0, cnt = 0; j < n; j++) {
                    cnt = grid[i][j] == 0 ? 0 : (cnt + 1);
                    ones[i][j] = cnt;
                    if (j > 0) {
                        ones[i][j] = Math.min(ones[i - 1][j - 1] + 2, ones[i][j]);
                        int max = Math.max(0, ones[i][j]);
                        res += (max - 1) / 2;
                    }
                }
            }

            ones = new int[m][n];
            System.arraycopy(grid[m - 1], 0, ones[m - 1], 0, n);
            for (int i = m - 2; i >= 0; i--) {
                for (int j = 0, cnt = 0; j < n; j++) {
                    cnt = grid[i][j] == 0 ? 0 : (cnt + 1);
                    ones[i][j] = cnt;
                    if (j > 0) {
                        ones[i][j] = Math.min(ones[i + 1][j - 1] + 2, ones[i][j]);
                        int max = Math.max(0, ones[i][j]);
                        res += (max - 1) / 2;
                    }
                }
            }
            return res;
        }
    }
}
