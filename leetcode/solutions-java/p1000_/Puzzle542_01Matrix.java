package p1000_;

/**
 * https://leetcode.com/problems/01-matrix/
 *
 * @author half-dead
 */
public class Puzzle542_01Matrix {

    public static void main(String[] args) {
        Puzzle542_01Matrix p = new Puzzle542_01Matrix();
        Solution s = p.new Solution();
        int[][] shit = s.updateMatrix(new int[][]{
                {1, 0, 1, 1, 0, 0, 1, 0, 0, 1},
                {0, 1, 1, 0, 1, 0, 1, 0, 1, 1},
                {0, 0, 1, 0, 1, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 1, 1, 1, 1, 1, 1},
                {0, 1, 0, 1, 1, 0, 0, 0, 0, 1},
                {0, 0, 1, 0, 1, 1, 1, 0, 1, 0},
                {0, 1, 0, 1, 0, 1, 0, 0, 1, 1},
                {1, 0, 0, 0, 1, 1, 1, 1, 0, 1},
                {1, 1, 1, 1, 1, 1, 1, 0, 1, 0},
                {1, 1, 1, 1, 0, 1, 0, 0, 1, 1}
        });

    }

    class Solution {
        public int[][] updateMatrix(int[][] matrix) {
            int rows = matrix.length, cols = matrix[0].length;
            int dis = 0;
            while (true) {
                int count = 0;
                for (int i = 0; i < rows; i++) {
                    for (int j = 0; j < cols; j++) {
                        if (matrix[i][j] > 0) {
                            count++;
                            int min = Integer.MAX_VALUE;
                            if (i > 0 && matrix[i - 1][j] <= 0) {
                                min = Math.min(min, -matrix[i - 1][j]);
                            }
                            if (j > 0 && matrix[i][j - 1] <= 0) {
                                min = Math.min(min, -matrix[i][j - 1]);
                            }
                            if (i + 1 < rows && matrix[i + 1][j] <= 0) {
                                min = Math.min(min, -matrix[i + 1][j]);
                            }
                            if (j + 1 < cols && matrix[i][j + 1] <= 0) {
                                min = Math.min(min, -matrix[i][j + 1]);
                            }

                            if (min == dis) {
                                matrix[i][j] = -(dis + 1);
                            }
                        }
                    }
                }
                if (count == 0) {
                    break;
                }
                dis++;
            }
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] < 0) {
                        matrix[i][j] = -matrix[i][j];
                    }
                }
            }
            return matrix;
        }
    }
}
