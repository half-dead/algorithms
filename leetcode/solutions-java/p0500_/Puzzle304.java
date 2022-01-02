package p0500_;

/**
 * https://leetcode.com/problems/range-sum-query-2d-immutable/
 *
 * @author half-dead
 */
public class Puzzle304 {
    public static void main(String[] args) {
        NumMatrix nm = new Puzzle304().new NumMatrix(new int[][]{
                {3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}
        });
    }

    class NumMatrix {
        int[][] dp;

        public NumMatrix(int[][] matrix) {
            int rows = matrix.length, cols = 0;
            if (rows > 0) cols = matrix[0].length;
            dp = new int[rows + 1][cols + 1];
            for (int r = 0; r < rows; r++)
                for (int c = 0; c < cols; c++)
                    dp[r + 1][c + 1] = dp[r][c + 1] + dp[r + 1][c] + matrix[r][c] - dp[r][c];
        }

        public int sumRegion(int r1, int c1, int r2, int c2) {
            return dp[r2 + 1][c2 + 1] + dp[r1][c1] - dp[r1][c2 + 1] - dp[r2 + 1][c1];
        }
    }
}
