package p1000_;

/**
 * https://leetcode.com/problems/surface-area-of-3d-shapes/
 *
 * @author half-dead
 */
public class Puzzle892_SurfaceAreaOf3DShapes {
    class Solution {
        public int surfaceArea(int[][] grid) {
            int area = 0, n = grid.length;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int v = grid[i][j];
                    if (v > 0) area += 2 + (v << 2);
                    if (i > 0) area -= Math.min(grid[i - 1][j], v) << 1;
                    if (j > 0) area -= Math.min(grid[i][j - 1], v) << 1;
                }
            }
            return area;
        }
    }
}
