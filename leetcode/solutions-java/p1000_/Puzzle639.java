package p1000_;

/**
 * https://leetcode.com/problems/decode-ways-ii/
 *
 * @author half-dead
 */
public class Puzzle639 {

    class Solution {
        public int numDecodings(String s) {
            int n = s.length(), mod = 1000000007;
            char[] chars = s.toCharArray();
            long[] dp = new long[n + 1];
            dp[0] = 1;
            for (int i = 0; i < n; i++) {
                char c = chars[i], prev;

                long one = c == '*' ? 9 : (c == '0' ? 0 : 1), two = 0;
                one *= dp[i];

                if (i > 0 && (prev = chars[i - 1]) != '0') {
                    if (prev == '*') {
                        if (c == '*') two = 15;
                        else if (c <= '6') two = 2;
                        else two = 1;
                    } else if (prev == '1') {
                        if (c == '*') two = 9;
                        else two = 1;
                    } else if (prev == '2') {
                        if (c == '*') two = 6;
                        else if (c <= '6') two = 1;
                    }
                    two *= dp[i - 1];
                }
                dp[i + 1] = (one + two) % mod;
            }
            return (int) dp[n];
        }
    }
}
