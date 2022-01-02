package p2000_;

/**
 * https://leetcode.com/problems/largest-odd-number-in-string/
 *
 * @author half-dead
 */
public class Puzzle1903 {

    class Solution {
        public String largestOddNumber(String num) {
            int i = num.length() - 1;
            while (i >= 0) {
                if ((num.charAt(i) - '0') % 2 == 1) break;
                i--;
            }
            return i == -1 ? "" : (num.substring(0, i + 1));
        }
    }
}
