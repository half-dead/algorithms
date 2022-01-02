/*
https://leetcode.com/problems/set-matrix-zeroes/description/

Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

Example 1:
    Input:
    [
      [1,1,1],
      [1,0,1],
      [1,1,1]
    ]
    Output:
    [
      [1,0,1],
      [0,0,0],
      [1,0,1]
    ]
Example 2:
    Input:
    [
      [0,1,2,0],
      [3,4,5,2],
      [1,3,1,5]
    ]
    Output:
    [
      [0,0,0,0],
      [0,4,5,0],
      [0,3,1,0]
    ]
Follow up:
    A straight forward solution using O(mn) space is probably a bad idea.
    A simple improvement uses O(m + n) space, but still not the best solution.
    Could you devise a constant space solution?
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle073_SetMatrixZeroes {

    // The idea is to use first row and first column as extra space.
    class Solution {
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;
            boolean firstRowAllZero = false, firstColumnAllZero = false;
            for (int i = 0; i < rows; i++) {
                if (matrix[i][0] == 0) {
                    firstColumnAllZero = true;
                    break;
                }
            }
            for (int j = 0; j < cols; j++) {
                if (matrix[0][j] == 0) {
                    firstRowAllZero = true;
                    break;
                }
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        matrix[0][j] = 0;
                        matrix[i][0] = 0;
                    }
                }
            }
            for (int i = 1; i < rows; i++) {
                for (int j = 1; j < cols; j++) {
                    if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                        matrix[i][j] = 0;
                    }
                }
            }
            if (firstRowAllZero) {
                for (int i = 0; i < cols; i++) {
                    matrix[0][i] = 0;
                }
            }
            if (firstColumnAllZero) {
                for (int i = 0; i < rows; i++) {
                    matrix[i][0] = 0;
                }
            }
        }
    }

    // O(m+n)
    class NotTheBestSolution {
        public void setZeroes(int[][] matrix) {
            int rows = matrix.length;
            int cols = matrix[0].length;

            int[] rowFlags = new int[rows];
            int[] colFlags = new int[cols];

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (matrix[i][j] == 0) {
                        rowFlags[i] = 1;
                        colFlags[j] = 1;
                    }
                }
            }

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (rowFlags[i] == 1 || colFlags[j] == 1) {
                        matrix[i][j] = 0;
                    }
                }
            }

        }
    }
}
