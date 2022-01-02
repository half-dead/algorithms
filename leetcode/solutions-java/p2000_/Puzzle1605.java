package p2000_;

/**
 * https://leetcode.com/problems/find-valid-matrix-given-row-and-column-sums/
 *
 * @author half-dead
 */
public class Puzzle1605 {
    class Solution {
        public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
            int rows = rowSum.length, cols = colSum.length;
            int[][] ans = new int[rows][cols];
            int r = 0, c = 0;
            while (r < rows && c < cols) {
                int v = Math.min(rowSum[r], colSum[c]);
                ans[r][c] = v;
                rowSum[r] -= v;
                colSum[c] -= v;
                if (rowSum[r] == 0) r++;
                if (colSum[c] == 0) c++;
            }
            while (r < rows) ans[r][0] = rowSum[r++];
            while (c < cols) ans[0][c] = colSum[c++];
            return ans;
        }
    }
}
