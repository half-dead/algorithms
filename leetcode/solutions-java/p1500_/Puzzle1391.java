package p1500_;

import java.util.LinkedList;
import java.util.Queue;

/**
 * https://leetcode.com/problems/check-if-there-is-a-valid-path-in-a-grid/
 *
 * @author half-dead
 */
public class Puzzle1391 {
    class Solution {
        // every street have 2 out of 4 exits, let's call them: up=1, right=2, down=3, left=4

        // directions for every exit
        final int[][] D = new int[][]{{}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};

        // streets that an exit can connect to, for example, exit 1(up) can connect to street: 2,3,4
        final int[][] C = new int[][]{{}, {2, 3, 4}, {1, 3, 5}, {2, 5, 6}, {1, 4, 6}};

        // exits that a street have, for example, street 1 have two exits: 2 and 4
        final int[][] E = new int[][]{{}, {2, 4}, {1, 3}, {3, 4}, {2, 3}, {1, 4}, {1, 2}};

        public boolean hasValidPath(int[][] grid) {
            int rows = grid.length, cols = grid[0].length;

            Queue<int[]> q = new LinkedList<>();
            q.offer(new int[]{0, 0});

            boolean[][] visited = new boolean[rows][cols];
            visited[0][0] = true;

            while (!q.isEmpty()) {
                int size = q.size();
                while (size-- > 0) {
                    int[] rc = q.poll();
                    int r = rc[0], c = rc[1];
                    if (r == rows - 1 && c == cols - 1) return true;

                    int[] exits = E[grid[r][c]];
                    for (int exit : exits) {
                        int nr = r + D[exit][0], nc = c + D[exit][1];
                        if (nr >= 0 && nc >= 0 && nr < rows && nc < cols && !visited[nr][nc]) {
                            int street = grid[nr][nc];
                            for (int type : C[exit]) {
                                if (type == street) {
                                    q.offer(new int[]{nr, nc});
                                    visited[nr][nc] = true;
                                    break;
                                }
                            }
                        }
                    }
                }
            }
            return false;
        }
    }
}
