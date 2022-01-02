package p0500_;

/**
 * https://leetcode.com/problems/interleaving-string/
 *
 * @author half-dead
 */
public class Puzzle097_InterleavingString {
    public static void main(String[] args) {
        Puzzle097_InterleavingString p = new Puzzle097_InterleavingString();
        Solution s = p.new Solution();
        System.out.println(s.isInterleave("db", "b", "cbb"));
    }

    class Solution {
        public boolean isInterleave(String s1, String s2, String s3) {
            int len1 = s1.length(), len2 = s2.length(), len3 = s3.length();
            if (len1 + len2 != len3) return false;

            boolean[][] dp = new boolean[len1 + 1][len2 + 1];
            dp[0][0] = true;
            for (int i = 0; i < len3; i++) {
                char c = s3.charAt(i);
                int row = Math.min(i, len1 - 1), col = i - 1 - row;
                while (row >= -1 && row < s1.length() && col >= -1 && col < s2.length()) {
                    char c1 = row >= 0 ? s1.charAt(row) : Character.MIN_VALUE;
                    char c2 = col >= 0 ? s2.charAt(col) : Character.MIN_VALUE;
                    if (row == -1) {
                        dp[0][col + 1] = dp[0][col] && c2 == c;
                    } else if (col == -1) {
                        dp[row + 1][0] = dp[row][0] && c1 == c;
                    } else {
                        dp[row + 1][col + 1] = (dp[row][col + 1] && (c == c1)) || (dp[row + 1][col] && (c == c2));
                    }
                    row--;
                    col++;
                }
            }
            return dp[len1][len2];
        }
    }
}
