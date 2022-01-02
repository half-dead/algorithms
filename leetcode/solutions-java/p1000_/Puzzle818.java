package p1000_;

/**
 * https://leetcode.com/problems/race-car/
 *
 * @author half-dead
 */
public class Puzzle818 {

    class Solution {
        int[] dp = new int[10001];

        public int racecar(int t) {
            if (dp[t] > 0) return dp[t];

            int n = Integer.toBinaryString(t).length();
            if (t + 1 == (1 << n)) {
                dp[t] = n;
            } else {
                // reach (1<<n) -1, then turn left and reach target
                dp[t] = racecar((1 << n) - 1 - t) + n + 1;
                // reach (1<<(n-1)-1), then turn left and go back ((1<<m)-1) steps, then turn right and reach target
                for (int m = 0; m < n - 1; m++) {
                    dp[t] = Math.min(dp[t], racecar(t - (1 << (n - 1)) + (1 << m)) + n + m + 1);
                }
            }
            return dp[t];
        }
    }
}
