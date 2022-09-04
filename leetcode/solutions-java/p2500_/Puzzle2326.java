package p2500_;

import struct.ListNode;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/spiral-matrix-iv/
 *
 * @author half-dead
 */
public class Puzzle2326 {

    public static void main(String[] args) {
        Solution solution = new Puzzle2326().new Solution();
        int[][] res = solution.spiralMatrix(3, 5, new ListNode(new int[]{3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0}));
        System.out.println(Arrays.deepToString(res));
    }

    class Solution {
        public int[][] spiralMatrix(int m, int n, ListNode head) {
            int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
            int[] limit = new int[]{n, m - 1};
            int r = 0, c = 0, cnt = 0, d = 0, p = 0;

            int[][] res = new int[m][n];
            for (int[] row : res) Arrays.fill(row, -1);

            while (head != null) {
                res[r][c] = head.val;
                if (++cnt == limit[p]) {
                    limit[p]--;
                    p = (p + 1) % 2;
                    d = (d + 1) % 4;
                    cnt = 0;
                }
                r += dirs[d][0];
                c += dirs[d][1];

                head = head.next;
            }

            return res;
        }
    }
}
