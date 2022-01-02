package p0500_;

/**
 * https://leetcode.com/problems/distinct-subsequences/
 *
 * @author half-dead
 */
public class Puzzle115_DistinctSubsequences {
    public static void main(String[] args) {
        Puzzle115_DistinctSubsequences p = new Puzzle115_DistinctSubsequences();
        Solution s = p.new Solution();
        System.out.println(s.numDistinct("rabbbit", "rabbit"));
        System.out.println(s.numDistinct("babgbag", "bag"));
    }

    class Solution {
        public int numDistinct(String s, String t) {
            int rows = s.length(), cols = t.length();
            int[][] dp = new int[rows + 1][cols + 1];
            for (int i = 0; i <= rows; i++) dp[i][0] = 1;

            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    char cs = s.charAt(i), ct = t.charAt(j);
                    if (cs != ct) {
                        dp[i + 1][j + 1] = dp[i][j + 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i][j] + dp[i][j + 1];
                    }
                }
            }
            return dp[rows][cols];
        }
    }
}
