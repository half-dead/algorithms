package p2500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-trailing-zeros-in-a-cornered-path/
 *
 * @author half-dead
 */
public class Puzzle2245 {

    // prefix sum, factors of 2 and 5
    class Solution {
        public int maxTrailingZeros(int[][] grid) {
            int m = grid.length, n = grid[0].length, res = 0;

            int[][][] factors = new int[m][n][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j], c5 = 0, c2 = 0;
                    while (v > 0 && v % 5 == 0) {
                        c5++;
                        v /= 5;
                    }
                    while (v > 0 && v % 2 == 0) {
                        c2++;
                        v >>= 1;
                    }
                    factors[i][j] = new int[]{c2, c5};
                }
            }

            // [left, right, up, down]
            int[][][][] ps = new int[m][n][4][2];
            for (int r = 0; r < m; r++) {
                int[] left = new int[]{0, 0}, right = new int[]{0, 0};
                for (int c0 = 0, c1 = n - 1; c0 < n; c0++, c1--) {
                    left[0] += factors[r][c0][0];
                    left[1] += factors[r][c0][1];
                    right[0] += factors[r][c1][0];
                    right[1] += factors[r][c1][1];
                    ps[r][c0][0] = Arrays.copyOf(left, 2);
                    ps[r][c1][1] = Arrays.copyOf(right, 2);
                }
            }

            for (int c = 0; c < n; c++) {
                int[] up = new int[]{0, 0}, down = new int[]{0, 0};
                for (int r0 = 0, r1 = m - 1; r0 < m; r0++, r1--) {
                    up[0] += factors[r0][c][0];
                    up[1] += factors[r0][c][1];
                    down[0] += factors[r1][c][0];
                    down[1] += factors[r1][c][1];
                    ps[r0][c][2] = Arrays.copyOf(up, 2);
                    ps[r1][c][3] = Arrays.copyOf(down, 2);
                }
            }

            // [left, right, up, down]
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    int[][] cell = ps[r][c];
                    for (int h = 0; h <= 1; h++) {
                        for (int v = 2; v <= 3; v++) {
                            res = Math.max(res, Math.min(cell[h][0] + cell[v][0] - factors[r][c][0],
                                    cell[h][1] + cell[v][1] - factors[r][c][1]));
                        }
                    }
                }
            }
            return res;
        }
    }
}
