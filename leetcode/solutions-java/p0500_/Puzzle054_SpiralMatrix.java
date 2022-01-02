/*
https://leetcode.com/problems/spiral-matrix/description/

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

Example 1:
    Input:
        [
         [ 1, 2, 3 ],
         [ 4, 5, 6 ],
         [ 7, 8, 9 ]
        ]
    Output: [1,2,3,6,9,8,7,4,5]

Example 2:
    Input:
        [
          [1, 2, 3, 4],
          [5, 6, 7, 8],
          [9,10,11,12]
        ]
    Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 */

package p0500_;

import java.util.ArrayList;
import java.util.List;

/**
 * @author half-dead
 */
public class Puzzle054_SpiralMatrix {

    public static void main(String[] args) {
        Solution solution = new Puzzle054_SpiralMatrix().new Solution();
        System.out.println(solution.spiralOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
        System.out.println(solution.spiralOrder(new int[][]{{7, 8, 9}}));
    }

    class Solution {
        public List<Integer> spiralOrder(int[][] matrix) {
            if (matrix.length == 0) {
                return new ArrayList<>();
            }
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> result = new ArrayList<>(m * n);
            recursive(matrix, 0, m - 1, 0, n - 1, result);
            return result;
        }

        public void recursive(int[][] matrix, int mStart, int mEnd, int nStart, int nEnd, List<Integer> result) {
            for (int i = nStart; i <= nEnd; i++) {
                result.add(matrix[mStart][i]);
            }
            for (int i = mStart + 1; i <= mEnd - 1; i++) {
                result.add(matrix[i][nEnd]);
            }
            if (mEnd > mStart) {
                for (int i = nEnd; i >= nStart; i--) {
                    result.add(matrix[mEnd][i]);
                }
            }
            if (nEnd > nStart) {
                for (int i = mEnd - 1; i >= mStart + 1; i--) {
                    result.add(matrix[i][nStart]);
                }
            }
            mStart++;
            mEnd--;
            nStart++;
            nEnd--;
            if (mStart <= mEnd && nStart <= nEnd) {
                recursive(matrix, mStart, mEnd, nStart, nEnd, result);
            }

        }
    }
}
