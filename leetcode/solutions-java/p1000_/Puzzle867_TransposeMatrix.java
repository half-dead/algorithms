package p1000_;

/**
 * https://leetcode.com/problems/transpose-matrix/
 *
 * @author half-dead
 */
public class Puzzle867_TransposeMatrix {
    class Solution {
        public int[][] transpose(int[][] m) {
            int rows = m.length;
            int cols = m[0].length;
            int[][] result = new int[cols][rows];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    result[j][i] = m[i][j];
                }
            }
            return result;
        }
    }
}
