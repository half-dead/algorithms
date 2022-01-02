package p2000_;

/**
 * https://leetcode.com/problems/largest-number-after-mutating-substring/
 *
 * @author half-dead
 */
public class Puzzle1946 {

    class Solution {
        public String maximumNumber(String num, int[] change) {
            char[] cs = num.toCharArray();
            boolean b = false;
            for (int i = 0; i < cs.length; i++) {
                char c = cs[i], d = (char) ('0' + change[c - '0']);
                if (c < d) {
                    b = true;
                    cs[i] = d;
                } else if (c > d && b) {
                    break;
                }
            }
            return new String(cs);
        }
    }
}
