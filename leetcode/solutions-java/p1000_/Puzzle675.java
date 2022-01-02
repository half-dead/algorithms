package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 *
 * @author half-dead
 */
public class Puzzle675 {

    class Solution {
        int m, n;
        int[][] matrix, dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int cutOffTree(List<List<Integer>> forest) {
            m = forest.size();
            n = forest.get(0).size();
            matrix = new int[m][n];

            PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> x[0]));
            for (int i = 0, j = 0; i < m; i++, j = 0) {
                List<Integer> row = forest.get(i);
                for (int cell : row) {
                    if (cell > 1) pq.offer(new int[]{cell, i, j});
                    matrix[i][j++] = cell;
                }
            }

            int[] start = new int[]{0, 0, 0};
            int res = 0;
            while (!pq.isEmpty()) {
                int distance = distance(start, pq.peek());
                if (distance < 0) return -1;

                res += distance;
                start = pq.poll();
            }
            return res;
        }

        private int distance(int[] start, int[] end) {
            int a = end[1], b = end[2], dis = 0;
            if (start[1] == a && start[2] == b) return 0;

            boolean[][] v = new boolean[m][n];
            Deque<int[]> dq = new LinkedList<>();
            dq.addLast(new int[]{start[1], start[2]});

            while (!dq.isEmpty()) {

                int size = dq.size();
                while (size-- > 0) {
                    int[] prev = dq.pollFirst();
                    int r = prev[0], c = prev[1];
                    if (r == a && c == b) return dis;

                    for (int[] dir : dirs) {
                        int nr = r + dir[0], nc = c + dir[1];
                        if (nr < 0 || nr == m || nc < 0 || nc == n || matrix[nr][nc] == 0 || v[nr][nc]) continue;

                        dq.addLast(new int[]{nr, nc});
                        v[nr][nc] = true;
                    }
                }
                dis++;
            }
            return -1;
        }
    }
}
