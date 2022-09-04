package p2500_;

/**
 * https://leetcode.com/problems/largest-3-same-digit-number-in-string/
 *
 * @author half-dead
 */
public class Puzzle2264 {
    class Solution {
        public String largestGoodInteger(String num) {
            int i = 9;
            while (i >= 0) {
                String candidate = "" + i + i + i;
                if (num.contains(candidate)) {
                    return candidate;
                }
                i--;
            }
            return "";
        }
    }

}
