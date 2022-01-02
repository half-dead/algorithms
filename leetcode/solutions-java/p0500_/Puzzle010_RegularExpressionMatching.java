package p0500_;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * @author half-dead
 */
public class Puzzle010_RegularExpressionMatching {
    public static void main(String[] args) {
        Puzzle010_RegularExpressionMatching p = new Puzzle010_RegularExpressionMatching();
        Solution s = p.new Solution();
        System.out.println(s.isMatch("aaa", "ab*a"));
        System.out.println(s.isMatch("aasdfasdfasdfasdfas", "aasdf.*asdf.*asdf.*asdf.*s"));
        System.out.println(s.isMatch("aaa", "ab*a*c*a"));
        System.out.println(s.isMatch("ab", ".*c"));
        System.out.println(s.isMatch("aaa", "ab*ac*a"));
        System.out.println(s.isMatch("bbcacbabbcbaaccabc", "b*a*a*.c*bb*b*.*.*"));
    }

    class MyDpSolution {
        public boolean isMatch(String s, String p) {
            StringBuilder pattern = new StringBuilder();
            for (int i = 0; i < p.length(); i++) {
                char c = p.charAt(i);
                int next = i + 1;
                if (next < p.length() && p.charAt(next) == '*') {
                    if (c == '.') {
                        pattern.append('*');
                    } else {
                        pattern.append(Character.toUpperCase(c));
                    }
                    i++;
                } else {
                    pattern.append(c);
                }
            }

            int m = pattern.length(), n = s.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i < m; i++) {
                char c = pattern.charAt(i);
                if (c == '*' || Character.isUpperCase(c)) dp[i + 1][0] = true;
                else break;
            }

            for (int i = 0; i < pattern.length(); i++) {
                for (int j = 0; j < s.length(); j++) {
                    char cp = pattern.charAt(i), cs = s.charAt(j);
                    if (Character.isLowerCase(cp)) {
                        dp[i + 1][j + 1] = cp == cs && dp[i][j];
                    } else if (cp == '.') {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else if (Character.isUpperCase(cp)) {
                        char lower = Character.toLowerCase(cp);
                        if (lower != cs) {
                            dp[i + 1][j + 1] = dp[i][j + 1];
                        } else {
                            boolean b = dp[i][j] || dp[i][j + 1];
                            if (b) {
                                while (lower == cs) {
                                    dp[i + 1][j + 1] = b;
                                    if (++j < s.length()) {
                                        cs = s.charAt(j);
                                    } else {
                                        break;
                                    }
                                }
                                j--;
                            }
                        }
                    } else {
                        boolean b = dp[i][j] || dp[i][j + 1];
                        dp[i + 1][j + 1] = b;
                        if (b) {
                            while (++j < s.length()) {
                                dp[i + 1][j + 1] = true;
                            }
                        }
                    }
                }
            }
            print(dp);
            return dp[m][n];
        }

        private void print(boolean[][] dp) {
            for (boolean[] row : dp) {
                System.out.println(Arrays.toString(row));
            }
        }
    }

    class Solution {
        public boolean isMatch(String s, String p) {
            int m = s.length(), n = p.length();
            boolean[][] dp = new boolean[m + 1][n + 1];
            dp[0][0] = true;
            for (int i = 0; i < n; i++) {
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true;
                }
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    char cp = p.charAt(j), cs = s.charAt(i);
                    if (cp == '.' || cp == cs) {
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (cp == '*') {
                        if (p.charAt(j - 1) != cs && p.charAt(j - 1) != '.') {
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                        }
                    }
                }
            }
            return dp[m][n];
        }
    }

    class BottomUpDpSolution {
        public boolean isMatch(String text, String pattern) {
            int m = pattern.length(), n = text.length();
            boolean[][] dp = new boolean[n + 1][m + 1];
            dp[n][m] = true;

            for (int i = n; i >= 0; i--) {
                for (int j = m - 1; j >= 0; j--) {
                    char cp = pattern.charAt(j);
                    boolean firstMatch = i < n && (cp == text.charAt(i) || cp == '.');
                    if (j + 1 < m && pattern.charAt(j + 1) == '*') {
                        dp[i][j] = dp[i][j + 2] || firstMatch && dp[i + 1][j];
                    } else {
                        dp[i][j] = firstMatch && dp[i + 1][j + 1];
                    }
                }
            }
            return dp[0][0];
        }
    }

    class RecursionSolution {
        public boolean isMatch(String text, String pattern) {
            if (pattern.isEmpty()) {
                return text.isEmpty();
            }
            boolean firstMatch = !text.isEmpty() &&
                    (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

            if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
                return isMatch(text, pattern.substring(2)) ||
                        (firstMatch && isMatch(text.substring(1), pattern));
            } else {
                return firstMatch && isMatch(text.substring(1), pattern.substring(1));
            }
        }
    }

}
