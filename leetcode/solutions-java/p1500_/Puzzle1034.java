package p1500_;

/**
 * https://leetcode.com/problems/coloring-a-border/
 *
 * @author half-dead
 */
public class Puzzle1034 {

    class Solution {
        int m, n;
        boolean[][] v, t;
        int[][] g;

        public int[][] colorBorder(int[][] grid, int r0, int c0, int color) {
            m = grid.length;
            n = grid[0].length;
            v = new boolean[m][n];
            t = new boolean[m][n];
            this.g = grid;

            dfs(r0, c0);
            for (int r = 0; r < m; r++)
                for (int c = 0; c < n; c++)
                    if (t[r][c])
                        g[r][c] = color;
            return g;
        }

        void dfs(int r, int c) {
            if (v[r][c]) return;
            v[r][c] = true;

            boolean b = false;
            if (r == 0 || g[r][c] != g[r - 1][c]) b = true;
            else dfs(r - 1, c);

            if (c == 0 || g[r][c] != g[r][c - 1]) b = true;
            else dfs(r, c - 1);

            if (r == m - 1 || g[r][c] != g[r + 1][c]) b = true;
            else dfs(r + 1, c);

            if (c == n - 1 || g[r][c] != g[r][c + 1]) b = true;
            else dfs(r, c + 1);
            t[r][c] = b;
        }
    }
}
