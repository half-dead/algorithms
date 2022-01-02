package p0500_;

/**
 * https://leetcode.com/problems/diagonal-traverse/
 *
 * @author half-dead
 */
public class Puzzle498 {
    class Solution {
        public int[] findDiagonalOrder(int[][] matrix) {
            int m = matrix.length;
            if (m == 0) return new int[0];

            int n = matrix[0].length, i = 0, r = 0, c = 0;
            int[] result = new int[m * n];
            boolean upright = true;
            while (i < result.length) {
                result[i++] = matrix[r][c];
                int nextr = upright ? r - 1 : r + 1;
                int nextc = upright ? c + 1 : c - 1;
                if (nextr >= 0 && nextr < m && nextc >= 0 && nextc < n) {
                    r = nextr;
                    c = nextc;
                } else {
                    if (upright) {
                        if (c + 1 < n) c++;
                        else r++;
                    } else {
                        if (r + 1 < m) r++;
                        else c++;
                    }
                    upright = !upright;
                }
            }
            return result;
        }
    }
}
