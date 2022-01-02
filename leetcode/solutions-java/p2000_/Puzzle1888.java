package p2000_;

/**
 * https://leetcode.com/problems/minimum-number-of-flips-to-make-the-binary-string-alternating/
 *
 * @author half-dead
 */
public class Puzzle1888 {

    class Solution {
        public int minFlips(String s) {
            char[] cs = s.toCharArray();
            int len = cs.length, res = len;
            for (char c = '0'; c <= '1'; c++) {
                int i = s.indexOf(c), cnt = 0;
                char exp = c;
                for (int j = 0; j < len; j++) {
                    cnt += cs[i] == exp ? 0 : 1;
                    i = (i + 1) % len;
                    exp = exp == '0' ? '1' : '0';
                }
                res = Math.min(res, cnt);
            }
            return res;
        }
    }
}
