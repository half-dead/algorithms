package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/flip-columns-for-maximum-number-of-equal-rows/
 *
 * @author half-dead
 */
public class Puzzle1072 {

    class Solution {
        public int maxEqualRowsAfterFlips(int[][] matrix) {
            int ans = 0, m = matrix.length, n = matrix[0].length;
            for (int i = 0; i < m; i++) {
                int cnt = 0;
                int[] flip = new int[n];
                for (int j = 0; j < n; j++)
                    flip[j] = 1 - matrix[i][j];

                for (int k = i; k < m; k++) {
                    if (Arrays.equals(matrix[k], matrix[i]) || Arrays.equals(matrix[k], flip))
                        cnt++;
                }
                ans = Math.max(ans, cnt);
            }
            return ans;
        }
    }
}
