package p1000_;

/**
 * https://leetcode.com/problems/projection-area-of-3d-shapes/
 *
 * @author half-dead
 */
public class Puzzle883 {
    class Solution {
        public int projectionArea(int[][] grid) {
            int res = 0, n = grid.length;
            for (int r = 0; r < n; r++) {
                int rMax = 0, cMax = 0;
                for (int c = 0; c < n; c++) {
                    if (grid[r][c] > 0) res++;
                    rMax = Math.max(rMax, grid[r][c]);
                    cMax = Math.max(cMax, grid[c][r]);
                }
                res += rMax + cMax;
            }
            return res;
        }
    }
}
