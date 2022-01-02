package p2000_;

/**
 * https://leetcode.com/problems/first-day-where-you-have-been-in-all-the-rooms/
 *
 * @author half-dead
 */
public class Puzzle1997 {

    // dp
    class Solution {
        public int firstDayBeenInAllRooms(int[] nextVisit) {
            int mod = (int) 1e9 + 7, n = nextVisit.length;
            long[][] dp = new long[n][2];
            dp[0][0] = 0;
            dp[0][1] = 1;
            for (int i = 1; i < n; i++) {
                dp[i][0] = dp[i - 1][1] + 1;
                dp[i][1] = dp[i][0] + 1;
                if (nextVisit[i] != i) {
                    dp[i][1] = (dp[i][1] + dp[i - 1][1] - dp[nextVisit[i]][0] + 1 + mod) % mod;
                }
            }
            return (int) (dp[n - 1][0] % mod);
        }
    }
}
