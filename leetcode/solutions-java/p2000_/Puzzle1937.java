package p2000_;

/**
 * https://leetcode.com/problems/maximum-number-of-points-with-cost/
 *
 * @author half-dead
 */
public class Puzzle1937 {

    class Solution {
        public long maxPoints(int[][] points) {
            int rows = points.length, cols = points[0].length;
            long[] dp = new long[cols];
            for (int i = 0; i < cols; i++) dp[i] = points[0][i];

            for (int i = 1; i < rows; i++) {
                long[] next = new long[cols];
                int[] row = points[i];

                long prev = 0L;
                for (int j = 0; j < cols; j++) {
                    prev = Math.max(--prev, dp[j]);
                    next[j] = Math.max(next[j], prev + row[j]);
                }

                prev = 0L;
                for (int j = cols - 1; j >= 0; j--) {
                    prev = Math.max(--prev, dp[j]);
                    next[j] = Math.max(next[j], prev + row[j]);
                }

                dp = next;
            }

            long res = 0L;
            for (long p : dp) res = Math.max(res, p);
            return res;
        }
    }
}
