package p1000_;

/**
 * https://leetcode.com/problems/non-negative-integers-without-consecutive-ones/
 *
 * @author half-dead
 */
public class Puzzle600 {

    public static void main(String[] args) {
        Solution s = new Puzzle600().new Solution();
        System.out.println(s.findIntegers(15));
        System.out.println(s.findIntegers(21));
    }

    // dp, fibonacci, O(logN) time & space
    class Solution {
        public int findIntegers(int n) {
            int[] dp = new int[32];
            dp[0] = 1;
            dp[1] = 2;
            for (int i = 2; i < 32; i++) dp[i] = dp[i - 1] + dp[i - 2];

            int ans = 0;
            String bs = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
            for (int m = bs.length(), i = m - 1; i >= 0; i--) {
                if (bs.charAt(i) == '1') {
                    ans += dp[i];
                    if (i + 1 < m && bs.charAt(i + 1) == '1') {
                        ans--;
                        break;
                    }
                }
            }
            return ans + 1;
        }
    }
}
