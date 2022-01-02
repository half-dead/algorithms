package p1500_;

import java.util.LinkedList;

/**
 * https://leetcode.com/problems/matrix-cells-in-distance-order/
 *
 * @author half-dead
 */
public class Puzzle1030_MatrixCellsInDistanceOrder {
    public static void main(String[] args) {
        Solution s = new Puzzle1030_MatrixCellsInDistanceOrder().new Solution();
        int[][] ints = s.allCellsDistOrder(80, 57, 19, 38);
    }

    class Solution {
        public int[][] allCellsDistOrder(int R, int C, int r0, int c0) {
            int[][] result = new int[R * C][2];
            boolean[][] visited = new boolean[R][C];
            LinkedList<int[]> q = new LinkedList<>();
            q.push(new int[]{r0, c0});
            int i = 0;
            while (q.size() > 0) {
                LinkedList<int[]> next = new LinkedList<>();
                while (q.size() > 0) {
                    int[] p = q.pop();
                    int r = p[0], c = p[1];
                    if (r < 0 || c < 0 || r >= R || c >= C || visited[r][c]) continue;
                    result[i++] = new int[]{r, c};
                    visited[r][c] = true;

                    next.push(new int[]{r - 1, c});
                    next.push(new int[]{r + 1, c});
                    next.push(new int[]{r, c - 1});
                    next.push(new int[]{r, c + 1});
                }
                q = next;
            }
            return result;
        }
    }
}
