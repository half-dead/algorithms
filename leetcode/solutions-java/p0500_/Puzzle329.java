package p0500_;

/**
 * https://leetcode.com/problems/longest-increasing-path-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle329 {

    class Solution {
        int m, n;
        int[][] mat, memo;

        public int longestIncreasingPath(int[][] matrix) {
            m = matrix.length;
            n = matrix[0].length;
            mat = matrix;
            memo = new int[m][n];
            int res = 1;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    res = Math.max(res, dfs(i, j));
                }
            }
            return res;
        }

        int dfs(int i, int j) {
            if (memo[i][j] != 0) return memo[i][j];
            int max = 0;
            if (i > 0 && mat[i][j] < mat[i - 1][j]) max = Math.max(max, dfs(i - 1, j));
            if (j > 0 && mat[i][j] < mat[i][j - 1]) max = Math.max(max, dfs(i, j - 1));
            if (i + 1 < m && mat[i][j] < mat[i + 1][j]) max = Math.max(max, dfs(i + 1, j));
            if (j + 1 < n && mat[i][j] < mat[i][j + 1]) max = Math.max(max, dfs(i, j + 1));
            return memo[i][j] = 1 + max;
        }
    }
}
