package p2000_;

/**
 * https://leetcode.com/problems/number-of-ways-to-split-a-string/
 *
 * @author half-dead
 */
public class Puzzle1573 {

    class Solution {
        public int numWays(String s) {
            char[] cs = s.toCharArray();
            int c1 = 0, len = cs.length, mod = 1000000007;
            for (char c : cs) {
                if (c == '1') c1++;
            }
            if (c1 % 3 != 0) return 0;

            if (c1 == 0) {
                long temp = (long) (len - 1) * (len - 2) / 2;
                return (int) (temp % mod);
            }

            c1 /= 3;
            int start = 0, end = len - 1, left = 0, right = 0, cnt = 0;
            while (cnt <= c1) {
                if (cs[start++] == '0') {
                    if (cnt == c1) left++;
                } else {
                    cnt++;
                }
            }

            cnt = 0;
            while (cnt <= c1) {
                if (cs[end--] == '0') {
                    if (cnt == c1) right++;
                } else {
                    cnt++;
                }
            }
            long temp = ((long) left + 1) * (right + 1);
            return (int) (temp % mod);
        }
    }
}
