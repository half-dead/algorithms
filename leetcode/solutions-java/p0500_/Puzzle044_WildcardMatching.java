package p0500_;

/**
 * https://leetcode.com/problems/wildcard-matching/
 *
 * @author half-dead
 */
public class Puzzle044_WildcardMatching {
    public static void main(String[] args) {
        Puzzle044_WildcardMatching p = new Puzzle044_WildcardMatching();
        Solution s = p.new Solution();
        System.out.println(s.isMatch("aa", "a"));
        System.out.println(s.isMatch("aa", "*"));
        System.out.println(s.isMatch("cb", "?a"));
        System.out.println(s.isMatch("adceb", "*a*b"));
        System.out.println(s.isMatch("acdcb", "a*c?b"));
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[0][0] = true;
            for (int i = 0; i < n; i++) {
                if (p.charAt(i) == '*') dp[i + 1][0] = true;
                else break;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    char cp = p.charAt(i), cs = s.charAt(j);
                    if (cp == cs || cp == '?') {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else if (cp == '*') {
                        boolean b = dp[i][j] || dp[i][j + 1];
                        dp[i + 1][j + 1] = b;
                        if (b) {
                            while (j < m) {
                                dp[i + 1][j + 1] = b;
                                j++;
                            }
                        }
                    }
                }
            }
            return dp[n][m];
        }
    }

}
