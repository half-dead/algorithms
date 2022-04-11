package p2500_;

/**
 * https://leetcode.com/problems/solving-questions-with-brainpower/
 *
 * @author half-dead
 */
public class Puzzle2140 {

    class Solution {
        public long mostPoints(int[][] questions) {
            int n = questions.length;
            long[] dp = new long[n];
            long res = 0L;
            for (int i = 0; i < n; i++) {
                if (i > 0) dp[i] = Math.max(dp[i], dp[i - 1]);

                int next = i + questions[i][1] + 1;
                long p = dp[i] + questions[i][0];
                if (next < n) dp[next] = Math.max(dp[next], p);

                res = Math.max(res, p);
            }

            return res;
        }
    }
}
