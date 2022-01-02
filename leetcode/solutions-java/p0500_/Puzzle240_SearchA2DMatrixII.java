package p0500_;

/**
 * https://leetcode.com/problems/search-a-2d-matrix-ii/
 *
 * @author half-dead
 */
public class Puzzle240_SearchA2DMatrixII {
    public static void main(String[] args) {
        Puzzle240_SearchA2DMatrixII p = new Puzzle240_SearchA2DMatrixII();
        Solution s = p.new Solution();
        int[][] matrix = {
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(s.searchMatrix(matrix, 0));
        System.out.println(s.searchMatrix(matrix, 1));
        System.out.println(s.searchMatrix(matrix, 5));
        System.out.println(s.searchMatrix(matrix, 10));
        System.out.println(s.searchMatrix(matrix, 30));
        System.out.println(s.searchMatrix(matrix, 29));
    }

    public class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length < 1 || matrix[0].length < 1) {
                return false;
            }

            int row = 0, col = matrix[0].length - 1;
            while (col >= 0 && row <= matrix.length - 1) {
                int n = matrix[row][col];
                if (n > target) {
                    col--;
                } else if (n < target) {
                    row++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }

    class DivideAndConquerSolution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int rows = matrix.length;
            if (rows == 0) return false;
            int cols = matrix[0].length;
            if (cols == 0) return false;
            return dac(matrix, target, 0, rows - 1, 0, cols - 1);
        }

        private boolean dac(int[][] matrix, int target, int r1, int r2, int c1, int c2) {
            if (r1 > r2 || c1 > c2) return false;
            if (r1 == r2) return searchRow(matrix, target, r1, c1, c2);
            if (c1 == c2) return searchColumn(matrix, target, r1, r2, c1);

            int top = r1, bottom = r2, left = c1, right = c2;
            while (top <= bottom && left <= right) {
                int half = Math.min(bottom - top + 1, right - left + 1) / 2;
                int n = matrix[top + half][left + half];
                if (n > target) {
                    bottom = top + half - 1;
                    right = left + half - 1;
                } else if (n < target) {
                    if (half == 0) break;
                    top = top + half;
                    left = left + half;
                } else {
                    return true;
                }
            }
            return dac(matrix, target, r1, bottom, left + 1, c2) ||
                    dac(matrix, target, top + 1, r2, c1, right);
        }

        boolean searchRow(int[][] matrix, int target, int r, int c1, int c2) {
            while (c1 <= c2) {
                int mid = c1 + (c2 - c1) / 2;
                int n = matrix[r][mid];
                if (n > target) c2 = mid - 1;
                else if (n < target) c1 = mid + 1;
                else return true;
            }
            return false;
        }

        boolean searchColumn(int[][] matrix, int target, int r1, int r2, int c) {
            while (r1 <= r2) {
                int mid = r1 + (r2 - r1) / 2;
                int n = matrix[mid][c];
                if (n > target) r2 = mid - 1;
                else if (n < target) r1 = mid + 1;
                else return true;
            }
            return false;
        }
    }
}
