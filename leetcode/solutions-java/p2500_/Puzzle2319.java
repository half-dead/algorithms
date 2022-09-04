package p2500_;

/**
 * https://leetcode.com/problems/check-if-matrix-is-x-matrix/
 *
 * @author half-dead
 */
public class Puzzle2319 {

    class Solution {
        public boolean checkXMatrix(int[][] grid) {
            int n = grid.length, sum = 0;
            for (int[] row : grid) {
                for (int v : row) {
                    sum += v;
                }
            }

            int temp = 0;
            for (int i = 0; i < n; i++) {
                if (grid[i][i] == 0) return false;
                temp += grid[i][i];
            }
            for (int i = n - 1, j = 0; i >= 0; i--, j++) {
                if (grid[i][j] == 0) return false;
                temp += grid[i][j];
            }

            if (n % 2 != 0) {
                temp -= grid[n / 2][n / 2];
            }
            return temp == sum;
        }
    }
}
