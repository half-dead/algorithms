package p1000_;

/**
 * https://leetcode.com/problems/bricks-falling-when-hit/
 *
 * @author half-dead
 */
public class Puzzle803 {

    // dfs
    // apply all hits, then recover from back
    class Solution {
        final int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int[] hitBricks(int[][] grid, int[][] hits) {
            int m = grid.length, n = grid[0].length, len = hits.length;

            // apply all hits, doesn't matter if there are more than one hit for some point
            for (int[] hit : hits) grid[hit[0]][hit[1]]--;

            // mark as stable
            for (int c = 0; c < n; c++) dfs(0, c, grid, m, n);

            int[] res = new int[len];
            // recover from back to front
            for (int i = len - 1; i >= 0; i--) {
                int[] h = hits[i];
                if (++grid[h[0]][h[1]] == 1 && stable(h[0], h[1], grid, m, n))
                    res[i] = dfs(h[0], h[1], grid, m, n) - 1;
            }
            return res;
        }

        int dfs(int r, int c, int[][] g, int m, int n) {
            if (r < 0 || c < 0 || r >= m || c >= n || g[r][c] != 1) return 0;
            g[r][c] = 2;
            int ans = 1;
            for (int[] d : dirs) ans += dfs(r + d[0], c + d[1], g, m, n);
            return ans;
        }

        boolean stable(int r, int c, int[][] g, int m, int n) {
            if (r == 0) return true;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr >= 0 && nr < m && nc >= 0 && nc < n && g[nr][nc] == 2) return true;
            }
            return false;
        }
    }
}
