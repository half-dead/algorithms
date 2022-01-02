package p0500_;

// You are given an n x n 2D matrix representing an image.
// Rotate the image by 90 degrees (clockwise).
// Follow up:
//   Could you do this in-place?

/**
 * https://leetcode.com/problems/rotate-image/
 */
public class Puzzle048_RotateImage {

    public static void main(String[] args) {
        Puzzle048_RotateImage p = new Puzzle048_RotateImage();
        CommonSolution solution = p.new CommonSolution();
        int[][] matrix = new int[][]{
                {1, 2, 3, 4, 5, 6},
                {7, 8, 9, 10, 11, 12},
                {13, 14, 15, 16, 17, 18},
                {19, 20, 21, 22, 23, 24},
                {25, 26, 27, 28, 29, 30},
                {31, 32, 33, 34, 35, 36}
        };
        printMatrix(matrix);
        System.out.println();
        solution.rotate(matrix);
        printMatrix(matrix);
    }

    // based on https://leetcode.com/discuss/20589/a-common-method-to-rotate-the-image
    // clockwise rotation
    // first reverse the matrix upside down
    // then use [0][0]...[n-1][n-1] as the axis, and swap the symmetry
    public class CommonSolution {
        public void rotate(int[][] matrix) {
            int ii = matrix.length - 1;
            for (int i = 0; i < matrix.length / 2; i++) {
                for (int j = 0; j < matrix.length; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[ii - i][j];
                    matrix[ii - i][j] = tmp;
                }
            }
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < i; j++) {
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[j][i];
                    matrix[j][i] = tmp;
                }
            }
        }
    }

    // cut the matrix into 4 sections, just leave the center alone.
    // when the matrix's length is odd, it has a center, which dont have to change during the rotation.
    // when the matrix's length is even, we can cut the matrix into 4 sections that have exactly same number of elements.
    //
    // for example, a 5*5 matrix below, matrix[2][2] = 'm' dont have to change
    //   a  b |c  d  e
    //        |
    //   f  g |h  i  j
    //        |-------
    //   k  l |m |n  o
    //  ---------|
    //   p  q  r |s  t
    //           |
    //   u  v  w |x  y
    public class Solution {
        public void rotate(int[][] matrix) {
            int halfi = (matrix.length + 1) >> 1;
            int halfj = matrix.length >> 1;
            for (int i = 0; i < halfi; i++) {
                for (int j = 0; j < halfj; j++) {
                    int ii = matrix.length - i - 1;
                    int jj = matrix.length - j - 1;
                    int tmp = matrix[i][j];
                    matrix[i][j] = matrix[jj][i];
                    matrix[jj][i] = matrix[ii][jj];
                    matrix[ii][jj] = matrix[j][ii];
                    matrix[j][ii] = tmp;
                }
            }
        }
    }

    public class ByLevelSolution {
        public void rotate(int[][] matrix) {
            int len = matrix.length;
            int half = len >> 1;
            int i = 0;
            while (i < half) {
                int j = i;
                int ii = len - i - 1;
                while (j < ii) {
                    int jj = ii - (j - i);
                    int val = matrix[i][j];
                    matrix[i][j] = matrix[jj][i];
                    matrix[jj][i] = matrix[ii][jj];
                    matrix[ii][jj] = matrix[j][ii];
                    matrix[j][ii] = val;
                    j++;
                }
                i++;
            }
        }
    }

    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int i : row) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
