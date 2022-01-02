package p2000_;

/**
 * https://leetcode.com/problems/maximum-value-after-insertion/
 *
 * @author half-dead
 */
public class Puzzle1881 {

    class Solution {
        public String maxValue(String n, int x) {
            boolean pos = n.charAt(0) != '-';
            char c = (char) ('0' + x);
            if (pos) {
                int i = 0;
                for (; i < n.length(); i++) {
                    if (n.charAt(i) < c) {
                        break;
                    }
                }
                return n.substring(0, i) + x + n.substring(i);
            }

            int i = 1;
            for (; i < n.length(); i++) {
                if (n.charAt(i) > c) {
                    break;
                }
            }
            return n.substring(0, i) + x + n.substring(i);
        }
    }
}
