package p2000_;

/**
 * https://leetcode.com/problems/maximum-non-negative-product-in-a-matrix/
 *
 * @author half-dead
 */
public class Puzzle1594 {

    public static void main(String[] args) {
        Solution s = new Puzzle1594().new Solution();
        System.out.println(s.maxProductPath(new int[][]{
                {-1, -2, -3}, {-2, -3, -3}, {-3, -3, -2}
        }));
    }

    class Solution {
        public int maxProductPath(int[][] grid) {
            int m = grid.length, n = grid[0].length;

            long[][][] dp = new long[m][n][2];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    long v = grid[i][j];
                    if (i == 0 && j == 0) {
                        dp[i][j] = new long[]{v, v};
                    } else if (i == 0) {
                        dp[i][j] = new long[]{v * dp[i][j - 1][0], v * dp[i][j - 1][1]};
                    } else if (j == 0) {
                        dp[i][j] = new long[]{v * dp[i - 1][j][0], v * dp[i - 1][j][1]};
                    } else {
                        long t1 = dp[i - 1][j][0] * v, t2 = dp[i - 1][j][1] * v,
                                l1 = dp[i][j - 1][0] * v, l2 = dp[i][j - 1][1] * v;

                        dp[i][j] = new long[]{
                                Math.max(t1, Math.max(t2, Math.max(l1, l2))),
                                Math.min(t1, Math.min(t2, Math.min(l1, l2)))
                        };
                    }
                }
            }
            if (dp[m - 1][n - 1][0] < 0) return -1;
            return (int) (dp[m - 1][n - 1][0] % 1000000007);
        }
    }
}
