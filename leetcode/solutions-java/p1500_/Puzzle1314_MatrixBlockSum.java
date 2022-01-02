package p1500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/matrix-block-sum/
 *
 * @author half-dead
 */
public class Puzzle1314_MatrixBlockSum {

    public static void main(String[] args) {
        Solution s = new Puzzle1314_MatrixBlockSum().new Solution();
//        s.matrixBlockSum(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, 1);
        int[][] r = s.matrixBlockSum(new int[][]{{67, 64, 78}, {99, 98, 38}, {82, 46, 46}, {6, 52, 55}, {55, 99, 45}}, 3);
        pt(r);
    }

    static void pt(int[][] m) {
        for (int[] r : m) System.out.println(Arrays.toString(r));
    }

    class Solution {
        public int[][] matrixBlockSum(int[][] matrix, int k) {
            int rows = matrix.length, cols = matrix[0].length;
            int[][] temp = new int[rows][cols], result = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    int sum = 0;
                    if (c == 0) {
                        for (int i = c - k; i <= c + k; i++)
                            if (i >= 0 && i < cols) sum += matrix[r][i];
                    } else {
                        sum = temp[r][c - 1];
                        if (c - 1 - k >= 0) sum -= matrix[r][c - 1 - k];
                        if (c + k < cols) sum += matrix[r][c + k];
                    }
                    temp[r][c] = sum;
                }
            }
            for (int c = 0; c < cols; c++) {
                for (int r = 0; r < rows; r++) {
                    int sum = 0;
                    if (r == 0) {
                        for (int i = r - k; i <= r + k; i++)
                            if (i >= 0 && i < rows) sum += temp[i][c];
                    } else {
                        sum = result[r - 1][c];
                        if (r - 1 - k >= 0) sum -= temp[r - 1 - k][c];
                        if (r + k < rows) sum += temp[r + k][c];
                    }
                    result[r][c] = sum;
                }
            }
            return result;
        }
    }
}
