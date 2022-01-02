package p2500_;

/**
 * https://leetcode.com/problems/maximum-product-of-the-length-of-two-palindromic-subsequences/
 *
 * @author half-dead
 */
public class Puzzle2002 {

    class Solution {
        public int maxProduct(String s) {
            int n = s.length(), mask = (1 << n) - 1, res = 0;
            int[] dp = new int[mask + 1];
            for (int state = 1; state <= mask; state++) {
                dp[state] = pl(s, state);
            }
            for (int left = mask - 1; left > 0; left--) {
                if (dp[left] * (n - dp[left]) <= res) continue;

                for (int base = mask ^ left, right = base; right > 0; right = (right - 1) & base) {
                    res = Math.max(res, dp[left] * dp[right]);
                }
            }
            return res;
        }

        // if state(s) is a palindrome, return its length
        // otherwise, return 0
        private int pl(String s, int state) {
            int i = 0, j = s.length() - 1, res = 0;
            while (i <= j) {
                if ((state & (1 << i)) == 0) i++;
                else if ((state & (1 << j)) == 0) j--;
                else if (s.charAt(i) != s.charAt(j)) return 0;
                else res += 1 + (i++ != j-- ? 1 : 0);
            }
            return res;
        }
    }
}
