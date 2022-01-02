package p2000_;

/**
 * https://leetcode.com/problems/check-if-binary-string-has-at-most-one-segment-of-ones/
 *
 * @author half-dead
 */
public class Puzzle1784 {
    class Solution {
        public boolean checkOnesSegment(String s) {
            int p = s.lastIndexOf('1');
            return s.indexOf('0') == -1 || p < s.indexOf('0');
        }
    }
}
