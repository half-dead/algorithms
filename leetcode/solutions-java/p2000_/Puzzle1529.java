package p2000_;

/**
 * https://leetcode.com/problems/bulb-switcher-iv/
 *
 * @author half-dead
 */
public class Puzzle1529 {

    class Solution {
        public int minFlips(String target) {
            int res = 0;
            int len = target.length();
            char prev = '0';
            for (int i = 0; i < len; i++) {
                char c = target.charAt(i);
                if (c != prev) {
                    prev = c;
                    res++;
                }
            }
            return res;
        }
    }
}
