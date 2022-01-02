package p1500_;

import util.Print;

/**
 * https://leetcode.com/problems/longest-common-subsequence/
 *
 * @author half-dead
 */
public class Puzzle1143 {
    public static void main(String[] args) {
        Solution s1 = new Puzzle1143().new Solution();
        N2DpSolution s2 = new Puzzle1143().new N2DpSolution();
//        System.out.println(s1.longestCommonSubsequence("abcde", "ace"));
//        System.out.println(s2.longestCommonSubsequence("abcde", "ace"));
        System.out.println(s1.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
        System.out.println(s2.longestCommonSubsequence("pmjghexybyrgzczy", "hafcdqbgncrcbihkd"));
    }

    // O(n*m) time, O(min(n,m)) space
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length(), len2 = text2.length();
            if (len1 < len2) return longestCommonSubsequence(text2, text1);

            int[] dp = new int[len2 + 1];
            char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
            for (int i = 0; i < len1; i++) {
                for (int j = 0, top = 0, topleft; j < len2; j++) {
                    topleft = top;
                    top = dp[j + 1];
                    dp[j + 1] = chars1[i] == chars2[j] ? (topleft + 1) : Math.max(top, dp[j]);
                }
            }
            return dp[len2];
        }
    }

    // O(n*m) time, O(n*m) space
    class N2DpSolution {
        public int longestCommonSubsequence(String text1, String text2) {
            int len1 = text1.length(), len2 = text2.length();
            int[][] dp = new int[len1 + 1][len2 + 1];
            char[] chars1 = text1.toCharArray(), chars2 = text2.toCharArray();
            for (int i = 0; i < len1; i++) {
                for (int j = 0; j < len2; j++) {
                    dp[i + 1][j + 1] = chars1[i] == chars2[j] ? (dp[i][j] + 1) : (Math.max(dp[i][j + 1], dp[i + 1][j]));
                }
            }
            Print.pt(dp);
            return dp[len1][len2];
        }
    }
}
