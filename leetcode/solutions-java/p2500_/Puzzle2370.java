package p2500_;

/**
 * https://leetcode.com/problems/longest-ideal-subsequence/
 *
 * @author half-dead
 */
public class Puzzle2370 {

    public static void main(String[] args) {
        Solution s = new Puzzle2370().new Solution();
        System.out.println(s.longestIdealString("pvjcci", 4));
    }

    // dp, O(2KN) time
    class Solution {
        public int longestIdealString(String s, int k) {
            int[] dp = new int[26];
            char[] cs = s.toCharArray();
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i];
                int idx = c - 'a', max = 0;
                for (int j = Math.max(0, idx - k); j <= Math.min(25, idx + k); j++) {
                    max = Math.max(max, dp[j]);
                }
                dp[idx] = max + 1;
            }

            int res = 0;
            for (int x : dp) {
                res = Math.max(res, x);
            }
            return res;
        }
    }
}
