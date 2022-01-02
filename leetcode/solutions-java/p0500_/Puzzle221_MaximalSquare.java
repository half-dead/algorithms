package p0500_;

/**
 * https://leetcode.com/problems/maximal-square/
 *
 * @author half-dead
 */
public class Puzzle221_MaximalSquare {
    public static void main(String[] args) {
        Puzzle221_MaximalSquare p = new Puzzle221_MaximalSquare();
        Solution s = p.new Solution();
        System.out.println(s.maximalSquare(new char[][]{
                "10100".toCharArray(),
                "10111".toCharArray(),
                "11111".toCharArray(),
                "10111".toCharArray(),
        }));
    }

    class Solution {
        public int maximalSquare(char[][] matrix) {
            int rows = matrix.length, cols = rows > 0 ? matrix[0].length : 0;
            int[][] dp = new int[rows][cols];
            for (int i = 0; i < rows; i++)
                for (int j = 0; j < cols; j++)
                    if (matrix[i][j] != '0') {
                        if (i == 0 || j == 0) dp[i][j] = 1;
                        else dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
                    }
            int r = 0;
            for (int[] row : dp) for (int n : row) r = Math.max(r, n);
            return r * r;
        }
    }
}
