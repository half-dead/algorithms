package p2000_;

/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 *
 * @author half-dead
 */
public class Puzzle1758 {
    class Solution {
        public int minOperations(String s) {
            boolean b = false;
            int c0 = 0, c1 = 0;
            for (char c : s.toCharArray()) {
                if ((c == '0') == b) c0++;
                else c1++;
                b = !b;
            }
            return Math.min(c0, c1);
        }
    }
}
