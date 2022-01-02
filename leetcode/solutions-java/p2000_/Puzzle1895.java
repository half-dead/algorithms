package p2000_;

/**
 * https://leetcode.com/problems/largest-magic-square/
 *
 * @author half-dead
 */
public class Puzzle1895 {

    public static void main(String[] args) {
        Solution s = new Puzzle1895().new Solution();
        System.out.println(s.largestMagicSquare(new int[][]{
                {7, 1, 4, 5, 6},
                {2, 5, 1, 6, 4},
                {1, 5, 4, 3, 2},
                {1, 2, 7, 3, 4}
        }));
    }

    class Solution {
        public int largestMagicSquare(int[][] grid) {
            int m = grid.length, n = grid[0].length, max = Math.min(m, n);
            int[][] rowps = new int[m + 1][n + 1], colps = new int[m + 1][n + 1];
            int[][] dgps = new int[m + 1][n + 1], rdgps = new int[m + 2][n + 2];
            for (int r = 1; r <= m; r++) {
                for (int c = 1; c <= n; c++) {
                    int v = grid[r - 1][c - 1];
                    rowps[r][c] = rowps[r][c - 1] + v;
                    colps[r][c] = colps[r - 1][c] + v;
                    dgps[r][c] = dgps[r - 1][c - 1] + v;
                    rdgps[r][c] = rdgps[r - 1][c + 1] + v;
                }
            }
            while (max > 1) {
                for (int r = 0; r < m; r++) {
                    if (r + max > m) break;
                    for (int c = 0; c < n; c++) {
                        if (c + max > n) break;
                        if (check(rowps, colps, dgps, rdgps, r, c, max)) return max;
                    }
                }
                max--;
            }
            return max;
        }

        boolean check(int[][] rowps, int[][] colps, int[][] dgps, int[][] rdgps, int r, int c, int e) {
            int dgsum = dgps[r + e][c + e] - dgps[r][c];
            int rdgsum = rdgps[r + e][c + 1] - rdgps[r][c + e + 1];
            if (rdgsum != dgsum) return false;

            for (int k = 0; k < e; k++) {
                if (rowps[r + 1 + k][c + e] - rowps[r + 1 + k][c] != dgsum)
                    return false;
                if (colps[r + e][c + 1 + k] - colps[r][c + 1 + k] != dgsum)
                    return false;
            }
            return true;
        }
    }
}
