package p0500_;

/**
 * https://leetcode.com/problems/unique-substrings-in-wraparound-string/
 *
 * @author half-dead
 */
public class Puzzle467 {

    class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] dp = new int[128];
            int prev = ' ', cnt = 0, sum = 0;
            for (char c : p.toCharArray()) {
                if (c == prev + 1 || (prev == 'z' && c == 'a')) {
                    cnt++;
                } else {
                    cnt = 1;
                }
                dp[prev = c] = Math.max(dp[c], cnt);
            }
            for (char c = 'a'; c <= 'z'; c++) sum += dp[c];
            return sum;
        }
    }
}
