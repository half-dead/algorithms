package p2000_;

/**
 * https://leetcode.com/problems/count-sorted-vowel-strings/
 *
 * @author half-dead
 */
public class Puzzle1641 {

    public static void main(String[] args) {
        Solution s = new Puzzle1641().new Solution();
        System.out.println(s.countVowelStrings(50));
    }

    class Solution {
        public int countVowelStrings(int n) {
            // 0 1 2 3 4
            // u o i e a
            // 1 2 3 4 5
            int[][] dp = new int[n + 1][6];
            for (int i = 0; i <= 5; i++) {
                dp[0][i] = 1;
            }

            for (int r = 1; r <= n; r++) {
                for (int c = 1; c <= 5; c++) {
                    dp[r][c] = dp[r][c - 1] + dp[r - 1][c];
                }
            }
            return dp[n][5];
        }
    }
}
