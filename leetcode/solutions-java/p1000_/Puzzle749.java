package p1000_;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode.com/problems/contain-virus/
 *
 * @author half-dead
 */
public class Puzzle749 {

    public static void main(String[] args) {
        Solution s = new Puzzle749().new Solution();
        System.out.println(s.containVirus(new int[][]{
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0}
        }));

    }

    class Solution {
        int m, n;
        int[][] g;
        boolean[][] checked;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int containVirus(int[][] grid) {
            m = grid.length;
            n = grid[0].length;
            g = grid;

            int regions, color = 1, res = 0;
            do {
                regions = 0;
                checked = new boolean[m][n];
                int threat = 0, r = 0, c = 0, wallsNeeded = 0;

                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {
                        if (g[i][j] > 0 && !checked[i][j]) {
                            regions++;
                            Set<Integer> frontier = new HashSet<>();
                            int[] perimeter = new int[1];
                            dfs(i, j, frontier, perimeter);
                            if (frontier.size() > threat) {
                                threat = frontier.size();
                                r = i;
                                c = j;
                                wallsNeeded = perimeter[0];
                            }
                        }
                    }
                }

                if (threat > 0) {
                    res += wallsNeeded;
                    buildWall(r, c);
                    spread(++color);
                }
            } while (regions > 1);

            return res;
        }

        void dfs(int r, int c, Set<Integer> frontier, int[] perimeter) {
            checked[r][c] = true;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (g[nr][nc] > 0 && !checked[nr][nc]) {
                    dfs(nr, nc, frontier, perimeter);
                } else if (g[nr][nc] == 0) {
                    frontier.add(nr * n + nc);
                    perimeter[0]++;
                }
            }
        }

        void buildWall(int r, int c) {
            g[r][c] = -1;

            for (int[] d : dirs) {
                int nr = r + d[0], nc = c + d[1];
                if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                if (g[nr][nc] > 0) buildWall(nr, nc);
            }
        }

        void spread(int color) {
            Set<Integer> frontier = new HashSet<>();
            for (int r = 0; r < m; r++) {
                for (int c = 0; c < n; c++) {
                    if (g[r][c] <= 0) continue;

                    g[r][c] = color;
                    for (int[] d : dirs) {
                        int nr = r + d[0], nc = c + d[1];
                        if (nr < 0 || nr >= m || nc < 0 || nc >= n) continue;
                        if (g[nr][nc] == 0) frontier.add(nr * n + nc);
                    }
                }
            }
            for (int coordinate : frontier) {
                g[coordinate / n][coordinate % n] = color;
            }
        }
    }

}
