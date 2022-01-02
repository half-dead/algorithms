package p1000_;

/**
 * https://leetcode.com/problems/regions-cut-by-slashes/
 *
 * @author half-dead
 */
public class Puzzle959_RegionsCutBySlashes {

    class Solution {
        private int[][] matrix;
        private int mRow, mCol;
        private int startRow, startCol;

        public int regionsBySlashes(String[] grid) {
            int rows = grid.length, cols = grid[0].length();
            mRow = rows * 3;
            mCol = cols * 3;
            matrix = new int[mRow][mCol];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++) fill(i, j, grid[i].charAt(j));

            int count = 0;
            while (hasMoreRegion()) {
                count++;
                visit(startRow, startCol);
            }
            return count;
        }

        private void visit(int r, int c) {
            if (matrix[r][c] == 0) matrix[r][c] = 2;
            else return;

            if (r > 0) visit(r - 1, c);
            if (c > 0) visit(r, c - 1);
            if (r < mRow - 1) visit(r + 1, c);
            if (c < mCol - 1) visit(r, c + 1);
        }

        private boolean hasMoreRegion() {
            for (int i = 0; i < mRow; i++)
                for (int j = 0; j < mCol; j++)
                    if (matrix[i][j] == 0) {
                        startRow = i;
                        startCol = j;
                        return true;
                    }
            return false;
        }

        private void fill(int row, int col, char c) {
            int r3 = row * 3, c3 = col * 3;
            for (int i = r3; i < r3 + 2; i++)
                for (int j = c3; j < c3 + 2; j++) matrix[i][j] = 0;
            if (c == '/') matrix[r3][c3 + 2] = matrix[r3 + 1][c3 + 1] = matrix[r3 + 2][c3] = 1;
            else if (c == '\\') matrix[r3][c3] = matrix[r3 + 1][c3 + 1] = matrix[r3 + 2][c3 + 2] = 1;
        }
    }
}
