/*
https://leetcode.com/problems/search-a-2d-matrix/description/

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.

Example 1:
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 3
    Output: true
Example 2:
    Input:
    matrix = [
      [1,   3,  5,  7],
      [10, 11, 16, 20],
      [23, 30, 34, 50]
    ]
    target = 13
    Output: false
 */

package p0500_;

/**
 * @author half-dead
 */
public class Puzzle074_SearchA2DMatrix {

    public static void main(String[] args) {
        Solution s = new Puzzle074_SearchA2DMatrix().new Solution();
        System.out.println(s.searchMatrix(new int[][]{{1}, {3}}, 2));
    }

    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            if (m == 0) {
                return false;
            }
            int n = matrix[0].length;
            int left = 0, right = m * n - 1;
            while (left <= right) {
                int mid = (left + right) / 2;
                int r = mid / n;
                int c = mid % n;
                if (matrix[r][c] == target) {
                    return true;
                }
                if (matrix[r][c] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
            return false;
        }
    }
}
