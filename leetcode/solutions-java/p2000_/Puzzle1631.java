package p2000_;

/**
 * https://leetcode.com/problems/path-with-minimum-effort/
 *
 * @author half-dead
 */
public class Puzzle1631 {

    class Solution {
        public int minimumEffortPath(int[][] m) {
            int rows = m.length, cols = m[0].length, lo = 0, hi = 1000000;
            while (lo < hi) {
                int mid = (lo + hi) >> 1;
                if (check(m, mid, rows, cols)) hi = mid;
                else lo = mid + 1;
            }
            return hi;
        }

        boolean check(int[][] m, int e, int rows, int cols) {
            boolean[][] visited = new boolean[rows][cols];
            return dfs(m, e, 0, 0, visited, rows, cols);
        }

        boolean dfs(int[][] m, int e, int r, int c, boolean[][] visited, int rows, int cols) {
            if (r == rows - 1 && c == cols - 1) return true;

            visited[r][c] = true;
            int h = m[r][c];

            boolean b = false;
            if (r > 0 && !visited[r - 1][c] && Math.abs(h - m[r - 1][c]) <= e)
                b = dfs(m, e, r - 1, c, visited, rows, cols);

            if (!b && c > 0 && !visited[r][c - 1] && Math.abs(h - m[r][c - 1]) <= e)
                b = dfs(m, e, r, c - 1, visited, rows, cols);

            if (!b && r + 1 < rows && !visited[r + 1][c] && Math.abs(h - m[r + 1][c]) <= e)
                b = dfs(m, e, r + 1, c, visited, rows, cols);

            if (!b && c + 1 < cols && !visited[r][c + 1] && Math.abs(h - m[r][c + 1]) <= e)
                b = dfs(m, e, r, c + 1, visited, rows, cols);

            return b;
        }
    }
}
