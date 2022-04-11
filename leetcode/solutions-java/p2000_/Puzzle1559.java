package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/detect-cycles-in-2d-grid/
 *
 * @author half-dead
 */
public class Puzzle1559 {

    class Solution {
        int m, n;
        boolean[][] v;
        char[][] g;
        final int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public boolean containsCycle(char[][] grid) {
            m = grid.length;
            n = grid[0].length;
            v = new boolean[m][n];
            g = grid;

            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (v[r][c]) continue;

                    if (bfs(r, c)) return true;
                }
            }
            return false;
        }

        boolean bfs(int r, int c) {
            LinkedList<int[]> q = new LinkedList<>();
            q.addLast(new int[]{r, c, -1, -1});

            char val = g[r][c];
            while (q.size() > 0) {
                int[] top = q.pollFirst();
                int i = top[0], j = top[1];
                int pi = top[2], pj = top[3];
                if (v[i][j]) return true;

                v[i][j] = true;
                for (int[] d : dirs) {
                    int ni = i + d[0], nj = j + d[1];
                    if (ni < 0 || nj < 0 || ni >= m || nj >= n) continue;
                    if (g[ni][nj] != val) continue;
                    if (ni == pi && nj == pj) continue;

                    q.addLast(new int[]{ni, nj, i, j});
                }
            }
            return false;
        }
    }
}
