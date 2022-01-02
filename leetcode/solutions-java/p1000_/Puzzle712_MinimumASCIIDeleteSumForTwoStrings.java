package p1000_;

/**
 * https://leetcode.com/problems/minimum-ascii-delete-sum-for-two-strings/
 *
 * @author half-dead
 */
public class Puzzle712_MinimumASCIIDeleteSumForTwoStrings {
    public static void main(String[] args) {
        Solution s = new Puzzle712_MinimumASCIIDeleteSumForTwoStrings().new Solution();
        int i = s.minimumDeleteSum("delete", "gdaeblcedteef");
        System.out.println(i);
    }

    class Solution {
        public int minimumDeleteSum(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            for (int i = len1 - 1; i >= 0; i--) {
                dp[i][len2] = dp[i + 1][len2] + s1.codePointAt(i);
            }
            for (int i = len2 - 1; i >= 0; i--) {
                dp[len1][i] = dp[len1][i + 1] + s2.codePointAt(i);
            }
            for (int i = len1 - 1; i >= 0; i--) {
                for (int j = len2 - 1; j >= 0; j--) {
                    int n1 = s1.codePointAt(i);
                    int n2 = s2.codePointAt(j);
                    if (n1 == n2) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        dp[i][j] = Math.min(dp[i][j + 1] + n2, dp[i + 1][j] + n1);
                    }
                }
            }
            return dp[0][0];
        }

        public int minimumDeleteSum2(String s1, String s2) {
            int len1 = s1.length(), len2 = s2.length();
            StringBuilder[][] dp = new StringBuilder[len1 + 1][len2 + 1];
            for (int i = 0; i < len1 + 1; i++) {
                for (int j = 0; j < len2 + 1; j++) {
                    dp[i][j] = new StringBuilder();
                }
            }

            for (int i = len1 - 1; i >= 0; i--) {
                clear(dp[i][len2]);
                dp[i][len2].append(dp[i + 1][len2]).append(s1.charAt(i));
            }
            for (int j = len2 - 1; j >= 0; j--) {
                clear(dp[len1][j]);
                dp[len1][j].append(dp[len1][j + 1]).append(s2.charAt(j));
            }
            for (int i = len1 - 1; i >= 0; i--) {
                for (int j = len2 - 1; j >= 0; j--) {
                    if (s1.charAt(i) == s2.charAt(j)) {
                        dp[i][j] = dp[i + 1][j + 1];
                    } else {
                        int a = sumAscii(dp[i + 1][j]) + s1.codePointAt(i);
                        int b = sumAscii(dp[i][j + 1]) + s2.codePointAt(j);
                        clear(dp[i][j]);
                        if (a < b) {
                            dp[i][j].append(dp[i + 1][j]).append(s1.charAt(i));
                        } else {
                            dp[i][j].append(dp[i][j + 1]).append(s2.charAt(j));
                        }
                    }

                }
            }
            print2(dp);
            return sumAscii(dp[0][0]);
        }

        private void print2(StringBuilder[][] dp) {
            for (StringBuilder[] s : dp) {
                System.out.print('[');
                for (StringBuilder b : s) {
                    System.out.printf("%11s ", b.toString());
                }
                System.out.print(']');
                System.out.println();
            }
            System.out.println();
        }

        private void clear(StringBuilder sb) {
            sb.delete(0, sb.length());
        }

        private int sumAscii(StringBuilder sb) {
            return sb.codePoints().sum();
        }
    }
}
