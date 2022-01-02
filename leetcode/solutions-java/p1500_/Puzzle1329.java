package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/sort-the-matrix-diagonally/
 *
 * @author half-dead
 */
public class Puzzle1329 {

    class Solution {
        public int[][] diagonalSort(int[][] mat) {
            int rows = mat.length, cols = mat[0].length, digs = rows + cols - 1;
            int[][] data = new int[digs][];
            for (int d = 0, r0 = rows - 1, c0 = 0; d < digs; d++) {
                int r = r0, c = c0, len = Math.min(rows - r, cols - c), i = 0;
                data[d] = new int[len];
                while (i < len) data[d][i++] = mat[r++][c++];
                Arrays.sort(data[d]);

                if (r0 > 0) r0--;
                else c0++;
            }

            for (int d = 0, r0 = rows - 1, c0 = 0; d < digs; d++) {
                int r = r0, c = c0, len = Math.min(rows - r, cols - c), i = 0;
                while (i < len) mat[r++][c++] = data[d][i++];

                if (r0 > 0) r0--;
                else c0++;
            }
            return mat;
        }
    }
}
