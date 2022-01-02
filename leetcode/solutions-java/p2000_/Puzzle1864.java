package p2000_;

/**
 * https://leetcode.com/problems/minimum-number-of-swaps-to-make-the-binary-string-alternating/
 *
 * @author half-dead
 */
public class Puzzle1864 {

    class Solution {
        public int minSwaps(String s) {
            char[] cs = s.toCharArray();
            int len = s.length(), c0 = 0, c1;
            for (char c : cs) if (c == '0') c0++;
            c1 = len - c0;

            if (Math.abs(c0 - c1) > 1) return -1;

            int missed0 = 0, missed1 = 0;
            for (int i = 0; i < len; i += 2) {
                if (cs[i] != '0') missed0++;
                if (cs[i] != '1') missed1++;
            }
            return c0 == c1 ? Math.min(missed0, missed1) : (c0 > c1 ? missed0 : missed1);
        }
    }
}
