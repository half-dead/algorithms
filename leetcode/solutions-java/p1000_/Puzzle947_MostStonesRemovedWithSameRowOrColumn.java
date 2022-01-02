package p1000_;

import java.util.*;

/**
 * https://leetcode.com/problems/most-stones-removed-with-same-row-or-column/
 *
 * @author half-dead
 */
public class Puzzle947_MostStonesRemovedWithSameRowOrColumn {
    public static void main(String[] args) {
        Puzzle947_MostStonesRemovedWithSameRowOrColumn p = new Puzzle947_MostStonesRemovedWithSameRowOrColumn();
        Solution s = p.new Solution();
        s.removeStones(new int[][]{{0, 0}, {0, 1}, {1, 0}});
    }

    class Solution {
        Map<Integer, Integer> map = new HashMap<>();
        int islands = 0;

        public int removeStones(int[][] stones) {
            for (int[] stone : stones) {
                union(stone[0], stone[1] + 10000);
            }
            return stones.length - islands;
        }

        void union(int x, int y) {
            x = find(x);
            y = find(y);
            if (x != y) {
                map.put(x, y);
                islands--;
            }
        }

        int find(int x) {
            if (map.putIfAbsent(x, x) == null) {
                islands++;
            }
            int y = map.get(x);
            if (x != y) {
                y = find(y);
                map.put(x, y);
            }
            return y;
        }
    }

    class MySolution {
        int rows;
        int cols;
        boolean[] rowMarker;
        boolean[] colMarker;
        boolean[][] matrix;

        public int removeStones(int[][] stones) {
            for (int[] point : stones) {
                if (rows < point[0]) rows = point[0];
                if (cols < point[1]) cols = point[1];
            }
            rows++;
            cols++;

            matrix = new boolean[rows][cols];
            for (int[] point : stones) {
                matrix[point[0]][point[1]] = true;
            }

            int count = 0;
            rowMarker = new boolean[rows];
            colMarker = new boolean[cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j]) {
                        dfs(i, j);
                        count++;
                    }
                }
            }
            return stones.length - count;
        }

        private void dfs(int r, int c) {
            if (!rowMarker[r]) {
                rowMarker[r] = true;
                for (int i = 0; i < cols; i++) {
                    if (matrix[r][i] && i != c) {
                        dfs(r, i);
                        matrix[r][i] = false;
                    }
                }
            }
            if (!colMarker[c]) {
                colMarker[c] = true;
                for (int i = 0; i < rows; i++) {
                    if (matrix[i][c] && i != r) {
                        dfs(i, c);
                        matrix[i][c] = false;
                    }
                }
            }
        }
    }

}