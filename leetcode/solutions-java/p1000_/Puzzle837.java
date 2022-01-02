package p1000_;

/**
 * https://leetcode.com/problems/new-21-game/
 *
 * @author half-dead
 */
public class Puzzle837 {
    public static void main(String[] args) {
        Solution s = new Puzzle837().new Solution();
        System.out.println(s.new21Game(21, 17, 10));
    }

    class Solution {
        public double new21Game(int n, int k, int maxPts) {
            double[] dp = new double[k + maxPts];
            dp[0] = 1.0d;

            double p = 1.0d / maxPts;

            int round = 1, start = 0, end = 0;
            while (round <= k) {
                double[] next = new double[k + maxPts];
                for (int x = k; x < next.length; x++) next[x] = dp[x];

                for (int i = start; i <= Math.min(end, k - 1); i++) {
                    for (int j = 1; j <= maxPts; j++) {
                        if (i + j < next.length) next[i + j] += dp[i] * p;
                    }
                }
                round++;
                start++;
                end += maxPts;
                dp = next;
            }

            double x = 0.0d, y = 0.0d;
            for (int i = 0; i < dp.length; i++) {
                if (i <= n) x += dp[i];
                else y += dp[i];
            }
            return x / (x + y);
        }
    }
}
