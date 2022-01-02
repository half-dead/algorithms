/*
https://leetcode.com/problems/spiral-matrix-ii/description/

Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

Example:
    Input: 3
    Output:
    [
     [ 1, 2, 3 ],
     [ 8, 9, 4 ],
     [ 7, 6, 5 ]
    ]
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle059_SpiralMatrixII {
    class Solution {
        public int[][] generateMatrix(int n) {
            int[][] result = new int[n][n];
            generateMatrix(0, 0, n - 1, 0, n - 1, result);
            return result;
        }

        public void generateMatrix(int index, int mStart, int mEnd, int nStart, int nEnd, int[][] matrix) {
            for (int i = nStart; i <= nEnd; i++) {
                matrix[mStart][i] = ++index;
            }
            for (int i = mStart + 1; i <= mEnd - 1; i++) {
                matrix[i][nEnd] = ++index;
            }
            if (mEnd > mStart) {
                for (int i = nEnd; i >= nStart; i--) {
                    matrix[mEnd][i] = ++index;
                }
            }
            if (nEnd > nStart) {
                for (int i = mEnd - 1; i >= mStart + 1; i--) {
                    matrix[i][nStart] = ++index;
                }
            }
            mStart++;
            mEnd--;
            nStart++;
            nEnd--;
            if (mStart <= mEnd && nStart <= nEnd) {
                generateMatrix(index, mStart, mEnd, nStart, nEnd, matrix);
            }

        }
    }


}
