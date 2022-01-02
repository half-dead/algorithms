package p1000_;

/**
 * https://leetcode.com/problems/count-binary-substrings/
 *
 * @author half-dead
 */
public class Puzzle696 {

    class Solution {
        public int countBinarySubstrings(String s) {
            int zeros = 0, ones = 0, res = 0;
            char prev = ' ';
            for (char c : s.toCharArray()) {
                if (c == prev) {
                    if (c == '0') zeros++;
                    else ones++;
                } else {
                    if (c == '0') zeros = 1;
                    else ones = 1;
                }
                prev = c;
                if (zeros > 0 && ones > 0) res++;
                if (c == '0') ones--;
                else zeros--;
            }
            return res;
        }
    }
}
