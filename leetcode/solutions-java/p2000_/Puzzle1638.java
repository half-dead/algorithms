package p2000_;

/**
 * https://leetcode.com/problems/count-substrings-that-differ-by-one-character/
 *
 * @author half-dead
 */
public class Puzzle1638 {
    public static void main(String[] args) {
        Solution s = new Puzzle1638().new Solution();
        s.countSubstrings("ab", "bb");
    }

    class Solution {
        public int countSubstrings(String s, String t) {
            int m = s.length(), n = t.length();
            char[] cs = s.toCharArray(), ct = t.toCharArray();
            int[][] dp = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    dp[i][j] = cs[i] == ct[j] ? 0 : 1;
                }
            }

            int res = 0;
            for (int len = 1; len <= Math.min(m, n); len++) {
                for (int i = 0; i < m; i++) {
                    for (int j = 0; j < n; j++) {

                        int diff = 0;
                        for (int k = 0; k < len && i + k < m && j + k < n; k++) {
                            diff += dp[i + k][j + k];
                            if (diff > 1) {
                                break;
                            }
                        }
                        if (diff == 1 && i + len <= m && j + len <= n) {
                            res++;
                        }
                    }
                }
            }
            return res;
        }
    }
}
