package p1500_;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/shortest-path-in-binary-matrix/
 *
 * @author half-dead
 */
public class Puzzle1091 {
    public static void main(String[] args) {
        Solution s = new Puzzle1091().new Solution();
        System.out.println(s.shortestPathBinaryMatrix(new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}}));
    }

    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            int n = grid.length, step = 0;
            if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) return -1;

            int[][] neighbours = new int[][]{{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}};
            Queue<Integer> q = new LinkedList<>();
            q.offer(0);
            boolean[][] visited = new boolean[n][n];
            visited[0][0] = true;
            while (q.size() > 0) {
                step++;
                int size = q.size();
                while (size-- > 0) {
                    int top = q.poll();
                    int r = top >> 9, c = top & 127;
                    if (r == n - 1 && c == n - 1) return step;

                    for (int[] neigh : neighbours) {
                        int nr = r + neigh[0], nc = c + neigh[1];
                        if (nr >= 0 && nc >= 0 && nr < n && nc < n && grid[nr][nc] == 0 && !visited[nr][nc]) {
                            visited[nr][nc] = true;
                            q.offer((nr << 9) | nc);
                        }
                    }
                }
            }
            return -1;
        }
    }
}
