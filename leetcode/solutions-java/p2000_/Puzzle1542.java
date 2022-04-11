package p2000_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-longest-awesome-substring/
 *
 * @author half-dead
 */
public class Puzzle1542 {

    // dp, bit masking
    class Solution {
        public int longestAwesome(String s) {
            int n = s.length(), res = 1, state = 0;

            int[] dp = new int[1024], masks = new int[11];
            Arrays.fill(dp, n);
            dp[0] = -1;

            // only set masks[0-9], masks[10] is zero
            for (int i = 0; i < 10; i++) masks[i] = 1 << i;

            for (int i = 0; i < n; i++) {
                state = state ^ (1 << (s.charAt(i) - '0'));
                for (int j = 0; j <= 10; j++) {
                    res = Math.max(res, i - dp[state ^ masks[j]]);
                }
                dp[state] = Math.min(dp[state], i);
            }
            return res;
        }
    }
}
