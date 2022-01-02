package p2000_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/
 *
 * @author half-dead
 */
public class Puzzle1926 {

    class Solution {
        public int nearestExit(char[][] maze, int[] entrance) {
            int m = maze.length, n = maze[0].length, steps = -1;
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            boolean[][] visited = new boolean[m][n];
            visited[entrance[0]][entrance[1]] = true;

            LinkedList<int[]> q = new LinkedList<>();
            q.offer(entrance);
            while (q.size() > 0) {
                steps++;
                int size = q.size();
                while (size-- > 0) {
                    int[] coor = q.pollFirst();
                    int r = coor[0], c = coor[1];
                    if ((r == 0 || c == 0 || r == m - 1 || c == n - 1) && !(r == entrance[0] && c == entrance[1])) {
                        return steps;
                    }
                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == '.' && !visited[nr][nc]) {
                            q.offerLast(new int[]{nr, nc});
                            visited[nr][nc] = true;
                        }
                    }
                }
            }
            return -1;
        }
    }
}
