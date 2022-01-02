package p2000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/last-day-where-you-can-still-cross/
 *
 * @author half-dead
 */
public class Puzzle1970 {

    public static void main(String[] args) {
        Solution s = new Puzzle1970().new Solution();
        System.out.println(s.latestDayToCross(3, 3, new int[][]{
//                {1, 1}, {2, 1}, {1, 2}, {2, 2}
                {1, 2}, {2, 1}, {3, 3}, {2, 2}, {1, 1}, {1, 3}, {2, 3}, {3, 2}, {3, 1}
        }));
    }

    // binary search + dfs
    // the other approach is loop from right to left, and use union find,
    // when ever a top cell and a bottom is in the same set, that's our answer
    class Solution {
        int rows, cols;
        Set<Integer> waters;
        int[][] dirs = new int[][]{{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        public int latestDayToCross(int rows, int cols, int[][] cells) {
            int n = rows * cols;
            waters = new HashSet<>(n);
            this.rows = rows;
            this.cols = cols;

            int lo = 0, hi = n - 1, prev = 0;
            while (lo < hi) {
                int mid = (lo + hi + 1) / 2;
                reset(cells, prev, mid);
                if (cross()) {
                    lo = mid;
                } else {
                    hi = mid - 1;
                }
                prev = mid;
            }
            return lo;
        }

        boolean cross() {
            boolean[][] visited = new boolean[rows + 1][cols + 1];
            for (int c = 1; c <= cols; c++) {
                if (visited[1][c]) continue;
                if (waters.contains(cols + c)) continue;
                if (dfs(1, c, visited))
                    return true;
            }
            return false;
        }

        boolean dfs(int r, int c, boolean[][] visited) {
            if (r == rows) return true;
            if (visited[r][c]) return false;

            visited[r][c] = true;
            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr <= 0 || nr > rows || nc <= 0 || nc > cols) continue;
                if (waters.contains(nr * cols + nc)) continue;
                if (dfs(nr, nc, visited)) return true;
            }
            return false;
        }

        void reset(int[][] cells, int from, int to) {
            boolean forward = from < to;
            for (int i = Math.min(from, to); i < Math.max(from, to); i++) {
                int r = cells[i][0], c = cells[i][1];
                if (forward) waters.add(r * cols + c);
                else waters.remove(r * cols + c);
            }
        }
    }
}
