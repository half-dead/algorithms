package p1000_;

/**
 * https://leetcode.com/problems/score-after-flipping-matrix/
 *
 * @author half-dead
 */
public class Puzzle861_ScoreAfterFlippingMatrix {
    public static void main(String[] args) {
    }

    class Solution {
        public int matrixScore(int[][] a) {
            int rows = a.length, cols = a[0].length;
            for (int i = 0; i < rows; i++) {
                if (a[i][0] == 0) {
                    toggleRow(a, i);
                }
            }
            for (int i = 1; i < cols; i++) {
                int count = 0;
                for (int[] row : a) {
                    if (row[i] == 1) {
                        count++;
                    }
                }
                if (count < rows - count) {
                    toggleColumn(a, i);
                }
            }
            int result = 0;
            for (int[] row : a) {
                for (int j = 0; j < cols; j++) {
                    if (row[j] == 1) {
                        result += 1 << (cols - j - 1);
                    }
                }
            }
            return result;
        }

        private void toggleRow(int[][] a, int row) {
            for (int i = 0; i < a[row].length; i++) {
                a[row][i] ^= 1;
            }
        }

        private void toggleColumn(int[][] a, int column) {
            for (int i = 0; i < a.length; i++) {
                a[i][column] ^= 1;
            }
        }
    }
}
