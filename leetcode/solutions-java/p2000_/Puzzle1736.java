package p2000_;

/**
 * https://leetcode.com/problems/latest-time-by-replacing-hidden-digits/
 *
 * @author half-dead
 */
public class Puzzle1736 {

    class Solution {
        public String maximumTime(String time) {
            char[] cs = time.toCharArray();
            if (cs[4] == '?') cs[4] = '9';
            if (cs[3] == '?') cs[3] = '5';
            if (cs[1] == '?') cs[1] = cs[0] == '0' || cs[0] == '1' ? '9' : '3';
            if (cs[0] == '?') cs[0] = cs[1] > '3' ? '1' : '2';
            return new String(cs);
        }
    }
}
