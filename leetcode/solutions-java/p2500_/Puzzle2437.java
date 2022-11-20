package p2500_;

/**
 * https://leetcode.com/problems/number-of-valid-clock-times/
 */
public class Puzzle2437 {
    class Solution {
        public int countTime(String time) {
            char h0 = time.charAt(0), h1 = time.charAt(1);
            int res = 1;
            if (time.charAt(4) == '?') res *= 10;
            if (time.charAt(3) == '?') res *= 6;
            if (h0 == '?' && h1 == '?') {
                res *= 24;
            } else if (h1 == '?') {
                res *= (h0 == '2' ? 4 : 10);
            } else if (h0 == '?') {
                res *= (h1 > '3' ? 2 : 3);
            }
            return res;
        }
    }
}
