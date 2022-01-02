package p2000_;

/**
 * https://leetcode.com/problems/can-convert-string-in-k-moves/
 *
 * @author half-dead
 */
public class Puzzle1540 {

    public static void main(String[] args) {
        Solution s = new Puzzle1540().new Solution();
        System.out.println(s.canConvertString("input", "ouput", 9));
        System.out.println(s.canConvertString("abc", "bcd", 10));
        System.out.println(s.canConvertString("aab", "bbb", 27));
    }

    class Solution {
        public boolean canConvertString(String s, String t, int k) {
            if (s.length() != t.length()) {
                return false;
            }

            int len = s.length();
            int[] required = new int[27];
            for (int i = 0; i < len; i++) {
                char cs = s.charAt(i), ct = t.charAt(i);
                int shifts = 0;
                if (cs < ct) {
                    shifts = ct - cs;
                } else if (cs > ct) {
                    shifts = 26 - (cs - ct);
                }
                required[shifts]++;
            }

            int times = k / 26, mod = k % 26;
            for (int i = 1; i < 27; i++) {
                int available = i <= mod ? times + 1 : times;
                if (required[i] > available) {
                    return false;
                }
            }
            return true;
        }
    }
}
