package p1000_;

import java.util.Deque;
import java.util.LinkedList;

/**
 * https://leetcode.com/problems/shortest-path-to-get-all-keys/
 *
 * @author half-dead
 */
public class Puzzle864 {

    // BFS + bitmasking
    class Solution {
        final int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        public int shortestPathAllKeys(String[] grid) {
            int m = grid.length, n = grid[0].length(), locks = 0, steps = 0, startRow = 0, startCol = 0;

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char cell = grid[i].charAt(j);
                    if (cell == '@') {
                        startRow = i;
                        startCol = j;
                    } else if (cell >= 'a' && cell <= 'z') locks++;
                }
            }

            boolean[][][] dp = new boolean[m][n][1 << locks];
            dp[startRow][startCol][0] = true;

            Deque<int[]> dq = new LinkedList<>();
            dq.addLast(new int[]{startRow, startCol, 0});

            while (dq.size() > 0) {
                int size = dq.size();
                while (size-- > 0) {
                    int[] prev = dq.pollFirst();
                    int x = prev[0], y = prev[1], state = prev[2];
                    if (state + 1 == (1 << locks)) return steps;

                    for (int[] d : directions) {
                        int r = x + d[0], c = y + d[1], nextstate = state;
                        if (r < 0 || r >= m || c < 0 || c >= n) continue;

                        char cell = grid[r].charAt(c);
                        if (cell == '#') {
                            continue;
                        } else if (cell >= 'A' && cell <= 'Z') {
                            int mask = 1 << (cell - 'A');
                            if ((state & mask) == 0) continue;
                        } else if (cell >= 'a' && cell <= 'z') {
                            int mask = 1 << (cell - 'a');
                            nextstate = state | mask;
                        }
                        if (!dp[r][c][nextstate]) {
                            dp[r][c][nextstate] = true;
                            dq.addLast(new int[]{r, c, nextstate});
                        }
                    }
                }
                steps++;
            }
            return -1;
        }
    }
}
