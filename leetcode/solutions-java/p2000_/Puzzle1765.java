package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/map-of-highest-peak/
 *
 * @author half-dead
 */
public class Puzzle1765 {

    class Solution {
        public int[][] highestPeak(int[][] isWater) {
            int m = isWater.length, n = isWater[0].length;
            boolean[][] v = new boolean[m][n];
            LinkedList<int[]> q = new LinkedList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (isWater[i][j] == 1) {
                        v[i][j] = true;
                        q.addLast(new int[]{i, j});
                    }
                }
            }

            int todo = m * n, h = 0;
            int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}}, res = new int[m][n];
            while (todo > 0) {
                int sz = q.size();
                while (sz-- > 0) {
                    int[] f = q.pollFirst();
                    res[f[0]][f[1]] = h;
                    todo--;
                    for (int[] d : dirs) {
                        int nr = f[0] + d[0], nc = f[1] + d[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && !v[nr][nc]) {
                            v[nr][nc] = true;
                            q.addLast(new int[]{nr, nc});
                        }
                    }
                }
                h++;
            }
            return res;
        }
    }
}
