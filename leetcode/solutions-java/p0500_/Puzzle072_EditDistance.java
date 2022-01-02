package p0500_;

/**
 * https://leetcode.com/problems/edit-distance/
 *
 * @author half-dead
 */
public class Puzzle072_EditDistance {
    public static void main(String[] args) {
        Puzzle072_EditDistance p = new Puzzle072_EditDistance();
        Solution s = p.new Solution();
        System.out.println(s.minDistance("horse", "ros"));
        System.out.println(s.minDistance("initialization", "execution"));
    }

    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length(), n = word2.length();
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i < m + 1; i++) dp[i][0] = i;
            for (int j = 0; j < n + 1; j++) dp[0][j] = j;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (word1.charAt(i) == word2.charAt(j)) {
                        dp[i + 1][j + 1] = dp[i][j];
                    } else {
                        dp[i + 1][j + 1] = 1 + Math.min(dp[i][j], Math.min(dp[i][j + 1], dp[i + 1][j]));
                    }
                }
            }
            return dp[m][n];
        }
    }
}
