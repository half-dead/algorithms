package p1500_;

/**
 * https://leetcode.com/problems/as-far-from-land-as-possible/
 *
 * @author half-dead
 */
public class Puzzle1162 {

    class Solution {
        public int maxDistance(int[][] grid) {
            int n = grid.length, sum = 0, max = n * n, d = 1;
            for (int[] row : grid)
                for (int v : row) sum += v;
            if (sum == 0 || sum == max) return -1;

            while (sum < max) {
                for (int r = 0; r < n; r++) {
                    for (int c = 0; c < n; c++) {
                        if (grid[r][c] == 0) {
                            boolean aj = r > 0 && grid[r - 1][c] == d;
                            aj |= c > 0 && grid[r][c - 1] == d;
                            aj |= r + 1 < n && grid[r + 1][c] == d;
                            aj |= c + 1 < n && grid[r][c + 1] == d;
                            if (aj) {
                                grid[r][c] = d + 1;
                                if (++sum == max) return d;
                            }
                        }
                    }
                }
                d++;
            }
            return -1;
        }
    }
}
