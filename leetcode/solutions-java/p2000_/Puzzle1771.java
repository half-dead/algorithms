package p2000_;

/**
 * https://leetcode.com/problems/maximize-palindrome-length-from-subsequences/
 *
 * @author half-dead
 */
public class Puzzle1771 {

    // dp, O(N^2) time & space, same as longest palindrome subsequence
    class Solution {
        public int longestPalindrome(String word1, String word2) {
            char[] cs = (word1 + word2).toCharArray();
            int m = word1.length(), n = m + word2.length(), res = 0;

            int[][] dp = new int[n][n];
            for (int i = 0; i < n; i++) dp[i][i] = 1;

            for (int w = 2; w <= n; w++) {
                for (int i = 0; i < n + 1 - w; i++) {
                    int j = i + w - 1;

                    if (cs[i] == cs[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                        if (i < m && j >= m) res = Math.max(res, dp[i][j]);
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
            return res;
        }
    }
}
